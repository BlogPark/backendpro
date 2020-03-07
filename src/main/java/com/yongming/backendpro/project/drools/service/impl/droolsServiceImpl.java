package com.yongming.backendpro.project.drools.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yongming.backendpro.project.drools.mapper.*;
import com.yongming.backendpro.project.drools.model.*;
import com.yongming.backendpro.project.drools.service.droolsService;
import com.yongming.backendpro.project.drools.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
