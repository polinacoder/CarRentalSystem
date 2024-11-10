package com.code.system.business.transport.controller;

import com.code.system.business.transport.dto.SearchRequestDto;
import com.code.system.business.transport.model.Transport;
import com.code.system.business.transport.service.SearchTransportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/transports")
public class TransportSearchController {
    private final SearchTransportService searchTransportService;

    public TransportSearchController(SearchTransportService searchTransportService) {
        this.searchTransportService = searchTransportService;
    }

    @PostMapping("/search")
    public List<Transport> searchTransport(@RequestBody SearchRequestDto searchRequestDto) {
        return searchTransportService.searchTransports(searchRequestDto);
    }

}
