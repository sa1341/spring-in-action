package sia.tacocloud.domain.fund.repository;

import org.apache.ibatis.annotations.Mapper;
import sia.tacocloud.domain.fund.model.FundBuyingResponse;

import java.util.List;
import java.util.Map;

@Mapper
public interface FundDao {
    void saveFund(Map<String, String> map);
    void deleteFund(String email);
    List<FundBuyingResponse> selectList(String email);
}
