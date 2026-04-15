package codeshop.codeshop.application;

import codeshop.codeshop.domain.entity.Member;
import codeshop.codeshop.infra.MemberRepository;
import codeshop.codeshop.presentation.dto.SignUpRequestDto;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member signUp(SignUpRequestDto signUpRequestDto) {
        Member member = Member.from(signUpRequestDto);
        return memberRepository.save(member);
    }
}
