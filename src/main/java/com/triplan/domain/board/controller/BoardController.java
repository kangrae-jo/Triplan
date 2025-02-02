package com.triplan.domain.board.controller;

import com.triplan.domain.board.dto.BoardDTO;
import com.triplan.domain.board.service.BoardService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 모든 페이지 불러오기
    @GetMapping
    public ResponseEntity<List<BoardDTO>> getBoardList() {
        List<BoardDTO> boardList = boardService.getBoardList();
        return ResponseEntity.ok(boardList);
    }

    // 페이지 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> getBoard(@PathVariable("id") Long id) {
        return ResponseEntity.ok(boardService.getBoardById(id));
    }

    // 페이지 생성하기
    @PostMapping
    public ResponseEntity<Void> saveBoard(@RequestBody BoardDTO boardDTO) {
        boardService.saveBoard(boardDTO);
        return ResponseEntity.status(201).build();
    }

    // 인원 수 선택
    @PutMapping("/{id}/headCount")
    public ResponseEntity<Void> setHeadCount(@PathVariable("id") Long id, @RequestBody Integer headCount) {
        boardService.setHeadCount(id, headCount);
        return ResponseEntity.ok().build();
    }

    // 여행 시작 일자 선택
    @PutMapping("/{id}/date/start")
    public ResponseEntity<Void> setStartDate(@PathVariable("id") Long id, @RequestBody LocalDateTime startDate) {
        boardService.setStartDate(id, startDate);
        return ResponseEntity.ok().build();
    }

    // 여행 종료 일자 선택
    @PutMapping("/{id}/date/end")
    public ResponseEntity<Void> setEndDate(@PathVariable("id") Long id, @RequestBody LocalDateTime endDate) {
        boardService.setEndDate(id, endDate);
        return ResponseEntity.ok().build();
    }

    // 총 예상 경비 기록
    @PutMapping("/{id}/budget")
    public ResponseEntity<Void> setBudget(@PathVariable("id") Long id, @RequestBody BigDecimal budget) {
        boardService.setBudget(id, budget);
        return ResponseEntity.ok().build();
    }

    // 자유롭게 콘텐츠 기록
    @PutMapping("/{id}/content")
    public ResponseEntity<Void> setContent(@PathVariable("id") Long id, @RequestBody String content) {
        boardService.setContent(id, content);
        return ResponseEntity.ok().build();
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }
}