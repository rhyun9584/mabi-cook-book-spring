package com.j1001000.mabicookbook.dto;

import com.j1001000.mabicookbook.domain.Collect;
import com.j1001000.mabicookbook.vo.Method;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BookContentDto {
    private final Long collectId;
    private final Integer cookId;
    private final String name;
    private final String engName;
    private final Method method;
//    private final String ingredient;
    private final Integer status;

    public BookContentDto(Collect collect) {
        this.collectId = collect.getId();
        this.cookId = collect.getCook().getId();
        this.name = collect.getCook().getName();
        this.engName = collect.getCook().getEngName();
        this.method = collect.getCook().getMethod();
        this.status = collect.getStatus();
    }
}
