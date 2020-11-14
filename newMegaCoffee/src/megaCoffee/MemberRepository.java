package megaCoffee;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    List<Member> memberList = new ArrayList<>();

    public MemberRepository() {
        setMember();
    }

    private void setMember() {
        memberList.add(new Member("jhlee", 1234, 0));
    }
}
