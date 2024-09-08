package org.jbunce.orderscatalogsrestfull.common.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CatalogResponse(
    Long id,
    String name,
    String description,
    Double price,
    Integer stock,
    LocalDate createdAt,
    LocalDate updatedAt,
    LocalDateTime deletedAt
) { }
