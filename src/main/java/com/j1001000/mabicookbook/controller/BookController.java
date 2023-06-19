package com.j1001000.mabicookbook.controller;

import com.j1001000.mabicookbook.dto.BookContentDto;
import com.j1001000.mabicookbook.service.BookService;
import com.j1001000.mabicookbook.vo.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    public final BookService bookService;

    @GetMapping()
    @PreAuthorize("isAuthenticated()")
    public String bookPage(Model model,
                           @AuthenticationPrincipal CustomUser user) {
        // 로그인한 유저의 id 값으로 해당 유저의 도감 컨텐츠 상태 불러오기
        List<BookContentDto> bookContentDtoList = bookService.getBookContent(user.getId());

        model.addAttribute("bookContentDtoList", bookContentDtoList);
        return "book/book";
    }
}
