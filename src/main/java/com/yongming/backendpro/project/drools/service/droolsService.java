package com.yongming.backendpro.project.drools.service;

import com.github.pagehelper.PageInfo;
import com.yongming.backendpro.project.drools.model.*;
import com.yongming.backendpro.project.drools.vo.*;

import java.util.List;

public interface droolsService {
  // 获取所有规则
  PageInfo<RuleModel> getAllRulesForPage(RuleVO ruleVO);
  // 修改规则
  // 添加规则
  // 获取所有模板
  PageInfo<TemplatesModel> getTemplateList(TemplateVO templateVO);
  // 修改模板
  // 添加模板
  // 获取所有函数
  PageInfo<FunctionModel> getFunctionList(FunctionVO functionVO);
  // 修改函数
  // 添加函数

  // 提交实体变更申请
  // 查询所有实体变更申请

  // 获取所有实体列表
  PageInfo<EntityModel> getEntityList(EntityVO entityVO);
  // 按照实体ID查询实体信息
  List<EntityDetailModel> getEntityInfo(String id);
  // 获取所有分组信息
  PageInfo<GroupModel> getGroupList(GroupVO groupVO);
  // 添加分组信息
}
