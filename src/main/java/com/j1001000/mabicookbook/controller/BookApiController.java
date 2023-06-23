package com.j1001000.mabicookbook.controller;

import com.j1001000.mabicookbook.service.BookService;
import com.j1001000.mabicookbook.vo.CollectVO;
import com.j1001000.mabicookbook.vo.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookApiController {
    private final BookService bookService;

    /**
     * 로그인한 유저의 특정 요리항목의 수집 상태 변경
     */
    @PatchMapping("/status")
    public ResponseEntity<Void> changeStatus(@RequestBody CollectVO collectVO,
                                             @AuthenticationPrincipal CustomUser user) {
        // 로그인이 되어있지 않은 상태의 요청에는 401 에러 반환
        if (Objects.isNull(user)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // 로그인한 유저의 id값과 상태를 변경하려는 요리항목의 id으로 상태 변경
        bookService.changeStatus(user.getId(), collectVO.getCookId(), collectVO.getNextStatus());

        return ResponseEntity.ok().build();
    }
}
