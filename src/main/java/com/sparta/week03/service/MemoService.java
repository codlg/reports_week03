package com.sparta.week03.service;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor  // 생성자 어노테이션
@Service
public class MemoService {

    private final MemoRepository memoRepository; // MempService인지 아닌지를 구분해 주기 위해서 final을 꼭 붙여야된다.

    @Transactional  // DB에 반영 되기 위한 어노테이션
    public Long update(Long id, MemoRequestDto requestDto) {  // public 반환타입 메소드이름 (재료) {}
        Memo memo = memoRepository.findById(id).orElseThrow(  // orElseThrow - 예외처리
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
}