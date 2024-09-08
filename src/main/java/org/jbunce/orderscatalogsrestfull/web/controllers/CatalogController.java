package org.jbunce.orderscatalogsrestfull.web.controllers;

import org.jbunce.orderscatalogsrestfull.services.interfaces.ICatalogService;
import org.jbunce.orderscatalogsrestfull.common.request.CatalogRequest;
import org.jbunce.orderscatalogsrestfull.web.controllers.base.CrudControllerBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("catalog")
public class CatalogController extends CrudControllerBase<CatalogRequest, Long, ICatalogService> {
}
