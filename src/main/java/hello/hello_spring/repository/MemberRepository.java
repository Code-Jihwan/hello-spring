package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    // 회원을 저장하면 저장된 회원이 반환됨 (회원이 저장소에 저장)
    Member save(Member member);
    // id, name 으로 회원을 찾는 것
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    // 지금까지 저장된 모든 회원리스트를 다 반환함
    List<Member> findAll();
}
