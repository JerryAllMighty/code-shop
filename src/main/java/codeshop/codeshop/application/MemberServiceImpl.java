package codeshop.codeshop.application;

import codeshop.codeshop.common.exception.DuplicateMemberEmailException;
import codeshop.codeshop.domain.entity.Member;
import codeshop.codeshop.infra.MemberRepository;
import codeshop.codeshop.presentation.dto.request.member.SignUpRequestDto;
import codeshop.codeshop.presentation.dto.request.member.ModifyProfileRequestDto;
import codeshop.codeshop.presentation.dto.response.member.ModifyProfileResponseDto;
import codeshop.codeshop.presentation.dto.response.member.SignUpResponseDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberServiceImpl(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        String email = signUpRequestDto.email();
        memberRepository.findByEmail(email)
                .ifPresent(member -> {
                    throw new DuplicateMemberEmailException();
                });

        String password = signUpRequestDto.password();
        //TODO : save는 왜 자바 컴파일러가 인식을 하고, 다른 find 함수는 왜쨰서 인식 못하는지?
        Member savedMember = memberRepository.save(Member.createForSignUp(email, passwordEncoder.encode(password)));
        return new SignUpResponseDto(
                savedMember.getId(), savedMember.getEmail()
        );
    }

    @Override
    public Optional<Member> findMember(String email, String password) {
        return memberRepository.findByEmailAndPassword(email, passwordEncoder.encode(password));
    }

    @Override
    @Transactional
    public ModifyProfileResponseDto modifyProfile(ModifyProfileRequestDto modifyProfileRequestDto) {
        Member member = Member.createForUpdateProfile(modifyProfileRequestDto);
        memberRepository.updateProfile(member);
        return new ModifyProfileResponseDto(
                member.getEmail(), member.getPassword()
        );
    }
}

