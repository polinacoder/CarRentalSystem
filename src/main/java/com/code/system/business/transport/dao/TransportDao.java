package com.code.system.business.transport.dao;

import com.code.system.business.transport.model.Transport;

import java.util.List;
import java.util.Optional;

public interface TransportDao {
    List<Transport> selectTransports();
    Optional<Transport> selectTransportById(int id);
    int insertTransport(Transport transport);
    int deleteTransport(int id);
}
