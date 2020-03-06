package com.yongming.backendpro.project.drools.droolsmodel;

import lombok.Data;

import java.util.List;

@Data
public class DroolsTestModel {
  private String name;
  private String classname;
  private int age;
  private List<String> hibbits;
  private String result;
}
