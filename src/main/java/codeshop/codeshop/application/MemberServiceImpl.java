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
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        String email = signUpRequestDto.getEmail();
        memberRepository.findByEmail(email)
                .ifPresent(member -> {
                    throw new DuplicateMemberEmailException();
                });

        String password = signUpRequestDto.getPassword();
        //TODO : save는 왜 자바 컴파일러가 인식을 하고, 다른 find 함수는 왜쨰서 인식 못하는지?
        Member savedMember = memberRepository.save(Member.createForSignUp(email, passwordEncoder.encode(password)));
        return SignUpResponseDto.builder()
                .memberId(savedMember.getId())
                .memberEmail(savedMember.getEmail())
                .build();
    }

    @Override
    public Optional<Member> findMember(String email, String password) {
        return memberRepository.findByEmailAndPassword(email, passwordEncoder.encode(password));
//        //TODO : orElse와 orElseThrow가 차이가 있을지?
//        //TODO : 예외처리 어디에다가 두는게 좋을지?
//        //TODO : Optional.of로 감싸야하는 이유가 있는지? find 함수도 optional 리턴이 아닌지?
//        return Optional.of(memberRepository.findByEmailAndPassword(email, passwordEncoder.encode(password))
//                .orElseThrow(RuntimeException::new));
    }

    @Override
    public ModifyProfileResponseDto modifyProfile(ModifyProfileRequestDto modifyProfileRequestDto) {
        Member member = Member.createForUpdateProfile(modifyProfileRequestDto);
        memberRepository.updateProfile(member);
        return ModifyProfileResponseDto.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}

