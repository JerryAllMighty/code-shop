package codeshop.codeshop.application;

import codeshop.codeshop.domain.entity.Member;
import codeshop.codeshop.presentation.dto.request.member.ModifyProfileRequestDto;
import codeshop.codeshop.presentation.dto.request.member.SignUpRequestDto;
import codeshop.codeshop.presentation.dto.response.member.ModifyProfileResponseDto;
import codeshop.codeshop.presentation.dto.response.member.SignUpResponseDto;

import java.util.Optional;

public interface MemberService {
    SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto);

    Optional<Member> findMember(String email, String password);

    ModifyProfileResponseDto modifyProfile(ModifyProfileRequestDto modifyProfileRequestDto);
}
