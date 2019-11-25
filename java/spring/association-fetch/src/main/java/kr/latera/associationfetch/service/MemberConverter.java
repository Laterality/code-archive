package kr.latera.associationfetch.service;

import kr.latera.associationfetch.domain.Member;

public class MemberConverter {

    public static Member toEntity(String name) {
        return new Member(name);
    }
}
