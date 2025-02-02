package com.triplan.domain.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    //@Column(nullable = false)
    //private BigDecimal latitude;

    //@Column(nullable = false)
    //private BigDecimal longitude;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

}