package codeshop.codeshop.application;

import codeshop.codeshop.domain.entity.Member;
import codeshop.codeshop.infra.MemberRepository;
import codeshop.codeshop.presentation.dto.SignUpRequestDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberServiceImpl(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Member signUp(SignUpRequestDto signUpRequestDto) {
        String email = signUpRequestDto.getEmail();
        String password = signUpRequestDto.getPassword();
        Member member = Member.createMemberWhenSignUp(email, passwordEncoder.encode(password));
        return memberRepository.save(member);
    }
}
