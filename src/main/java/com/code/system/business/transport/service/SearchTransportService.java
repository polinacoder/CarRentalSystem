package com.code.system.business.transport.service;

import com.code.system.business.transport.dao.SearchTransportDao;
import com.code.system.business.transport.dto.SearchRequestDto;
import com.code.system.business.transport.model.Transport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchTransportService {
    private final SearchTransportDao searchTransportDao;

    public SearchTransportService(SearchTransportDao searchTransportDao) {
        this.searchTransportDao = searchTransportDao;
    }

    public List<Transport> searchTransports(SearchRequestDto searchRequestDto) {
        return searchTransportDao.searchTransports(searchRequestDto);
    }

}
