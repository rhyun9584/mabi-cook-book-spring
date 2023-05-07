package com.j1001000.mabicookbook.vo;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {
    private final String name;

    public CustomUser(String name, String username, String password,
                      Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
