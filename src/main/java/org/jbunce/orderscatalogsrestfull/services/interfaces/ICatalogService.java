package org.jbunce.orderscatalogsrestfull.services.interfaces;

import org.jbunce.orderscatalogsrestfull.persistance.entities.Catalog;
import org.jbunce.orderscatalogsrestfull.services.interfaces.base.IBaseCrudService;
import org.jbunce.orderscatalogsrestfull.common.request.CatalogRequest;

public interface ICatalogService extends IBaseCrudService<CatalogRequest, Long> {

    Catalog findOneAndEnsureExists(Long id);

}
