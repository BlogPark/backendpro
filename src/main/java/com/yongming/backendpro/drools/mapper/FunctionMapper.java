package com.yongming.backendpro.drools.mapper;

import com.yongming.backendpro.drools.model.FunctionModel;

import java.util.List;

public interface FunctionMapper {
  /**
   * 按照id列表查询函数列表
   *
   * @param ids
   * @return
   */
  List<FunctionModel> getFunctionByIds(List<String> ids);

  /**
   * 查询单个函数信息
   *
   * @param id
   * @return
   */
  FunctionModel getFunctionByID(int id);

  /**
   * 添加函数信息
   *
   * @param functionModel
   * @return
   */
  int addNewdata(FunctionModel functionModel);

  /**
   * 修改函数信息
   *
   * @param functionModel
   * @return
   */
  int updateFunction(FunctionModel functionModel);
}
