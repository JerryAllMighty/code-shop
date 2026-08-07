package codeshop.codeshop.common.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private final int statusCode;
    private final String businessCode;
    private final String message;
    private final LocalDateTime createdAt;

    private ErrorResponse(int statusCode, String businessCode, String message, LocalDateTime createdAt) {
        this.statusCode = statusCode;
        this.businessCode = businessCode;
        this.message = message;
        this.createdAt = createdAt;
    }

    public static ErrorResponse from(ErrorCode errorCode) {
        return new ErrorResponse(errorCode.getHttpStatus().value(), errorCode.getBusinessCode(),
                errorCode.getMessage(), LocalDateTime.now());
    }
}
