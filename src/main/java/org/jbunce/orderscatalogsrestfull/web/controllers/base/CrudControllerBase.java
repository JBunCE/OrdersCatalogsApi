package org.jbunce.orderscatalogsrestfull.web.controllers.base;

import org.jbunce.orderscatalogsrestfull.services.interfaces.base.IBaseCrudService;
import org.jbunce.orderscatalogsrestfull.common.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CrudControllerBase<RE, ID, S extends IBaseCrudService<RE, ID>> extends ControllerBase<S> {

    @GetMapping
    ResponseEntity<BaseResponse> getAll() {
        return service.getAll().apply();
    }

    @GetMapping("by")
    ResponseEntity<BaseResponse> getById(@RequestParam ID id) {
        return service.getById(id).apply();
    }

    @PostMapping
    ResponseEntity<BaseResponse> create(@RequestBody RE request) {
        return service.create(request).apply();
    }

    @PutMapping
    ResponseEntity<BaseResponse> edit(@RequestBody RE request, @RequestParam ID id) {
        return service.edit(request, id).apply();
    }

    @DeleteMapping
    ResponseEntity<BaseResponse> delete(@RequestParam ID id) {
        return service.delete(id).apply();
    }

}
