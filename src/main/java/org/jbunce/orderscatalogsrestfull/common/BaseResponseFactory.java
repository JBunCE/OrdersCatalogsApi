package org.jbunce.orderscatalogsrestfull.common;

import org.springframework.http.HttpStatus;

public class BaseResponseFactory {

    public static BaseResponse created(String name, Object data) {
        return BaseResponse.builder()
                .data(data)
                .message("The " + name + " was created successfully")
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .httpCode(201).build();
    }

    public static BaseResponse updated(String name, Object data) {
        return BaseResponse.builder()
                .data(data)
                .message("The " + name + " was updated successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .httpCode(200).build();
    }

    public static BaseResponse deleted(String name, Object data) {
        return BaseResponse.builder()
                .data(data)
                .message("The " + name + " was deleted successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .httpCode(200).build();
    }

    public static BaseResponse found(String name, Object data) {
        return BaseResponse.builder()
                .data(data)
                .message("The " + name + " was found successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .httpCode(200).build();
    }

    public static BaseResponse exception(Exception ex, HttpStatus status) {
        return BaseResponse.builder()
                .data(null)
                .message(ex.getLocalizedMessage())
                .httpStatus(status)
                .httpCode(status.value()).build();
    }

}
