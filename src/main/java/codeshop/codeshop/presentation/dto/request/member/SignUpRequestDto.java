package codeshop.codeshop.presentation.dto.request.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record SignUpRequestDto(
        @NotNull(message = "이메일은 필수 입력값입니다")
        @Email(message = "잘못된 이메일 형식입니다")
        @Size(max = 255, message = "이메일 길이는 255자 이하여야 합니다")
        String email,

        @NotNull(message = "비밀번호는 필수 입력값입니다")
        @Size(min = 8, max = 20, message = "비밀번호는 8자 ~ 20자까지 허용됩니다")
        String password
) {
}
