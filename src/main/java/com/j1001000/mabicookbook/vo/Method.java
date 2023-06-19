package com.j1001000.mabicookbook.vo;

import lombok.Getter;

@Getter
public enum Method {
    practice("혼합"),
    RANK_F("굽기"),
    RANK_E("삶기"),
    RANK_D("반죽"),
    RANK_C("끓이기"),
    RANK_B("면 만들기"),
    RANK_A("튀기기"),
    RANK_9("볶기"),
    RANK_8("파스타 만들기"),
    RANK_7("잼 만들기"),
    RANK_6("파이 만들기"),
    RANK_5("찌기"),
    RANK_4("피자 만들기"),
    RANK_3("발효"),
    RANK_2("수비드"),
    RANK_1("저미기");

    Method(String korValue) {
        this.korValue = korValue;
    }
    private String korValue;
}
