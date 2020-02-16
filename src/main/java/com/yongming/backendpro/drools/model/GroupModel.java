package com.yongming.backendpro.drools.model;

import lombok.Data;

import java.util.Date;

@Data
public class GroupModel {
    private int id;
    /**
     * 分组名称
     */
    private String groupName;
    /**
     * 分组描述
     */
    private String groupDesc;
    /**
     * 分组类型
     */
    private String groupType;
    /**
     * 创建时间
     */
    private Date  createTime;
}
