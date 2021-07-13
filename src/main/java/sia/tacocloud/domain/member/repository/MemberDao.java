package sia.tacocloud.domain.member.repository;

import org.apache.ibatis.annotations.Mapper;
import sia.tacocloud.domain.member.entity.Member;

import java.util.List;

@Mapper
public interface MemberDao {
    public List<Member> selectList();
}
