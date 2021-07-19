package sia.tacocloud.domain.fund.entity;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Fund {
    private Long id;
    private String code;
    private String name;
    private String email;
    private LocalDate createdAt;
}
