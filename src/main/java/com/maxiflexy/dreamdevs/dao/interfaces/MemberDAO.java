package com.maxiflexy.dreamdevs.dao.interfaces;

import com.maxiflexy.dreamdevs.model.Member;
import java.util.List;

public interface MemberDAO {

    void addMember(Member member);
    void updateMember(Member member);
    void deleteMember(int memberId);
    List<Member> getAllMembers();
    Member getMemberById(int memberId);
}
