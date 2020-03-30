package com.yongming.backendpro.project.drools.vo;

import com.yongming.backendpro.project.drools.model.EntityModel;
import com.yongming.backendpro.project.drools.model.FunctionModel;
import com.yongming.backendpro.project.drools.model.ProductModel;
import com.yongming.backendpro.project.drools.model.ResultModel;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponVO {
  // 产品信息
  private ProductModel product;
  // 配置的规则信息
  private List<ResultModel> rules;
  // 引用的函数信息
  private List<FunctionModel> functionList;
  // 引用实体信息
  private List<EntityModel> entityList;
}
