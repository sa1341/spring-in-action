package sia.tacocloud.domain.member.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {

    private String email;
    private String name;
    private int age;

    protected Member(String email, String name, int age) {
        this.email = email;
        this.name = name;
        this.age = age;
    }

    public static Member of(final String email, final String name, final int age) {
        return new Member(email, name, age);
    }
}
