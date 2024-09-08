package org.jbunce.orderscatalogsrestfull.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.jbunce.orderscatalogsrestfull.persistance.entities.Catalog;
import org.jbunce.orderscatalogsrestfull.persistance.entities.Order;
import org.jbunce.orderscatalogsrestfull.persistance.repositories.IOrderRepository;
import org.jbunce.orderscatalogsrestfull.services.interfaces.ICatalogService;
import org.jbunce.orderscatalogsrestfull.services.interfaces.IOrderService;
import org.jbunce.orderscatalogsrestfull.common.BaseResponse;
import org.jbunce.orderscatalogsrestfull.common.BaseResponseFactory;
import org.jbunce.orderscatalogsrestfull.common.request.OrderRequest;
import org.jbunce.orderscatalogsrestfull.common.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository repository;

    @Autowired
    private ICatalogService catalogService;

    @Override
    public BaseResponse getAll() {
        List<OrderResponse> orders = repository.findAll().stream()
                .map(this::toOrderResponse).filter(order -> order.deletedAt() == null)
                .toList();

        return BaseResponseFactory.found("orders", orders);
    }

    @Override
    public BaseResponse getById(Long id) {
        Order order = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return BaseResponseFactory.found("order", toOrderResponse(order));
    }

    @Override
    public BaseResponse create(OrderRequest request) {
        Catalog catalog = catalogService.findOneAndEnsureExists(request.catalogId());

        Order order = toOrder(request);
        order.setCatalog(catalog);
        order.setTotal(catalog.getPrice() * order.getQuantity());

        Order savedOrder = repository.save(order);

        return BaseResponseFactory.created("order", toOrderResponse(savedOrder));
    }

    @Override
    public BaseResponse edit(OrderRequest request, Long aLong) {
        Order order = repository.findById(aLong).orElseThrow(EntityNotFoundException::new);
        Catalog catalog = catalogService.findOneAndEnsureExists(request.catalogId());

        update(order, request);
        order.setCatalog(catalog);
        order.setTotal(catalog.getPrice() * order.getQuantity());
        repository.save(order);

        return BaseResponseFactory.updated("order", toOrderResponse(order));
    }

    @Override
    public BaseResponse delete(Long aLong) {
        Order order = repository.findById(aLong).orElseThrow(EntityNotFoundException::new);
        order.setDeletedAt(LocalDateTime.now());
        repository.save(order);

        return BaseResponseFactory.deleted("order", toOrderResponse(order));
    }

    private Order toOrder(OrderRequest request) {
        Order order = new Order();

        order.setClientName(request.clientName());
        order.setClientEmail(request.clientEmail());
        order.setClientPhoneNumber(request.clientPhone());
        order.setQuantity(request.quantity());
        order.setCreatedAt(LocalDate.now());
        order.setUpdatedAt(LocalDate.now());
        order.setDeletedAt(null);

        return order;
    }

    private OrderResponse toOrderResponse(Order order) {
        return new OrderResponse(
                order.getOrderId(),
                order.getClientName(),
                order.getClientEmail(),
                order.getClientPhoneNumber(),
                order.getQuantity(),
                order.getTotal(),
                order.getCreatedAt(),
                order.getUpdatedAt(),
                order.getDeletedAt(),
                order.getCatalog().getCatalogId()
        );
    }

    private void update(Order order, OrderRequest request) {
        order.setClientName(request.clientName());
        order.setClientEmail(request.clientEmail());
        order.setClientPhoneNumber(request.clientPhone());
        order.setQuantity(request.quantity());
        order.setUpdatedAt(LocalDate.now());
    }
}
