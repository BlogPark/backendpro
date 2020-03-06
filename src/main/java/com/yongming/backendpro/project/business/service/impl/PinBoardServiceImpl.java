package com.yongming.backendpro.project.business.service.impl;

import com.yongming.backendpro.project.business.mapper.PinBoardMapper;
import com.yongming.backendpro.project.business.model.PinBoardModel;
import com.yongming.backendpro.project.business.service.PinBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class PinBoardServiceImpl implements PinBoardService {
  @Autowired private PinBoardMapper pinBoardMapper;

  @Override
  public List<PinBoardModel> getAllPinBoard(HttpServletRequest request) {
    PinBoardModel pinBoardModel = new PinBoardModel();
    pinBoardModel.setUserId(1);
    List<PinBoardModel> result = pinBoardMapper.getAllPinboard(pinBoardModel);
    return result;
  }
}
