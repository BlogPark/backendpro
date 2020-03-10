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
    int rowcount = ruleMapper.addRule(ruleModel);
    return rowcount;
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
    int rowCount = functionMapper.addNewdata(functionModel);
    return rowCount;
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
}
