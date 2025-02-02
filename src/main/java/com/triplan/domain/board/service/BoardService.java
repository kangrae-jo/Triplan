package com.triplan.domain.board.service;

import static com.triplan.domain.board.constance.TravelStatus.PLANNING;

import com.triplan.domain.board.dao.BoardDAO;
import com.triplan.domain.board.dto.BoardDTO;
import com.triplan.domain.board.entity.Board;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardDAO boardDAO;

    @Autowired
    public BoardService(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    // 모든 페이지 불러오기 (목록 버전)
    public List<BoardDTO> getBoardList() {
        List<Board> boards = boardDAO.findAll();
        return boards.stream()
                .map(board -> {
                    BoardDTO boardDTO = new BoardDTO();
                    boardDTO.setId(board.getId());
                    boardDTO.setTitle(board.getTitle());
                    boardDTO.setAuthor(board.getAuthor());
                    return boardDTO;
                })
                .collect(Collectors.toList());
    }

    public BoardDTO getBoardById(Long id) {
        return new BoardDTO(findBoardById(id));
    }

    // 페이지 생성하기
    public void saveBoard(BoardDTO boardDTO) {
        Board board = new Board();
        //board.setId(boardDTO.getId());
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setAuthor(boardDTO.getAuthor());
        board.setCreatedDate(LocalDateTime.now());
        board.setUpdateDate(LocalDateTime.now());
        board.setHeadCount(boardDTO.getHeadCount());
        board.setBudget(boardDTO.getBudget());
        board.setLocations(new ArrayList<>());
        board.setStatus(PLANNING);
        board.setStartDate(LocalDateTime.now());
        board.setEndDate(LocalDateTime.now().plusDays(2));

        boardDAO.save(board);
    }

    // 인원 수 선택
    public void setHeadCount(Long id, Integer headCount) {
        Board board = findBoardById(id);
        board.setHeadCount(headCount);

        boardDAO.save(board);
    }

    // 여행 시작 일자 선택
    public void setStartDate(Long id, LocalDateTime startDate) {
        Board board = findBoardById(id);
        board.setStartDate(startDate);

        boardDAO.save(board);
    }

    // 여행 종료 일자 선택
    public void setEndDate(Long id, LocalDateTime endDate) {
        Board board = findBoardById(id);
        board.setEndDate(endDate);

        boardDAO.save(board);
    }

    // 총 예상 경비 기록
    public void setBudget(Long id, BigDecimal budget) {
        Board board = findBoardById(id);
        board.setBudget(budget);

        boardDAO.save(board);
    }

    // 자유롭게 콘텐츠 기록
    public void setContent(Long id, String content) {
        Board board = findBoardById(id);
        board.setContent(content);

        boardDAO.save(board);
    }

    // 게시글 삭제
    public void deleteBoard(Long id) {
        boardDAO.deleteById(id);
    }

    private Board findBoardById(Long id) {
        return boardDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("[ERROR]: Invalid board ID"));
    }
}
