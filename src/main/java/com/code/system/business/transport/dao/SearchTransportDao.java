package com.code.system.business.transport.dao;

import com.code.system.business.transport.dto.SearchRequestDto;
import com.code.system.business.transport.model.Transport;

import java.util.List;

public interface SearchTransportDao {
    List<Transport> searchTransports(SearchRequestDto searchRequestDto);

}
