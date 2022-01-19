package hello.core_review;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // AppConfig 의 설정을 보존하기 위해(보고 공부하라고) excludeFilter 설정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
//        basePackages = "hello.core_review.member",
//        basePackageClasses = AutoAppConfig.class
)
public class AutoAppConfig {
}
