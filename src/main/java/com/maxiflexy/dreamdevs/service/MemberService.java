package com.maxiflexy.dreamdevs.service;

import com.maxiflexy.dreamdevs.dao.impl.MemberDAOImpl;
import com.maxiflexy.dreamdevs.dao.interfaces.MemberDAO;
import com.maxiflexy.dreamdevs.model.Member;
import com.maxiflexy.dreamdevs.util.CSVExporter;
import com.maxiflexy.dreamdevs.util.Logger;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
    private final MemberDAO memberDAO;
    private final Logger logger;
    private final CSVExporter csvExporter;

    // In-memory cache for members
    private List<Member> membersCache;

    public MemberService() {
        this.memberDAO = new MemberDAOImpl();
        this.logger = new Logger();
        this.csvExporter = new CSVExporter();
        this.membersCache = new ArrayList<>();
        refreshCache();
    }

    public void addMember(Member member) {
        memberDAO.addMember(member);
        refreshCache();
    }

    public void updateMember(Member member) {
        memberDAO.updateMember(member);
        refreshCache();
    }

    public void deleteMember(int memberId) {
        memberDAO.deleteMember(memberId);
        refreshCache();
    }

    public List<Member> getAllMembers() {
        return new ArrayList<>(membersCache);
    }

    public Member getMemberById(int memberId) {
        return membersCache.stream()
                .filter(member -> member.getMemberId() == memberId)
                .findFirst()
                .orElseGet(() -> memberDAO.getMemberById(memberId));
    }

    public void exportMembersToCSV() {
        csvExporter.exportMembersToCSV(membersCache);
    }

    private void refreshCache() {
        membersCache = memberDAO.getAllMembers();
    }
}
