package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    // 테스트 코드에서는 한글로 작성해도 된다. 빌드 될 때 테스트 코드는 실제 코드에 포함 되지 않는다.
    @Test
    void 회원가입() {
        // 추천 문법 : given (뭔가가 주어졌다.) - when (이거를 실행 했을 때) - then (결과가 이것이 나와야 해)

        // given (이 데이터를 기반으로 하는 것이구나)
        Member member = new Member();
        member.setName("spring");

        // when (이거를 검증하는구나)
        Long saveId = memberService.join(member);

        // then (여기가 검증부)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // give
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        // () -> memberService.join(member2) 이 로직을 실행하면, IllegalStateException 아 예외가 발생해야 함

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // 메세지도 같은지 검증


        // then

    }

}