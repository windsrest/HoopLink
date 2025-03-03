package com.hooplink.dto.player;

import com.hooplink.domain.enums.Position;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class PlayerForm {
    @NotBlank(message = "등번호를 입력해주세요")
    private String uniformNumber;

    @NotBlank(message = "이름을 입력해주세요")
    private String name;

    @NotNull(message = "생년월일을 입력해주세요")
    private LocalDate birthDate;

    @NotBlank(message = "아이디를 입력해주세요")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,20}$", message = "아이디는 영문과 숫자로 4~20자리로 입력해주세요")
    private String loginId;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 4, message = "비밀번호는 4자리 이상이어야 합니다")
    private String password;

    @NotBlank(message = "비밀번호 확인을 입력해주세요")
    private String passwordConfirm;

    @NotBlank(message = "핸드폰번호를 입력해주세요")
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "올바른 핸드폰번호 형식이 아닙니다")
    private String phoneNumber;

    @Min(value = 100, message = "키는 100cm 이상이어야 합니다")
    @Max(value = 250, message = "키는 250cm 이하여야 합니다")
    private Integer height;

    @Min(value = 40, message = "몸무게는 40kg 이상이어야 합니다")
    @Max(value = 200, message = "몸무게는 200kg 이하여야 합니다")
    private Integer weight;

    @NotEmpty(message = "최소 하나의 포지션을 선택해주세요")
    private Set<Position> positions = new HashSet<>();
}
