package codeshop.codeshop.domain.entity;

import codeshop.codeshop.presentation.dto.MemberModifyRequestDto;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    protected Member() {
    }

    private Member(String password) {
        this.password = password;
    }

    private Member(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Member createForSignUp(String email, String encryptedPassword) {
        return new Member(email, encryptedPassword);
    }

    public static Member createForUpdateProfile(MemberModifyRequestDto memberModifyRequestDto) {
        //TODO : 만약 회원정보 수정에 필요한 정보가 늘어난다면..? 그 떄는 엔티티와 여길 참조하는 모든 곳을 바꿔줘야하나? 더 좋은 방법은 없나?
        //TODO : dto를 레포지토리에 넘기는 방법은 어떤지?
        String encryptedPassword = memberModifyRequestDto.getPassword();
        return new Member(encryptedPassword);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
