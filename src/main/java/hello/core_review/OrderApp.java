package hello.core_review;

import hello.core_review.member.Grade;
import hello.core_review.member.Member;
import hello.core_review.member.MemberService;
import hello.core_review.member.MemberServiceImpl;
import hello.core_review.order.Order;
import hello.core_review.order.OrderService;
import hello.core_review.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
