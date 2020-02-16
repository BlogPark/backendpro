package com.yongming.backendpro.drools.mapper;

import com.yongming.backendpro.drools.model.EntityModel;

import java.util.List;

public interface EntityMapper {
    List<EntityModel> getEntityListByIds(List<String> idlist);
    EntityModel getSingleEntityByID(int id);
}
