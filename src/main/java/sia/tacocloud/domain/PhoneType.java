package sia.tacocloud.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PhoneType {
    MOBILE(0),
    HOME(1),
    WORK(2);

    private final int number;
}
