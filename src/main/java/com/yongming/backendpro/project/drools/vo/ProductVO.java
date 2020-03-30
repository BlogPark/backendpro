package com.yongming.backendpro.project.drools.vo;

import lombok.Data;

@Data
public class ProductVO {
  private int id;
  private int pageIndex;
  private int pageSize;
  private String productCode;
  private String productName;
}
