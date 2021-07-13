package sia.tacocloud.domain.member.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sia.tacocloud.domain.member.entity.Member;
import sia.tacocloud.domain.member.service.MemberService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/members")
@RestController
public class MemberApi {

    private final MemberService memberService;

    @GetMapping
    public List<Member> getMembers() {
      log.info("Start!!!!");
      return memberService.getMembers();
    }
}
