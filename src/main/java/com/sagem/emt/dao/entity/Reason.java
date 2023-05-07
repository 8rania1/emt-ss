package com.sagem.emt.dao.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "reason")
@Entity
public class Reason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	      id;
    private String	      title;
    private MovementDirection direction;
    @JsonIgnore
    @OneToMany(mappedBy = "reason", fetch = FetchType.LAZY)
    private List<Movement>    movements;
}
