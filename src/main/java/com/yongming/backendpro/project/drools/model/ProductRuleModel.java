package com.yongming.backendpro.project.drools.model;

import lombok.Data;

@Data
public class ProductRuleModel {
  private int id;
  private int productId;
  private String productCode;
  private int ruleId;
  private int orderIndex;
}
