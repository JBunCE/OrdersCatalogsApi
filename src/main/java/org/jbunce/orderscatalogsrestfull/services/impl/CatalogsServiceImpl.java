package org.jbunce.orderscatalogsrestfull.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.jbunce.orderscatalogsrestfull.persistance.entities.Catalog;
import org.jbunce.orderscatalogsrestfull.persistance.repositories.ICatalogRepository;
import org.jbunce.orderscatalogsrestfull.services.interfaces.ICatalogService;
import org.jbunce.orderscatalogsrestfull.common.BaseResponse;
import org.jbunce.orderscatalogsrestfull.common.BaseResponseFactory;
import org.jbunce.orderscatalogsrestfull.common.request.CatalogRequest;
import org.jbunce.orderscatalogsrestfull.common.response.CatalogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CatalogsServiceImpl implements ICatalogService {

    @Autowired
    private ICatalogRepository repository;

    @Override
    public BaseResponse getAll() {
        List<CatalogResponse> catalogs = repository.findAll().stream()
            .map(this::toCatalogResponse)
            .filter(catalog -> catalog.deletedAt() == null)
            .toList();

        return BaseResponseFactory.found("catalogs", catalogs);
    }

    @Override
    public BaseResponse getById(Long id) {
        Catalog catalog = findOneAndEnsureExists(id);
        return BaseResponseFactory.found("catalog", toCatalogResponse(catalog));
    }

    @Override
    public BaseResponse create(CatalogRequest request) {
        Catalog catalog = toCatalog(request);
        Catalog savedCatalog = repository.save(catalog);

        return BaseResponseFactory.created("catalog", toCatalogResponse(savedCatalog));
    }

    @Override
    public BaseResponse edit(CatalogRequest request, Long aLong) {
        Catalog catalog = findOneAndEnsureExists(aLong);

        update(catalog, request);
        repository.save(catalog);

        return BaseResponseFactory.updated("catalog", toCatalogResponse(catalog));
    }

    @Override
    public BaseResponse delete(Long aLong) {
        Catalog catalog = findOneAndEnsureExists(aLong);

        catalog.setDeletedAt(LocalDateTime.now());
        repository.save(catalog);

        return BaseResponseFactory.deleted("catalog", toCatalogResponse(catalog));
    }

    @Override
    public Catalog findOneAndEnsureExists(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    private Catalog toCatalog(CatalogRequest request) {
        Catalog catalog = new Catalog();

        catalog.setName(request.name());
        catalog.setDescription(request.description());
        catalog.setPrice(request.price());
        catalog.setStock(request.stock());
        catalog.setCreatedAt(LocalDate.now());
        catalog.setUpdatedAt(LocalDate.now());
        catalog.setDeletedAt(null);

        return catalog;
    }

    private CatalogResponse toCatalogResponse(Catalog catalog) {
        return new CatalogResponse(
            catalog.getCatalogId(),
            catalog.getName(),
            catalog.getDescription(),
            catalog.getPrice(),
            catalog.getStock(),
            catalog.getCreatedAt(),
            catalog.getUpdatedAt(),
            catalog.getDeletedAt()
        );
    }

    private void update(Catalog catalog, CatalogRequest request) {
        catalog.setName(request.name());
        catalog.setDescription(request.description());
        catalog.setPrice(request.price());
        catalog.setStock(request.stock());
        catalog.setUpdatedAt(LocalDate.now());
    }
}
