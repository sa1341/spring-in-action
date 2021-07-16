package sia.tacocloud.domain.member.repository;

import org.apache.ibatis.annotations.Mapper;
import sia.tacocloud.domain.member.entity.Member;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberDao {
    public List<Member> selectList();
    public void saveMember(Map<String, String> map);
    public void deleteMember(String email);
    public Member findByEmail(String email);
}
