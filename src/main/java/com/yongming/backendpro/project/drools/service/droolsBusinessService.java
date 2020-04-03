package com.yongming.backendpro.project.drools.service;

import com.yongming.backendpro.project.drools.droolsmodel.DroolsTestModel;

public interface droolsBusinessService {

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

  void buildRules(String s);

  /**
   * 组装产品关联规则信息写入redis
   *
   * @param productCode
   * @return
   */
  String buildRuleToRedis(String productCode);
}
