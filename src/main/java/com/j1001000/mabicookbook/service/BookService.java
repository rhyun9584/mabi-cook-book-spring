package com.j1001000.mabicookbook.service;

import com.j1001000.mabicookbook.dao.CollectRepository;
import com.j1001000.mabicookbook.domain.Collect;
import com.j1001000.mabicookbook.dto.BookContentDto;
import com.j1001000.mabicookbook.exception.CollectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final CollectRepository collectRepository;

    /**
     * 도감 항목에 출력할 데이터를 BookContentDto의 리스트로 반환
     * @param userId 도감을 조회할 유저의 DB id 값
     */
    public List<BookContentDto> getBookContent(Long userId) {
        // collect.user.id == userId인 Collect 리스트 가져오기
        List<Collect> collectList = collectRepository.findAllByUserIdWithCook(userId);

        // TODO: stream을 활용해서 코드를 정리할수있을까?
        // Collect 리스트로 bookContentDto 인스턴스의 리스트 생성
        List<BookContentDto> bookContentDtoList = new ArrayList<>();
        for (Collect collect : collectList) {
            bookContentDtoList.add(new BookContentDto(collect));
        }

        return bookContentDtoList;
    }

    /**
     * 유저의 id 값과 수집 항목의 id 값으로 도감 상태 변경
     */
    public void changeStatus(Long userId, Integer cookId, Integer nextStatus) {
        // status를 변경할 Collect row 찾기
        Optional<Collect> _targetCollect = collectRepository.findByUserIdAndCookId(userId, cookId);

        // 해당하는 항목을 찾지 못했을때 404 오류 발생
        if (_targetCollect.isEmpty()){
            throw new CollectNotFoundException(userId, cookId);
        }
        Collect targetCollect = _targetCollect.get();

        // status 상태 변경
        targetCollect.setStatus(nextStatus);

        // 변경사항 저장
        this.collectRepository.save(targetCollect);
    }
}
