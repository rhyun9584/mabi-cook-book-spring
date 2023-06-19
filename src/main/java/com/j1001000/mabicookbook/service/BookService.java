package com.j1001000.mabicookbook.service;

import com.j1001000.mabicookbook.dao.CollectRepository;
import com.j1001000.mabicookbook.dao.CookRepository;
import com.j1001000.mabicookbook.domain.Collect;
import com.j1001000.mabicookbook.domain.Cook;
import com.j1001000.mabicookbook.dto.BookContentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final CookRepository cookRepository;
    private final CollectRepository collectRepository;

    /**
     * cook 테이블 전체 리스트와 유저의 id 값으로 불러온 status 값을 조합하여
     * 도감 항목에 출력할 데이터를 BookContentDto의 리스트로 빈환
     * @param userId 도감 상태를 조회할 유저의 id 값
     */
    public List<BookContentDto> getBookContent(Long userId) {
        // cook 테이블을 id 순서대로 정렬하여 데이터 가져오기
        List<Cook> cookList = cookRepository.findAllByOrderByIdAsc();

        // collect.userId == userId인 collect 상태값을 요리 id 순서대로 가져오기
        List<Collect> collectList = collectRepository.findByIdUserIdOrderByIdCookId(userId);

        // TODO: cook과 collect의 갯수가 맞지 않을때 에러 리턴?

        // TODO: stream을 활용해서 코드를 정리할수있을까?
        // cookList와 collectList를 합쳐서 bookContentDto 인스턴스의 리스트 생성
        List<BookContentDto> bookContentDtoList = new ArrayList<>();
        for (int i = 0; i < collectList.size(); i++) {
            // TODO: 순회할 때 cook.id != collect.cookId인 경우 에러 리턴?
            bookContentDtoList.add(new BookContentDto(cookList.get(i), collectList.get(i)));
        }

        return bookContentDtoList;
    }
}
