package com.yongming.backendpro.drools.service;

import com.yongming.backendpro.drools.droolsmodel.DroolsTestModel;

public interface droolsBusinessService {

  // 查询所有产品
  // 查询单个产品的规则列表信息
  // 删除产品的规则信息
  // 添加产品的规则信息
  // 编辑产品的规则顺序信息
  /**
   * 创建产品规则文件
   *
   * @param productCode
   * @return
   */
  String createRuleFile(String productCode);

  /**
   * 执行规则
   *
   * @param productCode
   * @return
   */
  DroolsTestModel fireRuleFile(String productCode);
}
