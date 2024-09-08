package org.jbunce.orderscatalogsrestfull.services.interfaces.base;

import org.jbunce.orderscatalogsrestfull.common.BaseResponse;

public interface IBaseCrudService<R, ID> extends IBaseService {
    BaseResponse getAll();
    BaseResponse getById(ID id);
    BaseResponse create(R request);
    BaseResponse edit(R request, ID id);
    BaseResponse delete(ID id);
}
