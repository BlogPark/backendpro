package com.yongming.backendpro.project.drools.mapper;

import com.yongming.backendpro.project.drools.model.GroupModel;

import java.util.List;

public interface GroupMapper {
  /**
   * 查询所有的分组
   *
   * @return
   */
  List<GroupModel> getGroupList();
  /**
   * 查询分组信息
   *
   * @param id
   * @return
   */
  GroupModel getGroupByid(int id);

  /**
   * 添加分组
   *
   * @param groupModel
   * @return
   */
  int addGroup(GroupModel groupModel);

  /**
   * 修改分组
   *
   * @param groupModel
   * @return
   */
  int updateGroup(GroupModel groupModel);
}
