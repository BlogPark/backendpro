package com.yongming.backendpro.project.drools.mapper;

import com.yongming.backendpro.project.drools.model.EntityModel;

import java.util.List;

public interface EntityMapper {
  /**
   * 按照ID列表查询实体信息
   *
   * @param list
   * @return
   */
  List<EntityModel> getEntityListByIds(List<String> list);

  /**
   * 按照ID查询实体信息
   *
   * @param id
   * @return
   */
  EntityModel getSingleEntityByID(int id);

  /**
   * 添加实体信息
   *
   * @param entityModel
   * @return
   */
  int addNewEntity(EntityModel entityModel);

  /**
   * 按照ID修改实体信息
   *
   * @param entityModel
   * @return
   */
  int updateEntityByID(EntityModel entityModel);

  /**
   * 查询实体列表
   *
   * @param entityModel
   * @return
   */
  List<EntityModel> getEntityList(EntityModel entityModel);
}
