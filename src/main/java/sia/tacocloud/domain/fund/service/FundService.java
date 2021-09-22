package sia.tacocloud.domain.fund.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sia.tacocloud.domain.fund.model.FundBuyingRequest;
import sia.tacocloud.domain.fund.model.FundBuyingResponse;
import sia.tacocloud.domain.fund.repository.FundDao;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class FundService {

    private final FundDao fundDao;

    public void buyingFund(final FundBuyingRequest request) {
    }

    public List<FundBuyingResponse> getFunds(final String email) {
        List<FundBuyingResponse> result = fundDao.selectList(email);
        return result;
    }
}
