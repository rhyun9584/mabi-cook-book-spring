package com.j1001000.mabicookbook.dto;

import com.j1001000.mabicookbook.domain.Collect;
import com.j1001000.mabicookbook.domain.Cook;
import com.j1001000.mabicookbook.vo.Method;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BookContentDto {
    private final Integer cookId;
    private final String name;
    private final String engName;
    private final Method method;
//    private final String ingredient;
    private final Integer status;

    public BookContentDto(Cook cook, Collect collect) {
        this.cookId = cook.getId();
        this.name = cook.getName();
        this.engName = cook.getEngName();
        this.method = cook.getMethod();
        this.status = collect.getStatus();
    }
}
