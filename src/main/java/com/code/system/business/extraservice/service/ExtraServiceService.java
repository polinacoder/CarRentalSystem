package com.code.system.business.extraservice.service;

import com.code.system.business.extraservice.dao.ExtraServiceDao;
import com.code.system.business.extraservice.model.ExtraService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ExtraServiceService {
    private final ExtraServiceDao extraServiceDao;

    public ExtraServiceService(ExtraServiceDao extraServiceDao) {
        this.extraServiceDao = extraServiceDao;
    }

    public List<ExtraService> getExtraServices() {
        return extraServiceDao.selectExtraServices();
    }

    public ExtraService getExtraService(int id) {
        return extraServiceDao.selectExtraServiceById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void addExtraService(ExtraService extraService) {
        int result = extraServiceDao.insertExtraService(extraService);
        if (result != 1) {
            throw new IllegalStateException();
        }
    }

    public void deleteExtraService(Integer id) {
        Optional<ExtraService> extraServices = extraServiceDao.selectExtraServiceById(id);
        extraServices.ifPresentOrElse(extraService -> {
            int result = extraServiceDao.deleteExtraService(id);
            if (result != 1) {
                throw new IllegalStateException();
            }
        }, () -> {
            throw new NoSuchElementException();
        });
    }
}