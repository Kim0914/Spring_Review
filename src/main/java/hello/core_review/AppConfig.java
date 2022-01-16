package hello.core_review;

import hello.core_review.discount.DiscountPolicy;
import hello.core_review.discount.FixDiscountPolicy;
import hello.core_review.discount.RateDiscountPolicy;
import hello.core_review.member.MemberService;
import hello.core_review.member.MemberServiceImpl;
import hello.core_review.member.MemoryMemberRepository;
import hello.core_review.order.OrderService;
import hello.core_review.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
     * 애플리케이션에 관한 모든 환경 구성은 AppConfig에서 한다
     * AppConfig 에서 앱과 관련된 구현 객체를 생성자 주입의 방식으로 설정한다
     * @return
     */

    /**
     * @Bean 을 하게 되면 method들이 스프링 컨테이너에 자동으로 등록된다
     */


    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
