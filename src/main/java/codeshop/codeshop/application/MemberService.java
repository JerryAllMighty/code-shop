package codeshop.codeshop.application;

import codeshop.codeshop.domain.entity.Member;
import codeshop.codeshop.presentation.dto.MemberModifyRequestDto;
import codeshop.codeshop.presentation.dto.SignUpRequestDto;

import java.util.Optional;

public interface MemberService {
    Member signUp(SignUpRequestDto signUpRequestDto);

    Optional<Member> findMember(String email, String password);

    void modifyProfile(MemberModifyRequestDto memberModifyRequestDto);
}
