package org.jbunce.orderscatalogsrestfull.persistance.repositories;

import org.jbunce.orderscatalogsrestfull.persistance.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
