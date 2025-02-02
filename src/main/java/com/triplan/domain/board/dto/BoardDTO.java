package com.triplan.domain.board.dto;

import com.triplan.domain.board.constance.TravelStatus;
import com.triplan.domain.board.entity.Board;
import com.triplan.domain.board.entity.Location;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Long id;
    private String title;
    private String content;
    private String author;
    private Integer headCount;
    private BigDecimal budget;
    private List<Location> locations;
    private TravelStatus status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public BoardDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.author = board.getAuthor();
        this.headCount = board.getHeadCount();
        this.budget = board.getBudget();
        this.locations = board.getLocations();
        this.status = board.getStatus();
        this.startDate = board.getStartDate();
        this.endDate = board.getEndDate();
    }

    /*
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
    */
}
