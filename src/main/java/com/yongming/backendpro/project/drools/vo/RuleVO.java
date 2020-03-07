package com.yongming.backendpro.project.drools.vo;

import lombok.Data;

@Data
public class RuleVO {
  private int id;
  private String ruleName;
  private String ruleCode;
  private String groupName;
  private int pageIndex;
  private int pageSize;
}
