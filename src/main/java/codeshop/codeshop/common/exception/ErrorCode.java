package codeshop.codeshop.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    PRODUCT_DATA_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "prd-01", "상품 데이터를 조회할 수 없습니다"),
    DUPLICATE_MEMBER_EMAIL_EXCEPTION(HttpStatus.CONFLICT, "mbr-01", "이미 존재하는 회원 이메일입니다");

    private final HttpStatus httpStatus;
    private final String businessCode;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String businessCode, String message) {
        this.httpStatus = httpStatus;
        this.businessCode = businessCode;
        this.message = message;
    }
}
