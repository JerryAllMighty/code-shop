package codeshop.codeshop.application;

import codeshop.codeshop.domain.entity.Member;
import codeshop.codeshop.infra.MemberRepository;
import codeshop.codeshop.presentation.dto.SignUpRequestDto;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        validatEmail(email);

        String password = signUpRequestDto.getPassword();
        Member member = Member.createForSignUp(email, passwordEncoder.encode(password));
        return memberRepository.save(member);
    }

    private void validatEmail(String email) {
        memberRepository.findByEmail(email)
                .ifPresent(member -> {
                    throw new DuplicateKeyException("이미 사용 중인 이메일입니다");
                });
    }
}
