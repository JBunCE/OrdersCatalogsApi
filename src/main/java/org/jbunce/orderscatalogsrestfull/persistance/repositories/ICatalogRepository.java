package org.jbunce.orderscatalogsrestfull.persistance.repositories;

import org.jbunce.orderscatalogsrestfull.persistance.entities.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatalogRepository extends JpaRepository<Catalog, Long> {
}
