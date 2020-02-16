package com.yongming.backendpro.drools.model;

import lombok.Data;

import java.util.Date;

@Data
public class EntityDetailModel {
    /**
     * 自增主键
     */
    private int id;
    /**
     * 实体ID
     */
    private int entityId;
    /**
     * 实体名称
     */
    private String entityName;
    /**
     * 字段名称
     */
    private String fieldName;
    /**
     * 使用示例
     */
    private String usageExample;
    /**
     * 字段描述
     */
    private String fieldDesc;
    /**
     * 字段类型
     */
    private String fieldType;
    /**
     * 创建时间
     */
    private Date createTime;
}
