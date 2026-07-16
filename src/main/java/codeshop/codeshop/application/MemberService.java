package codeshop.codeshop.application;

import codeshop.codeshop.domain.entity.Member;
import codeshop.codeshop.presentation.dto.MemberModifyRequestDto;
import codeshop.codeshop.presentation.dto.SignUpRequestDto;

import java.util.Optional;

public interface MemberService {
    Member signUp(SignUpRequestDto signUpRequestDto);

    Optional<Member> findMember(String email, String password);

    // TODO : update의 경우 리턴 값은 어떤 판단 기준으로 하는게 좋을지?
    Member modifyProfile(MemberModifyRequestDto memberModifyRequestDto);
}
