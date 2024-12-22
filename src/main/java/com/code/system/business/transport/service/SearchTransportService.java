package com.code.system.business.transport.service;

import com.code.system.business.transport.dao.SearchTransportDao;
import com.code.system.business.transport.dto.SearchRequestDto;
import com.code.system.business.transport.model.Transport;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SearchTransportService {
    private final SearchTransportDao searchTransportDao;

    public SearchTransportService(SearchTransportDao searchTransportDao) {
        this.searchTransportDao = searchTransportDao;
    }

    public List<Transport> searchTransports(SearchRequestDto searchRequestDto) {
        Timestamp start = searchRequestDto.getStartRentDate();
        Timestamp end = searchRequestDto.getEndRentDate();
        if (searchRequestDto.getSubtype() != null && searchRequestDto.getModel() != null) {
            return searchTransportDao.searchTransportsByTypeSubtypeModel(start,end,
                        searchRequestDto.getType(),
                        searchRequestDto.getSubtype(),
                        searchRequestDto.getModel()
                );
            } else if (searchRequestDto.getSubtype() != null) {
                return searchTransportDao.searchTransportsByTypeSubtype(start,end,
                        searchRequestDto.getType(),
                        searchRequestDto.getSubtype()
                );
            } else {
                return searchTransportDao.searchTransportsByType(start,end,searchRequestDto.getType());
            }
    }

}
