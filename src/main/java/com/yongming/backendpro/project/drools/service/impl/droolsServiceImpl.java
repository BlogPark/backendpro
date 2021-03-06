package com.yongming.backendpro.project.drools.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yongming.backendpro.project.drools.mapper.*;
import com.yongming.backendpro.project.drools.model.*;
import com.yongming.backendpro.project.drools.service.droolsService;
import com.yongming.backendpro.project.drools.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class droolsServiceImpl implements droolsService {
  @Autowired EntityMapper entityMapper;
  @Autowired EntityDetailMapper entityDetailMapper;
  @Autowired RuleMapper ruleMapper;
  @Autowired TemplatesMapper templatesMapper;
  @Autowired FunctionMapper functionMapper;
  @Autowired GroupMapper groupMapper;
  @Autowired ProductMapper productMapper;

  @Override
  public PageInfo<RuleModel> getAllRulesForPage(RuleVO ruleVO) {
    PageHelper.startPage(ruleVO.getPageIndex(), ruleVO.getPageSize());
    RuleModel ruleModel = new RuleModel();
    ruleModel.setId(ruleVO.getId());
    ruleModel.setRuleCode(ruleVO.getRuleCode());
    ruleModel.setRuleName(ruleVO.getRuleName());
    ruleModel.setRuleGroup(ruleVO.getGroupName());
    List<RuleModel> list = ruleMapper.getRuleList(ruleModel);
    // 用PageInfo对结果进行包装
    PageInfo<RuleModel> page = new PageInfo<RuleModel>(list);
    return page;
  }

  @Override
  public int editRule(RuleModel ruleModel) {
    int rowCount = ruleMapper.updateRuleById(ruleModel);
    return rowCount;
  }

  @Override
  public int addNewRule(RuleModel ruleModel) {
    ruleModel.setCreateTime(new Date());
    int rowcount = ruleMapper.addRule(ruleModel);
    return rowcount;
  }

  @Override
  public RuleResponVO getSingleRule(String id) {
    RuleModel ruleModel = ruleMapper.getRuleById(Integer.valueOf(id));
    List<EntityModel> quoteEntities = new ArrayList<>();
    if (!StringUtils.isBlank(ruleModel.getQuoteEntities())) {
      quoteEntities =
          entityMapper.getEntityListByIds(Arrays.asList(ruleModel.getQuoteEntities().split(",")));
    }
    List<FunctionModel> quoteFunction = new ArrayList<>();
    if (!StringUtils.isBlank(ruleModel.getQuoteFunctions())) {
      quoteFunction =
          functionMapper.getFunctionByIds(Arrays.asList(ruleModel.getQuoteFunctions().split(",")));
    }
    TemplatesModel templatesModel = null;
    if (ruleModel.getTemplateId() != 0) {
      templatesModel = templatesMapper.getTemplateModel(String.valueOf(ruleModel.getTemplateId()));
    }
    RuleResponVO ruleResponVO = new RuleResponVO();
    ruleResponVO.setRule(ruleModel);
    ruleResponVO.setQuoteEntities(quoteEntities);
    ruleResponVO.setQuoteFunctions(quoteFunction);
    ruleResponVO.setTemplate(templatesModel);
    return ruleResponVO;
  }

  @Override
  public List<RuleModel> getRuleByIds(CommonRequestVO commonRequestVO) {
    List<RuleModel> ruleModels = ruleMapper.getRulesByIds((commonRequestVO.getIdList()));
    return ruleModels;
  }

  @Override
  public PageInfo<TemplatesModel> getTemplateList(TemplateVO templateVO) {
    PageHelper.startPage(templateVO.getPageIndex(), templateVO.getPageSize());
    TemplatesModel templatesModel = new TemplatesModel();
    templatesModel.setId(templateVO.getId());
    templatesModel.setTemplateName(templateVO.getTemplateName());
    List<TemplatesModel> list = templatesMapper.getTemplateList(templatesModel);
    // 用PageInfo对结果进行包装
    PageInfo<TemplatesModel> page = new PageInfo<>(list);
    return page;
  }

  @Override
  public int editTemplate(TemplatesModel templatesModel) {
    int rowCount = templatesMapper.updateTemplate(templatesModel);
    return rowCount;
  }

  @Override
  public int addNewTemplate(TemplatesModel templatesModel) {
    templatesModel.setCreateTime(new Date());
    int rowCount = templatesMapper.addNewTemplate(templatesModel);
    return rowCount;
  }

  @Override
  public TemplateResponseVO getSingleTemplate(String id) {
    TemplateResponseVO templateResponseVO = new TemplateResponseVO();
    TemplatesModel templatesModel = templatesMapper.getTemplateModel(id);
    List<FunctionModel> functionModelList = new ArrayList<>();
    List<EntityModel> entityModelList = new ArrayList<>();
    if (templatesModel != null) {
      if (!StringUtils.isBlank(templatesModel.getQuoteFunctions())) {
        functionModelList =
            functionMapper.getFunctionByIds(
                Arrays.asList(templatesModel.getQuoteFunctions().split(",")));
      }
      if (!StringUtils.isBlank(templatesModel.getQuoteEntities())) {
        entityModelList =
            entityMapper.getEntityListByIds(
                Arrays.asList(templatesModel.getQuoteEntities().split(",")));
      }
    }
    templateResponseVO.setEntityModelList(entityModelList);
    templateResponseVO.setFunctionModelList(functionModelList);
    templateResponseVO.setTemplatesModel(templatesModel);
    return templateResponseVO;
  }

  @Override
  public List<TemplatesModel> getTemplateForSelect() {
    List<TemplatesModel> list = templatesMapper.selectTemplateList();
    return list;
  }

  @Override
  public PageInfo<FunctionModel> getFunctionList(FunctionVO functionVO) {
    PageHelper.startPage(functionVO.getPageIndex(), functionVO.getPageSize());
    FunctionModel functionModel = new FunctionModel();
    functionModel.setId(functionVO.getId());
    functionModel.setFunctionName(functionVO.getFunctionName());
    functionModel.setFunctionDesc(functionVO.getFunctionDesc());
    List<FunctionModel> list = functionMapper.getAllFunctionList(functionModel);
    // 用PageInfo对结果进行包装
    PageInfo<FunctionModel> page = new PageInfo<>(list);
    return page;
  }

  @Override
  public int editFunction(FunctionModel functionModel) {
    int rowCount = functionMapper.updateFunction(functionModel);
    return rowCount;
  }

  @Override
  public int addNewFunction(FunctionModel functionModel) {
    functionModel.setCreateTime(new Date());
    int rowCount = functionMapper.addNewdata(functionModel);
    return rowCount;
  }

  @Override
  public FunctionModel getSingleFunction(String id) {
    FunctionModel functionModel = functionMapper.getFunctionByID(Integer.valueOf(id));
    return functionModel;
  }

  @Override
  public List<FunctionModel> getFunctionByIds(CommonRequestVO commonRequestVO) {
    List<FunctionModel> functionList = functionMapper.getFunctionByIds(commonRequestVO.getIdList());
    return functionList;
  }

  @Override
  public FunctionResponVO getFunctionById(String id) {
    FunctionModel functionModel = functionMapper.getFunctionByID(Integer.valueOf(id));
    List<String> entitsIds = Arrays.asList(functionModel.getQuoteEntities().split(","));
    List<EntityModel> entityModelList = entityMapper.getEntityListByIds(entitsIds);
    FunctionResponVO functionResponVO = new FunctionResponVO();
    functionResponVO.setQuoteEntities(entityModelList);
    functionResponVO.setFunctionModel(functionModel);
    return functionResponVO;
  }

  @Override
  public PageInfo<EntityModel> getEntityList(EntityVO entityVO) {
    PageHelper.startPage(entityVO.getPageIndex(), entityVO.getPageSize());
    EntityModel entityModel = new EntityModel();
    entityModel.setId(entityVO.getId());
    entityModel.setEntityName(entityVO.getEntityName());
    entityModel.setGroupId(entityVO.getGroupId());
    entityModel.setGroupName(entityVO.getGroupName());
    List<EntityModel> list = entityMapper.getEntityList(entityModel);
    // 用PageInfo对结果进行包装
    PageInfo<EntityModel> page = new PageInfo<EntityModel>(list);
    return page;
  }

  @Override
  public EntityModel getSingleEntity(String id) {
    EntityModel entityModele = entityMapper.getSingleEntityByID(Integer.valueOf(id));
    return entityModele;
  }

  @Override
  public List<EntityModel> getEntitiesByIds(CommonRequestVO commonRequestVO) {
    List<EntityModel> entitiesList = entityMapper.getEntityListByIds(commonRequestVO.getIdList());
    return entitiesList;
  }

  @Override
  public List<EntityDetailModel> getEntityInfo(String id) {
    return entityDetailMapper.getEntityDetailsByEntityID(id);
  }

  @Override
  public PageInfo<GroupModel> getGroupList(GroupVO groupVO) {
    PageHelper.startPage(groupVO.getPageIndex(), groupVO.getPageSize());
    GroupModel groupModel = new GroupModel();
    groupModel.setId(groupVO.getId());
    groupModel.setGroupName(groupVO.getGroupName());
    List<GroupModel> list = groupMapper.getGroupList(groupModel);
    // 用PageInfo对结果进行包装
    PageInfo<GroupModel> page = new PageInfo<>(list);
    return page;
  }

  @Override
  public int addNewGroup(GroupModel groupModel) {
    groupModel.setCreateTime(new Date());
    int rowCount = groupMapper.addGroup(groupModel);
    return rowCount;
  }

  @Override
  public GroupModel getSingleGroup(String id) {
    GroupModel groupModel = groupMapper.getGroupByid(Integer.valueOf(id));
    return groupModel;
  }

  @Override
  public int editGroup(GroupModel groupModel) {
    int rowCount = groupMapper.updateGroup(groupModel);
    return rowCount;
  }

  @Override
  public List<GroupModel> getGroupListForSelect() {
    return groupMapper.getGroupListForSelect();
  }

  @Override
  public PageInfo<CommonResponseVO> getList(CommonRequestVO commonRequestVO) {
    PageHelper.startPage(commonRequestVO.getPageIndex(), commonRequestVO.getPageSize());
    List<CommonResponseVO> list = null;
    if (commonRequestVO.getType() == 2) {
      // 查询实体信息
      list = entityMapper.getAllentity();
    } else if (commonRequestVO.getType() == 1) {
      // 查询函数信息
      list = functionMapper.getFunctionList();
    } else if (commonRequestVO.getType() == 3) {
      // 查询规则信息
      list = ruleMapper.getRuleListForQuote();
    }
    PageInfo<CommonResponseVO> page = new PageInfo<>(list);
    return page;
  }

  @Override
  public PageInfo<ProductModel> getProductListForPage(ProductVO productVO) {
    PageHelper.startPage(productVO.getPageIndex(), productVO.getPageSize());
    ProductModel productModel = new ProductModel();
    productModel.setId(productVO.getId());
    productModel.setProductCode(productVO.getProductCode());
    productModel.setProductName(productVO.getProductName());
    List<ProductModel> list = productMapper.getProductList(productModel);
    // 用PageInfo对结果进行包装
    PageInfo<ProductModel> page = new PageInfo<>(list);
    return page;
  }

  @Override
  public int addNewProduct(ProductModel productModel) {
    productModel.setCreateTime(new Date());
    return productMapper.addProduct(productModel);
  }

  @Override
  public int editProduct(ProductModel productModel) {
    return productMapper.updateProductById(productModel);
  }

  @Override
  public ProductResponVO getSingleProduct(String id) {
    ProductModel productModel = productMapper.getProductById(Integer.valueOf(id));
    ProductResponVO productResponVO = new ProductResponVO();
    productResponVO.setProduct(productModel);
    if(!StringUtils.isBlank(productModel.getQuoteRules())){
      List<ProductRuleModel> productRuleModelList=productMapper.getProductRuleByProductId(String.valueOf(productModel.getId()));
      List<RuleModel> ruleModelList=new ArrayList<>();
      for(ProductRuleModel ruleModel:productRuleModelList){
        ruleModelList.add(ruleMapper.getRuleById(ruleModel.getRuleId()));
      }
      productResponVO.setRules(ruleModelList);
    }
    return productResponVO;
  }

  @Override
  public int addNewProductRule(ProductRuleModel productRuleModel) {
    return productMapper.addNewProductRule(productRuleModel);
  }

  @Override
  public int editProductRule(ProductRuleModel productRuleModel) {
    return productMapper.updateProductRuleByID(productRuleModel);
  }
}
