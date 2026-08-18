package codeshop.codeshop.infra;

import codeshop.codeshop.domain.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@TestPropertySource(properties = "spring.sql.init.mode=never")
class MemberRepositoryTest {

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
    void findByEmail() {
        //when
        memberRepository.save(Member.createForSignUp(email, password));

        //then
        Optional<Member> foundMember = memberRepository.findByEmail(email);
        assertTrue(foundMember.isPresent());
        assertEquals(email, foundMember.get().getEmail());
    }
}