package org.jbunce.orderscatalogsrestfull.web.controllers;

import org.jbunce.orderscatalogsrestfull.services.interfaces.IOrderService;
import org.jbunce.orderscatalogsrestfull.common.request.OrderRequest;
import org.jbunce.orderscatalogsrestfull.web.controllers.base.CrudControllerBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController extends CrudControllerBase<OrderRequest, Long, IOrderService> {
}
