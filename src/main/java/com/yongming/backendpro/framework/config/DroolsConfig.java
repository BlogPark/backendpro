package com.yongming.backendpro.framework.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.model.KieModuleModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

  @Bean
  public KieServices getKieServices() {
    KieServices kieServices = KieServices.Factory.get();
    return kieServices;
  }

  @Bean
  public KieFileSystem getKieFileSystem() {
    KieServices kieServices = KieServices.Factory.get();
    return kieServices.newKieFileSystem();
  }

  @Bean
  KieRepository getKieRepository() {
    KieServices kieServices = KieServices.Factory.get();
    return kieServices.getRepository();
  }

  @Bean
  KieModuleModel getKieModule() {
    KieServices kieServices = KieServices.Factory.get();
    return kieServices.newKieModuleModel();
  }
}
