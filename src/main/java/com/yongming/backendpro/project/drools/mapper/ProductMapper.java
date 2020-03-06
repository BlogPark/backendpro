package com.yongming.backendpro.project.drools.mapper;

import com.yongming.backendpro.project.drools.model.ProductModel;

import java.util.List;

public interface ProductMapper {
  /**
   * 查询规则列表
   *
   * @return
   */
  List<ProductModel> getProductList();

  /**
   * 查询规则
   *
   * @param id
   * @return
   */
  ProductModel getProductById(int id);

  /**
   * 添加规则
   *
   * @param ruleModel
   * @return
   */
  int addProduct(ProductModel ruleModel);

  /**
   * 修改规则
   *
   * @param ruleModel
   * @return
   */
  int updateProductById(ProductModel ruleModel);
}
