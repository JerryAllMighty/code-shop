package codeshop.codeshop.application;

import codeshop.codeshop.common.exception.DuplicateMemberEmailException;
import codeshop.codeshop.domain.entity.Member;
import codeshop.codeshop.infra.MemberRepository;
import codeshop.codeshop.presentation.dto.request.member.SignUpRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

    @InjectMocks
    private MemberServiceImpl memberService;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    private String email;

    private String password;

    @BeforeEach
    void setUp() {
        email = "test@email.com";
        password = "test_password";
    }

    @Test
    @DisplayName("중복되는 회원 이메일이라서 예외 발생")
    void signUp_fail_duplicateMemberEmail() {
        //given
        Member savedMember = Member.createForSignUp(email, password);

        //when
        String sameEmail = "test@email.com";
        given(memberRepository.findByEmail(sameEmail)).willReturn(Optional.of(savedMember));

        //then
        assertThatThrownBy(() -> memberService.signUp(
                new SignUpRequestDto(sameEmail, "temp_password"))).isInstanceOf(DuplicateMemberEmailException.class);
    }
}