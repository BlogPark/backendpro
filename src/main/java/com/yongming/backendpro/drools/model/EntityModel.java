package com.yongming.backendpro.drools.model;

import lombok.Data;

import java.util.Date;

@Data
public class EntityModel {
    /**
     * 自增主键
     */
    private int id;
    /**
     * 实体名称
     */
    private String entityName;
    /**
     * 实体所在包名
     */
    private String entityPackage;
    /**
     * 实体描述
     */
    private String entityDesc;
    /**
     * 实体备注
     */
    private String eneityRemark;
    /**
     * 分组ID
     */
    private int groupId;
    /**
     * 分组名称
     */
    private String groupName;
    /**
     * 创建时间
     */
    private Date createTime;
}
