package com.code.system.business.transport.controller;

import com.code.system.business.transport.model.Transport;
import com.code.system.business.transport.service.TransportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/transports")
public class TransportController {
    private final TransportService transportService;

    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping
    public List<Transport> listTransports() {
        return transportService.getTransports();
    }

    @GetMapping("{id}")
    public Transport getTransportById(@PathVariable("id") Integer id) {
        return transportService.getTransport(id);
    }

    @PostMapping
    public void addTransport(@RequestBody Transport transport) {
        transportService.addTransport(transport);
    }

    @DeleteMapping("{id}")
    public void deleteTransport(@PathVariable("id") Integer id) {
        transportService.deleteTransport(id);
    }


}
