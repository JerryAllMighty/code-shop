package codeshop.codeshop.application;

import codeshop.codeshop.domain.entity.Member;
import codeshop.codeshop.presentation.dto.SignUpRequestDto;

public interface MemberService {
    Member signUp(SignUpRequestDto signUpRequestDto);
}
