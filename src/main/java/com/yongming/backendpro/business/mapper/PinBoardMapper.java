package com.yongming.backendpro.business.mapper;

import com.yongming.backendpro.business.model.PinBoardModel;

import java.util.List;

public interface PinBoardMapper {
    List<PinBoardModel> getAllPinboard(PinBoardModel pinBoardModel);

    List<PinBoardModel> getRemindPinboard(PinBoardModel pinBoardModel);

    int addNewPinboard(PinBoardModel pinBoardModel);

    int updatePinStatus(PinBoardModel pinBoardModel);

    int updatePinRemind(PinBoardModel pinBoardModel);
}
