package com.sparta.week03.service;

import com.sparta.week03.domain.Board;
import com.sparta.week03.domain.BoardRepository;
import com.sparta.week03.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor  // 생성자 어노테이션
@Service
public class BoardService {

    private final BoardRepository boardRepository; // MempService인지 아닌지를 구분해 주기 위해서 final을 꼭 붙여야된다.

    @Transactional  // DB에 반영 되기 위한 어노테이션
    public Long update(Long id, BoardRequestDto requestDto) {  // public 반환타입 메소드이름 (재료) {}
        Board board = boardRepository.findById(id).orElseThrow(  // orElseThrow - 예외처리
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }
}