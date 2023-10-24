package com._aux.backend.controller;

import com._aux.backend.model.Client;
import com._aux.backend.service.ClientService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
@Api(value = "Client Controller", tags = "Client Controller")
public class ClientController extends GenericController<Client, Long> {
    private final ClientService service;
    @Autowired
    public ClientController(ClientService service) {
        super(service);
        this.service = service;
    }
}
