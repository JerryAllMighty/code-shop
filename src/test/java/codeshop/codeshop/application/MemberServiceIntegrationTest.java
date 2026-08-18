package codeshop.codeshop.application;

import codeshop.codeshop.infra.MemberRepository;
import codeshop.codeshop.presentation.dto.request.member.SignUpRequestDto;
import codeshop.codeshop.presentation.dto.response.member.SignUpResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class MemberServiceIntegrationTest {

    @Autowired
    private MemberServiceImpl memberService;

    @Autowired
    private MemberRepository memberRepository;

    private String email;

    private String password;

    @BeforeEach
    void setUp() {
        email = "test@email.com";
        password = "test_password";
    }

    @Test
    @DisplayName("정상 케이스인 경우 회원가입에 성공")
    void signUp_success() {
        //given
        SignUpResponseDto signUpResponseDto = memberService.signUp(
                new SignUpRequestDto(email, password));

        //when & then
        assertTrue(memberRepository.findById(signUpResponseDto.memberId()).isPresent());
    }
}
