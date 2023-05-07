package com.j1001000.mabicookbook.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SiteUserCreateForm {
    @NotEmpty(message= "이메일을 입력해주세요.")
    @Email
    private String email;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password1;
    @NotEmpty(message = "비밀번호 확인을 입력해주세요.")
    private String password2;

    @NotEmpty(message = "서버를 선택해주세요.")
    private String server;
    @NotEmpty(message = "닉네임을 입력해주세요")
    private String name;
}
