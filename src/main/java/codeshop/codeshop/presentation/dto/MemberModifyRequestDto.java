package codeshop.codeshop.presentation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MemberModifyRequestDto {
    //TODO : 매번 반복되는 회원 검증 입력값을 공통으로 뽑아서 validate 할 수는 없을까?
    @NotNull(message = "이메일은 필수 입력값입니다")
    @Email(message = "잘못된 이메일 형식입니다")
    @Size(max = 255, message = "이메일 길이는 255자 이하여야 합니다")
    private String email;

    @NotNull(message = "비밀번호는 필수 입력값입니다")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 ~ 20자까지 허용됩니다")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
