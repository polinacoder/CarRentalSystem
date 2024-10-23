package com.code.system.business.extraservice.controller;

import com.code.system.business.extraservice.model.ExtraService;
import com.code.system.business.extraservice.service.ExtraServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/extra-services")
public class ExtraServiceController {
    private final ExtraServiceService extraServiceService;

    public ExtraServiceController(ExtraServiceService extraServiceService) {
        this.extraServiceService = extraServiceService;
    }

    @GetMapping
    public List<ExtraService> listExtraServices() {
        return extraServiceService.getExtraServices();
    }

    @GetMapping("{id}")
    public ExtraService getExtraServiceById(@PathVariable("id") Integer id) {
        return extraServiceService.getExtraService(id);
    }

    @PostMapping
    public void addExtraService(@RequestBody ExtraService extraService) {
        extraServiceService.addExtraService(extraService);
    }

    @DeleteMapping("{id}")
    public void deleteExtraService(@PathVariable("id") Integer id) {
        extraServiceService.deleteExtraService(id);
    }

}