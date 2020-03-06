package com.yongming.backendpro.project.drools.mapper;

import com.yongming.backendpro.project.drools.model.RuleModel;

import java.util.List;

public interface RuleMapper {
  /**
   * 查询规则列表
   *
   * @param list
   * @return
   */
  List<RuleModel> getRulesByIds(List<String> list);

  /**
   * 查询规则
   *
   * @param id
   * @return
   */
  RuleModel getRuleById(int id);

  /**
   * 添加规则
   *
   * @param ruleModel
   * @return
   */
  int addRule(RuleModel ruleModel);

  /**
   * 修改规则
   *
   * @param ruleModel
   * @return
   */
  int updateRuleById(RuleModel ruleModel);
}
