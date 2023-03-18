package com.sagem.emt.dao.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "movement")
@Data
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	      id;
    private Date	      date;
    private MovementDirection direction;
    @ManyToOne
    @JoinColumn(name = "equipment")
    private Equipment	      equipment;
    @ManyToOne
    @JoinColumn(name = "reason")
    private Reason	      reason;
    private String	      note;
    @ManyToOne
    private User	      user;
}
