package org.jbunce.orderscatalogsrestfull.web.controllers.base;

import org.jbunce.orderscatalogsrestfull.services.interfaces.base.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class ControllerBase<S extends IBaseService> {

    @Autowired
    protected S service;

    @GetMapping("health")
    public String health() {
        return "OK";
    }

}
