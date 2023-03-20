package com.sagem.emt.dao.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "equipment")
public class Equipment {
    @PrePersist
    public void prePersist() {
	this.creationDate = LocalDateTime.now();
	this.available = true;
    }

    @Id
    private String	   serialNumber;
    @Column(updatable = false)
    private LocalDateTime  creationDate;
    private String	   version;
    private String	   name;
    private String	   partNumber;
    @Column(updatable = false)
    private boolean	   available;
    @ManyToOne
    private Category	   category;
    @JsonIgnore
    @OneToMany(mappedBy = "equipment", fetch = FetchType.LAZY)
    private List<Movement> movements;
}
