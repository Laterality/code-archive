package kr.latera.associationfetch.service;

import kr.latera.associationfetch.domain.Member;
import kr.latera.associationfetch.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class MemberInternalService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberInternalService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Optional<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }

    public Member save(String name) {
        return memberRepository.save(MemberConverter.toEntity(name));
    }
}
