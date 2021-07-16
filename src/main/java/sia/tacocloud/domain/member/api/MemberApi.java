package sia.tacocloud.domain.member.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sia.tacocloud.domain.member.entity.Member;
import sia.tacocloud.domain.member.service.MemberService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/{email}")
    public Member getMemberByEmail(@PathVariable("email") final String email) {
        log.info("Start!!!!");
        return memberService.getMemberByEmail(email);
    }

    @PostMapping
    public void save() {
        log.info("create Resource");
        Map<String, String> map = new HashMap<>();
        map.put("email", "syn1341@hanmail.net");
        map.put("name", "배성탑");
        map.put("age", "30");
        memberService.save(map);
    }

    @DeleteMapping("/{email}")
    public void delete(@PathVariable("email") final String email) {
        log.info("email: {}",  email);
        memberService.delete(email);
    }
}
