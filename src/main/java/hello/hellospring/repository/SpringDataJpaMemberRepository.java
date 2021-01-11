package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Spring Data Jpa 가 자동으로 등록해줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository{

    //JPQL select m from Member m where m.name=?
    @Override
    Optional<Member> findByName(String name);
}
