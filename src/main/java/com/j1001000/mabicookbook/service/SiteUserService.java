package com.j1001000.mabicookbook.service;

import com.j1001000.mabicookbook.dao.SiteUserRepository;
import com.j1001000.mabicookbook.domain.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SiteUserService {
    private final SiteUserRepository siteUserRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String email, String server, String name, String password){
        // 새 유저 객체 생성
        SiteUser user = new SiteUser();

        user.setEmail(email);
        user.setName(server + "@" + name);
        // password 암호화 저장
        user.setPassword(passwordEncoder.encode(password));

        // repository로 데이터베이스 업데이트
        this.siteUserRepository.save(user);

        return user;
    }
}
