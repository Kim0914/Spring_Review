package hello.core_review.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberID);
}
