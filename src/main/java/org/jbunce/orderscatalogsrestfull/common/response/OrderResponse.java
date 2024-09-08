package org.jbunce.orderscatalogsrestfull.common.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record OrderResponse(
    Long id,
    String clientName,
    String clientEmail,
    String clientPhone,
    Long quantity,
    Double total,
    LocalDate createdAt,
    LocalDate updatedAt,
    LocalDateTime deletedAt,
    Long catalog
) { }
