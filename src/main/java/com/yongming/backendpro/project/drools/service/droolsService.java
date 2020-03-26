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
  // 查询模板列表
  List<TemplatesModel> getTemplateForSelect();
  // 获取所有函数
  PageInfo<FunctionModel> getFunctionList(FunctionVO functionVO);
  // 修改函数
  int editFunction(FunctionModel functionModel);
  // 添加函数
  int addNewFunction(FunctionModel functionModel);
  // 查询单个函数信息
  FunctionModel getSingleFunction(String id);
  // 根据IDS查询函数列表
  List<FunctionModel> getFunctionByIds(CommonRequestVO commonRequestVO);
  // 查询单个函数的信息
  FunctionResponVO getFunctionById(String id);
  // 提交实体变更申请
  // 查询所有实体变更申请
  // 获取所有实体列表
  PageInfo<EntityModel> getEntityList(EntityVO entityVO);
  // 查询单个实体信息
  EntityModel getSingleEntity(String id);
  // 根据IDS查询实体集
  List<EntityModel> getEntitiesByIds(CommonRequestVO commonRequestVO);
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
  // 为下拉框准备分组信息
  List<GroupModel> getGroupListForSelect();
  // 查询实体或者函数列表
  PageInfo<CommonResponseVO> getList(CommonRequestVO commonRequestVO);
}
