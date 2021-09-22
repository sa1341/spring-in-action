package sia.tacocloud.domain.fund.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sia.tacocloud.domain.fund.model.FundBuyingRequest;
import sia.tacocloud.domain.fund.model.FundBuyingResponse;
import sia.tacocloud.domain.fund.service.FundService;

import java.util.List;

@Slf4j
@RequestMapping("/api/v1/funds")
@RequiredArgsConstructor
@RestController
public class FundApi {

    private final FundService fundService;

    @PostMapping
    public void buyingFund(@RequestBody final FundBuyingRequest request) {
        log.info("email: {}", request.getEmail());
    }

    @GetMapping
    public List<FundBuyingResponse> getFunds() {
        String email = "a79007714@gmail.com";
        List<FundBuyingResponse> funds = fundService.getFunds(email);
        return funds;
    }
}
