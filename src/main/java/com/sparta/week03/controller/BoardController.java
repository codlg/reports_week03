package com.sparta.week03.controller;

import com.sparta.week03.domain.Board;
import com.sparta.week03.domain.BoardRepository;
import com.sparta.week03.domain.BoardRequestDto;
import com.sparta.week03.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) { //@RequestBody - 요청날아올때 넣기 위한 어노테이션
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

    @GetMapping("/api/boards")
    public List<Board> getBoard() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping("/api/boards/{id}")
    public Long updateBoard (@PathVariable Long id ,@RequestBody BoardRequestDto requestDto){
        boardService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id) { //@PathVariable - 경로에 있는 변수를 넣는다 {id}
        boardRepository.deleteById(id);
        return id;
    }

    @GetMapping("/api/boards/{id}/check")
    public String checkPw (@PathVariable Long id){

        return boardService.checkPassword(id);
    }
}
