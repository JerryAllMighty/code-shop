package codeshop.codeshop.application;

import codeshop.codeshop.infra.MemberRepository;
import codeshop.codeshop.presentation.dto.SignUpRequestDto;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import codeshop.codeshop.domain.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
@ActiveProfiles("local")
class MemberServiceImplTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("Dto로부터 Member 객체를 정상적으로 만들고 DB에 저장한다")
    void signUp_success() {
        //given
        SignUpRequestDto signUpRequestDto = new SignUpRequestDto("test@naver.com", "encryptedPassword");

        //when
        Member savedMember = memberService.signUp(signUpRequestDto);
        memberRepository.findByEmail("test@naver.com")
                .ifPresent(member -> {
                            assertEquals(savedMember.getId(), member.getId());
                }
        );
    }

    @Test
    @DisplayName("회원 이메일이 중복되어 회원 가입에 실패한다")
    void signUp_validate_email() {
        //given
        SignUpRequestDto signUpRequestDto = new SignUpRequestDto("test@naver.com", "encryptedPassword");

        //when
        memberService.signUp(signUpRequestDto);
        SignUpRequestDto sameSignUpRequestDto = new SignUpRequestDto("test@naver.com", "encryptedPassword");

        //then
        assertThrows(DuplicateKeyException.class,
                () -> memberService.signUp(sameSignUpRequestDto));
    }
}