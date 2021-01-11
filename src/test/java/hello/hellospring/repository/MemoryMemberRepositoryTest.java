package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository =new MemoryMemberRepository();

    @AfterEach //메서드 끝날때마다 실행
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result=repository.findById(member.getId()).get();
//        System.out.println("result = "+(result == member));

        //import org.junit.jupiter.api.Assertions;
//        Assertions.assertEquals(member,result);

        //import org.assertj.core.api.Assertions;
//        Assertions.assertThat(member).isEqualTo(result);

        //import static org.assertj.core.api.Assertions.*;
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName(){
        // 전체를 돌리면 에러
        // 이유 순서가 findAll()부터 실행되면서
        // spring1과 spring2가 미리 저장됨
        // 데이터 클리어를 해야됨
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        //shift + f6 변수 동시 변경
        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);
        //cmd + shift +enter 나머지 코딩 자동완성
        Member result=repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);


    }

    @Test
    public void findAll(){
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        //shift + f6 변수 동시 변경
        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result=repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}
