package sia.tacocloud.domain.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sia.tacocloud.domain.member.entity.Member;
import sia.tacocloud.domain.member.repository.MemberDao;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberDao memberDao;

    public List<Member> getMembers() {
        log.info("dao selectList");
        List<Member> members = memberDao.selectList();
        return members;
    }

    public void save(final Map<String, String> map) {
        memberDao.saveMember(map);
    }

    public void delete(final String email) {
        memberDao.deleteMember(email);
    }

    public Member getMemberByEmail(final String email) {
        return memberDao.findByEmail(email);
    }
}
