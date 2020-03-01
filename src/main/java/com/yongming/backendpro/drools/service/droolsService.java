package com.yongming.backendpro.drools.service;

import com.github.pagehelper.PageInfo;
import com.yongming.backendpro.drools.model.EntityDetailModel;
import com.yongming.backendpro.drools.model.EntityModel;
import com.yongming.backendpro.drools.model.RuleModel;
import com.yongming.backendpro.drools.vo.EntityVO;

import java.util.List;

public interface droolsService {
    // 获取所有规则
    PageInfo<RuleModel> getAllRulesForPage();

    // 获取所有模板
    // 获取所有函数
    // 修改规则
    // 修改模板
    // 修改函数
    // 按照实体ID查询实体信息
    // 按照实体字段ID查询实体字段信息
    // 添加规则
    // 添加模板
    // 添加函数
    // 获取所有分组信息
    // 添加分组信息
    // 提交实体变更申请
    // 查询实体变更申请
    // 获取所有实体列表
    PageInfo<EntityModel> getEntityList(EntityVO entityVO);

    //查询单个实体信息
    List<EntityDetailModel> getEntityInfo(String id);
}
