package com.code.system.business.extraservice.dao;

import com.code.system.business.extraservice.model.ExtraService;

import java.util.List;
import java.util.Optional;

public interface ExtraServiceDao {
    List<ExtraService> selectExtraServices();
    Optional<ExtraService> selectExtraServiceById(int id);
    int insertExtraService(ExtraService extraService);
    int deleteExtraService(int id);
}