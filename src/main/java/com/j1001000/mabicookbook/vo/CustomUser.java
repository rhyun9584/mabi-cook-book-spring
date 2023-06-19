package com.j1001000.mabicookbook.vo;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * springSecurity를 활용하여 로그인한 후
 * 로그인 한 유저의 정보를 조회하기위한 클래스
 */
public class CustomUser extends User {
    private final Long id;
    private final String name;

    public CustomUser(Long id, String name, String username, String password,
                      Collection<? extends GrantedAuthority> authorities) {
        // username : email 아이디
        // name : 서버@닉네임
        super(username, password, authorities);

        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public Long getId() {
        return this.id;
    }
}
