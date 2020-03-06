package com.yongming.backendpro.project.drools.model;

import lombok.Data;

import java.util.Date;

@Data
public class ProductModel {
  private int id;
  private String productCode;
  private String productName;
  private String versionCode;
  private String ruleFilePath;
  private String blogPackage;
  private String quoteRules;
  private Date createTime;
}
