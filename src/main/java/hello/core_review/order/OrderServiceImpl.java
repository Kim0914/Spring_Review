package hello.core_review.order;

import hello.core_review.discount.DiscountPolicy;

import hello.core_review.member.Member;
import hello.core_review.member.MemberRepository;
import hello.core_review.member.MemberServiceImpl;
import hello.core_review.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 고정 할인 정책 -> 비율 할인 정책으로 할인 정책을 변경하는 경우
     * 클라이언트 코드인 OrderServiceImpl은 DiscountPolicy 인터페이스 뿐만 아니라 구현 클래스도 함께 의존
     * 그래서 구현 클래스(고정, 비율)를 변경할 때, OrderServiceImpl도 같이 변경해야 된다
     * DIP 위반이므로 추상(Interface)에만 의존하도록 변경해야된다
    */
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    /**
     * 그래서 생성자 주입의 방식으로 정의한다
     * 따라서 MemberRepository, DiscountPolicy 와 같은 인터페이스에만 의존한다
     */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * orderService 입장에서는 할인에 대해서는 아무것도 모름
     * DiscountPolicy 가 알아서 계산해주고 결과만 리턴해주는 형식
     * 단일 책임의 원칙이 잘 지켜진 것
     * 할인을 고치고 싶으면 할인 쪽만 고치고, 주문 쪽은 건들지 않아야 함
     */
    @Override
    public Order createOrder(Long memberID, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberID);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberID, itemName, itemPrice, discountPrice);
    }
}
