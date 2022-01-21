package hello.core_review;

import hello.core_review.member.MemberRepository;
import hello.core_review.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // AppConfig 의 설정을 보존하기 위해(보고 공부하라고) excludeFilter 설정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
        basePackages = "hello.core_review.member",
        basePackageClasses = AutoAppConfig.class
)
public class AutoAppConfig {

    // 빈 이름이 같은 경우 수동 빈이 자동 빈 보다 우선권을 가진다
//    @Bean(name="memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}
