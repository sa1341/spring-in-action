package sia.tacocloud.domain.fund.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class FundBuyingResponse {
    private String email;
    private String name;
    private int age;
    private String fundCode;
    private String fundName;
    private LocalDate createdAt;
}
