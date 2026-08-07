package codeshop.codeshop.common.exception;

public class ProductDataNotFoundException extends BusinessException {
    public ProductDataNotFoundException() {
        super(ErrorCode.PRODUCT_DATA_NOT_FOUND_EXCEPTION);
    }
}
