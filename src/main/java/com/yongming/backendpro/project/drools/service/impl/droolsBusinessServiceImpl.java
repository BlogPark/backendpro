package com.yongming.backendpro.project.drools.service.impl;

import com.yongming.backendpro.framework.redis.RedisCache;
import com.yongming.backendpro.project.drools.droolsmodel.DroolsTestModel;
import com.yongming.backendpro.project.drools.mapper.*;
import com.yongming.backendpro.project.drools.model.*;
import com.yongming.backendpro.project.drools.service.droolsBusinessService;
import org.apache.commons.lang3.StringUtils;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class droolsBusinessServiceImpl implements droolsBusinessService {

  @Autowired private ProductMapper productMapper;
  @Autowired private RuleMapper ruleMapper;
  @Autowired private TemplatesMapper templatesMapper;
  @Autowired private FunctionMapper functionMapper;
  @Autowired private EntityMapper entityMapper;

  @Autowired private RedisCache redisCache;

  @Autowired private KieServices kieServices;

  @Autowired private KieFileSystem kieFileSystem;

  @Autowired private KieModuleModel kieModuleModel;

  @Autowired private KieRepository kieRepository;

  @Override
  public String createRuleFile(String productCode) {
    ProductModel productModel = productMapper.getProductById(1);
    String fileName = productModel.getProductCode() + "_" + productModel.getVersionCode() + ".drl";
    String filePath = productModel.getRuleFilePath();
    File dir = new File(filePath);
    // 一、检查放置文件的文件夹路径是否存在，不存在则创建
    if (!dir.exists()) {
      dir.mkdirs(); // mkdirs创建多级目录
    }
    File checkFile = new File(filePath + "/" + fileName);
    FileWriter writer = null;
    try {
      // 二、检查目标文件是否存在，不存在则创建
      if (!checkFile.exists()) {
        checkFile.createNewFile(); // 创建目标文件
      }
      // 三、向目标文件中写入内容
      // FileWriter(File file, boolean append)，append为true时为追加模式，false或缺省则为覆盖模式
      writer = new FileWriter(checkFile, true);
      writer.append(getRuleContent(productModel.getQuoteRules(), productModel.getBlogPackage()));
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (null != writer) {
        try {
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return "success";
  }

  @Override
  public DroolsTestModel fireRuleFile(String productCode) {
    ProductModel productModel = productMapper.getProductById(1);
    String fileName = productModel.getProductCode() + "_" + productModel.getVersionCode() + ".drl";
    String filePath = productModel.getRuleFilePath() + "\\" + fileName;
    Resource resource = ResourceFactory.newFileResource(filePath);
    KieHelper kieHelper = new KieHelper();
    kieHelper.addResource(resource);
    KieSession kieSession = kieHelper.build().newKieSession();
    DroolsTestModel droolsTestModel = new DroolsTestModel();
    droolsTestModel.setName("张三");
    kieSession.insert(droolsTestModel);
    int k = kieSession.fireAllRules();
    System.out.println("共执行规则 " + k + " 次");
    kieSession.dispose();
    return droolsTestModel;
  }

  @Override
  public void buildRules(String s) {}

  /**
   * 组装产品规则信息 写入redis
   *
   * @param productCode
   * @return
   */
  @Override
  public String buildRuleToRedis(String productCode) {
    // 查询产品信息
    ProductModel productModel = productMapper.getProductByProductCode(productCode);
    if (productModel == null) {
      return "没有查到相关产品信息";
    }
    // 查询产品的规则信息
    List<ProductRuleModel> productRuleList =
        productMapper.getProductRuleByProductId(String.valueOf(productModel.getId()));
    if (productRuleList.size() < 1) {
      return "该产品没有配置相关规则";
    }
    // 声明变量信息
    // 引用字符串
    StringBuilder importString = new StringBuilder();
    // 函数字符串
    StringBuilder functionString = new StringBuilder();
    // 规则字符串
    StringBuilder ruleString = new StringBuilder();
    // 已经处理的实体引用
    List<String> entityList = new ArrayList<>();
    // 已经处理的函数引用
    List<String> functionList = new ArrayList<>();
    for (ProductRuleModel item : productRuleList) {
      // 查询产品关联的规则明细列表
      RuleModel ruleModel = ruleMapper.getRuleById(item.getRuleId());
      if (ruleModel == null) {
        continue;
      }
      List<String> quoteEntityList =
          StringUtils.isBlank(ruleModel.getQuoteEntities())
              ? new ArrayList<>()
              : Arrays.asList(ruleModel.getQuoteEntities().split(","));
      List<String> quoteFunctionList =
          StringUtils.isBlank(ruleModel.getQuoteFunctions())
              ? new ArrayList<>()
              : Arrays.asList(ruleModel.getQuoteFunctions().split(","));
      // 查询产品关联的函数信息
      if (quoteFunctionList.size() > 0) {
        for (String idItem : quoteFunctionList) {
          if (!functionList.contains(idItem)) {
            FunctionModel functionModel = functionMapper.getFunctionByID(Integer.valueOf(idItem));
            if (functionModel != null) {
              List<String> entitys =
                  StringUtils.isBlank(functionModel.getQuoteEntities())
                      ? new ArrayList<>()
                      : Arrays.asList(functionModel.getQuoteEntities().split(","));
              if (entitys.size() > 0) {
                quoteEntityList.removeAll(entitys);
                quoteEntityList.addAll(entitys);
              }
              String functionContent = functionModel.getFunctionContent().replaceAll("###", " ");
              functionString.append(functionContent);
            }
            functionList.add(idItem);
          }
        }
      }
      // 查询产品规则关联的实体信息
      if (quoteEntityList.size() > 0) {
        for (String entityItem : quoteEntityList) {
          if (!entityList.contains(entityItem)) {
            EntityModel entityModel = entityMapper.getSingleEntityByID(Integer.valueOf(entityItem));
            if (entityModel != null) {
              importString.append(entityModel.getEntityPackage());
            }
            entityList.add(entityItem);
          }
        }
      }
      ruleString.append(ruleModel.getRuleContent());
    }
    // 组装规则文本
    String ruleVersionString =
        importString.toString() + " " + functionString.toString() + " " + ruleString.toString();
    String redisProductKey = productModel.getProductCode() + "_" + productModel.getVersionCode();
    System.out.println("组装完成的规则字符串：" + ruleVersionString);
    // 按照版本号写入redis
    redisCache.setCacheObject(redisProductKey, ruleVersionString);
    return "success";
  }

  private String getRuleContent(String ruleListStr, String pageString) {
    StringBuilder stringBuilder = new StringBuilder();
    List<RuleModel> ruleModelList = ruleMapper.getRulesByIds(Arrays.asList(ruleListStr.split(",")));
    // 所有实体集合
    List<EntityModel> entityModelList = new ArrayList<>();
    // 所有函数集合
    List<FunctionModel> functionModels = new ArrayList<>();
    List<String> functionIdList = new ArrayList<>();
    List<String> entityIdList = new ArrayList<>();
    for (RuleModel item : ruleModelList) {
      if (!StringUtils.isBlank(item.getQuoteFunctions())) {
        List<String> quoteFunctions = Arrays.asList(item.getQuoteFunctions().split(","));
        for (String functionItem : quoteFunctions) {
          if (!functionIdList.contains(functionItem)) {
            FunctionModel functionModel =
                functionMapper.getFunctionByID(Integer.valueOf(functionItem));
            if (functionModel != null) {
              if (!StringUtils.isBlank(functionModel.getQuoteEntities())) {
                entityIdList.addAll(Arrays.asList(functionModel.getQuoteEntities().split(",")));
              }
            }
            functionIdList.add(functionItem);
          }
        }
      }
      entityIdList.addAll(Arrays.asList(item.getQuoteEntities().split(",")));
    }
    List<EntityModel> entityList = entityMapper.getEntityListByIds(entityIdList);
    // 开始组装规则文件内容
    stringBuilder.append("package " + pageString + ";");
    stringBuilder.append("\n");
    for (EntityModel entityItem : entityList) {
      stringBuilder.append("import  " + entityItem.getEntityPackage() + ";");
      stringBuilder.append("\n");
    }
    for (FunctionModel functionModel : functionModels) {
      stringBuilder.append(functionModel.getFunctionContent());
      stringBuilder.append("\n");
    }
    for (RuleModel runleItem : ruleModelList) {
      stringBuilder.append(runleItem.getRuleContent());
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }
}
