package com.yongming.backendpro.project.drools.service;

import com.github.pagehelper.PageInfo;
import com.yongming.backendpro.project.drools.model.*;
import com.yongming.backendpro.project.drools.vo.*;

import java.util.List;

public interface droolsService {
  // 获取所有规则
  PageInfo<RuleModel> getAllRulesForPage(RuleVO ruleVO);
  // 修改规则
  int editRule(RuleModel ruleModel);
  // 添加规则
  int addNewRule(RuleModel ruleModel);
  // 获取所有模板
  PageInfo<TemplatesModel> getTemplateList(TemplateVO templateVO);
  // 修改模板
  int editTemplate(TemplatesModel templatesModel);
  // 添加模板
  int addNewTemplate(TemplatesModel templatesModel);
  // 查询单个模板信息
  TemplateResponseVO getSingleTemplate(String id);
  // 获取所有函数
  PageInfo<FunctionModel> getFunctionList(FunctionVO functionVO);
  // 修改函数
  int editFunction(FunctionModel functionModel);
  // 添加函数
  int addNewFunction(FunctionModel functionModel);
  // 提交实体变更申请
  // 查询所有实体变更申请
  // 获取所有实体列表
  PageInfo<EntityModel> getEntityList(EntityVO entityVO);
  // 按照实体ID查询实体信息
  List<EntityDetailModel> getEntityInfo(String id);
  // 获取所有分组信息
  PageInfo<GroupModel> getGroupList(GroupVO groupVO);
  // 添加分组信息
  int addNewGroup(GroupModel groupModel);
  // 获取单条分组信息
  GroupModel getSingleGroup(String id);
  // 修改分组信息
  int editGroup(GroupModel groupModel);
}
