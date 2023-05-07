package com.j1001000.mabicookbook.controller;

import com.j1001000.mabicookbook.form.SiteUserCreateForm;
import com.j1001000.mabicookbook.form.SiteUserLoginForm;
import com.j1001000.mabicookbook.service.SiteUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class SiteUserController {
    private final SiteUserService siteUserService;

    @GetMapping("/signup")
    public String signup(SiteUserCreateForm siteUserCreateForm) {
        return "auth/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid SiteUserCreateForm siteUserCreateForm, BindingResult bindingResult) {
        // 폼 입력에 오류가 있을 경우 다시 돌아감
        if (bindingResult.hasErrors()) {
            return "auth/signup";
        }

        // 비밀번호와 비밀번호 확인이 동일하지 않을 경우 오류
        if (!siteUserCreateForm.getPassword1().equals(siteUserCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordIncorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "auth/signup";
        }

        // 폼에 입력된 정보로 유저 생성
        try {
            siteUserService.create(
                    siteUserCreateForm.getEmail(),
                    siteUserCreateForm.getServer(),
                    siteUserCreateForm.getName(),
                    siteUserCreateForm.getPassword1());
        } catch (DataIntegrityViolationException e) {
            // 이메일 중복 등으로 회원가입이 불가능한 경우 오류 처리
            e.printStackTrace();
            bindingResult.reject("duplicatedEmail", "이미 등록된 이메일 ID입니다.");
            return "auth/signup";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed");
            return "auth/signup";
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(SiteUserLoginForm siteUserLoginForm) {
        return "auth/login";
    }
}
