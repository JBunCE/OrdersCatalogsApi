package org.jbunce.orderscatalogsrestfull.common.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CatalogRequest(
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be less than 100 characters")
    String name,

    @NotBlank(message = "Description is required")
    @Size(max = 250, message = "Name must be less than 250 characters")
    String description,

    @NotNull(message = "Price is required")
    Double price,

    @NotNull(message = "Stock is required")
    Integer stock
) { }
