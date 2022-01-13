package hello.core_review.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberID);
}
