package com.yongming.backendpro.project.business.service;

import com.yongming.backendpro.project.business.model.PinBoardModel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PinBoardService {
  List<PinBoardModel> getAllPinBoard(HttpServletRequest request);
}
