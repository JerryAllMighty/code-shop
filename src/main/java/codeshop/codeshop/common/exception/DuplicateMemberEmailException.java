package codeshop.codeshop.common.exception;

public class DuplicateMemberEmailException extends BusinessException {
    public DuplicateMemberEmailException() {
        super(ErrorCode.DUPLICATE_MEMBER_EMAIL_EXCEPTION);
    }
}
