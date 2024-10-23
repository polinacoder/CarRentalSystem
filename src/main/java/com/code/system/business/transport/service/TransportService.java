package com.code.system.business.transport.service;

import com.code.system.business.transport.dao.TransportDao;
import com.code.system.business.transport.model.Transport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TransportService {
    private final TransportDao transportDao;

    public TransportService(TransportDao transportDao) {
        this.transportDao = transportDao;
    }

    public List<Transport> getTransports(){
        return transportDao.selectTransports();
    }

    public Transport getTransport(int id) {
        return transportDao.selectTransportById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void addTransport(Transport transport) {
        int result = transportDao.insertTransport(transport);
        if (result != 1) {
            throw new IllegalStateException();
        }
    }
    public void deleteTransport(Integer id) {
        Optional<Transport> transports = transportDao.selectTransportById(id);
        transports.ifPresentOrElse(transport -> {
            int result = transportDao.deleteTransport(id);
            if (result != 1) {
                throw new IllegalStateException();
            }
        }, () -> {
            throw new NoSuchElementException();
        });
    }
}