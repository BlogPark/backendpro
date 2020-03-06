package com.yongming.backendpro.project.business.controller;

import com.yongming.backendpro.project.business.model.PinBoardModel;
import com.yongming.backendpro.project.business.service.PinBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/pinboard")
public class PinBoardController {
  @Autowired private PinBoardService pinBoardService;

  @GetMapping("/get")
  public List<PinBoardModel> getAllPinboard(HttpServletRequest request) {
    return pinBoardService.getAllPinBoard(request);
  }
}
