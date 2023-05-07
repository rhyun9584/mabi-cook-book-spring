package com.j1001000.mabicookbook.service;

import com.j1001000.mabicookbook.dao.SiteUserRepository;
import com.j1001000.mabicookbook.domain.SiteUser;
import com.j1001000.mabicookbook.vo.CustomUser;
import com.j1001000.mabicookbook.vo.SiteUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SiteUserSecurityService implements UserDetailsService {
    private final SiteUserRepository siteUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<SiteUser> _siteUser = this.siteUserRepository.findByEmail(email);

        // 입력된 이메일 id를 갖는 유저가 없는 경우 오류 처리
        if (_siteUser.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        SiteUser siteUser = _siteUser.get();

        // 권한 부여
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(SiteUserRole.USER.getValue()));

        return new CustomUser(siteUser.getName(), siteUser.getEmail(), siteUser.getPassword(), authorities);
    }
}
