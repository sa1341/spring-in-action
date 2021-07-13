package sia.tacocloud.domain.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sia.tacocloud.domain.member.entity.Member;
import sia.tacocloud.domain.member.repository.MemberDao;

import java.util.List;

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
}
