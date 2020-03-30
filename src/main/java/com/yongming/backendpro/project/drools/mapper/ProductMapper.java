package com.yongming.backendpro.project.drools.mapper;

import com.yongming.backendpro.project.drools.model.ProductModel;
import com.yongming.backendpro.project.drools.model.ProductRuleModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
  /**
   * 查询规则列表
   *
   * @return
   */
  List<ProductModel> getProductList(ProductModel productModel);

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

  /**
   * 查询单个产品信息
   *
   * @param id
   * @return
   */
  ProductModel getSingleProductById(@Param("id") String id);

  /**
   * 查询产品的所有规则
   *
   * @param productId
   * @return
   */
  List<ProductRuleModel> getProductRuleByProductId(@Param("productId") String productId);

  /**
   * 添加新的产品规则
   *
   * @param productRuleModel
   * @return
   */
  int addNewProductRule(ProductRuleModel productRuleModel);

  /**
   * 修改产品规则
   *
   * @param productRuleModel
   * @return
   */
  int updateProductRuleByID(ProductRuleModel productRuleModel);
}
