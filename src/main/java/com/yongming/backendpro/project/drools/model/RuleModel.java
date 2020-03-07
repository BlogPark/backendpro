package com.yongming.backendpro.project.drools.model;

import lombok.Data;

import java.util.Date;

@Data
public class RuleModel {
  /** 自增主键 */
  private int id;
  /** 规则编码 */
  private String ruleCode;
  /** 规则名称 */
  private String ruleName;
  /** 规则分组名称 */
  private String ruleGroup;
  /** 模板ID */
  private int templateId;
  /** 规则内容 */
  private String ruleContent;
  /** 引用实体集合 */
  private String quoteEntities;
  /** 引用函数集合 */
  private String quoteFunctions;
  /** 创建时间 */
  private Date createTime;
}
