package org.jbunce.orderscatalogsrestfull.services.interfaces;

import org.jbunce.orderscatalogsrestfull.services.interfaces.base.IBaseCrudService;
import org.jbunce.orderscatalogsrestfull.common.request.OrderRequest;

public interface IOrderService extends IBaseCrudService<OrderRequest, Long> {
}
