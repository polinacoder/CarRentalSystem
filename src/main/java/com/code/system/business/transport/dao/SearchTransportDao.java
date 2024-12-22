package com.code.system.business.transport.dao;

import com.code.system.business.transport.dto.SearchRequestDto;
import com.code.system.business.transport.model.Transport;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface SearchTransportDao {
    List<Transport> searchTransportsByType(Timestamp start, Timestamp end, String type);
    List<Transport> searchTransportsByTypeSubtype(Timestamp start, Timestamp end, String type,String subtype);
    List<Transport> searchTransportsByTypeSubtypeModel(Timestamp start,Timestamp end, String type,String subtype, String model);

}
