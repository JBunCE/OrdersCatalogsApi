package org.jbunce.orderscatalogsrestfull.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter @Setter @Builder
public class BaseResponse {
    public Object data;
    public String message;
    public boolean success;
    public HttpStatus httpStatus;
    public int httpCode;

    public ResponseEntity<BaseResponse> apply() {
        return new ResponseEntity<BaseResponse>(this, this.httpStatus);
    }
}
