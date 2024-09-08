package org.jbunce.orderscatalogsrestfull.common.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderRequest(
    @NotBlank(message = "clientName is required")
    String clientName,

    @NotBlank(message = "clientEmail is required")
    String clientEmail,

    @NotBlank(message = "clientPhone is required")
    String clientPhone,

    @NotNull(message = "Quantity is required")
    Long quantity,

    @NotNull(message = "CatalogId is required")
    Long catalogId
) { }
