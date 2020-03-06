package com.yongming.backendpro.project.drools.vo;

import lombok.Data;

@Data
public class RulePageSearchVO {
  private int pageIndex;
  private int pageSize;
  private String paramters;
}
