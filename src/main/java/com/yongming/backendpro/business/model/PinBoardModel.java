package com.yongming.backendpro.business.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PinBoardModel {
    private int id;
    private String title;
    private String content;
    private int remind;
    private Date remindTime;
    private int cacleRemind;
    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分",timezone = "GMT+8")
    private Date createTime;
    private int userId;
    private String userName;
    private int pinStatus;
}
