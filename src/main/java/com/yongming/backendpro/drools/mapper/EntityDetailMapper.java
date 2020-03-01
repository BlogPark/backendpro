package com.yongming.backendpro.drools.mapper;

import com.yongming.backendpro.drools.model.EntityDetailModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EntityDetailMapper {
    /**
     * 根据实体ID查询所有的实体项目
     *
     * @param entityId
     * @return
     */
    List<EntityDetailModel> getEntityDetailsByEntityID(@Param("entityId") String entityId);

    /**
     * 根据ID查询单个实体字段的明细
     *
     * @param id
     * @return
     */
    EntityDetailModel getSingleEntityDetailById(@Param("id") int id);

    /**
     * 添加新的实体字段
     *
     * @param entityDetailModel
     * @return
     */
    int addNewEntityDetai(EntityDetailModel entityDetailModel);

    /**
     * 修改单个实体信息
     *
     * @param entityDetailModel
     * @return
     */
    int updateEntityDetailByID(EntityDetailModel entityDetailModel);
}
