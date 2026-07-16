package codeshop.codeshop.infra;

import codeshop.codeshop.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    Optional<Member> findByEmailAndPassword(String email, String password);

    //TODO : clear 관련해서 블로그 글 찾아보기 (벌크 연산 시의 영속성 컨텍스트 불일치 문제)
    @Modifying(clearAutomatically = true)
    @Query("update Member m set m.password = :#{member.password} where m.email = :#{member.email}")
        //TODO : JPQL과 queryDsl은 어떤 기준으로 사용 판단을 세울 수 있을까?
        //TODO : @Param은 왜 쓰는걸까?
        //TODO : private 필드인데 jpql에서 바로 접근되는 이유는?
    Member updateProfile(Member member);
}
