package hello.core_review.member;

public class MemberServiceImpl implements MemberService{

    /**
     * MemberRepository memberRepository = new MemoryMemberRepository() 의 코드는
     * 마치 배우가 공연에서 필요한 다른 배우를 섭외하는 것과 같다
     */
    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberID) {
        return memberRepository.findById(memberID);
    }
}
