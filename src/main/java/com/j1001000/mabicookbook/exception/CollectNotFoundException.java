package com.j1001000.mabicookbook.exception;

public class CollectNotFoundException extends RuntimeException {
    public CollectNotFoundException(Long userId, Integer cookId) {
        super("#" + userId + " 유저의 #" + cookId + " 수집 항목 정보를 찾을 수 없습니다.");
    }
}
