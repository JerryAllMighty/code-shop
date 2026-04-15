package codeshop.codeshop.domain.entity;

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

    private Member(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Member createForSignUp(String email, String encryptedPassword) {
        return new Member(email, encryptedPassword);
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
