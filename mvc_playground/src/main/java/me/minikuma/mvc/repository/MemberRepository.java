package me.minikuma.mvc.repository;

import me.minikuma.mvc.model.Member;

import java.util.HashMap;
import java.util.Map;

/**
 * 별도 저장소 없이 자료구조로 해결
 */
public class MemberRepository {
    private static Map<String, Member> members = new HashMap<>();

    public static void save(Member member) {
        members.put(member.getMemberId(), member);
    }
}
