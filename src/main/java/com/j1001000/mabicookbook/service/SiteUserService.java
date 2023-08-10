package com.j1001000.mabicookbook.service;

import com.j1001000.mabicookbook.dao.CollectRepository;
import com.j1001000.mabicookbook.dao.CookRepository;
import com.j1001000.mabicookbook.dao.SiteUserRepository;
import com.j1001000.mabicookbook.domain.Collect;
import com.j1001000.mabicookbook.domain.Cook;
import com.j1001000.mabicookbook.domain.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SiteUserService {
    private final SiteUserRepository siteUserRepository;
    private final CookRepository cookRepository;
    private final CollectRepository collectRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 서버 데이터베이스에 존재하는 Cook 데이터와 매핑되는 Collect 생성 후 데이터베이스에 저장
     * @param user 생성한 Collect 객체들과 연결할 SiteUser 객체
     */
    private void createCollect(SiteUser user) {
        // 서버 데이터베이스의 모든 Cook 데이터 호출
        List<Cook> cookList = cookRepository.findAllByOrderByIdAsc();

        // Cook 데이터와 매핑되는 Collect 객체 생성 및 영속화
        for (Cook cook : cookList) {
            Collect collect = new Collect();
            collect.setUser(user);
            collect.setCook(cook);
            collect.setStatus(0);

            collectRepository.save(collect);
        }
    }

    public SiteUser create(String email, String server, String name, String password){
        // 새 유저 객체 생성
        SiteUser user = new SiteUser();

        user.setEmail(email);
        user.setName(server + "@" + name);
        user.setPassword(passwordEncoder.encode(password));     // password 암호화 저장

        // repository로 SiteUser 객체 영속화
        this.siteUserRepository.save(user);

        // 생성된 SiteUser 객체와 매핑할 Collect 객체 생성 및 영속화
        createCollect(user);

        return user;
    }
}
