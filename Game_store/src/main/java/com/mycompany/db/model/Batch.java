package com.mycompany.db.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Batch")
@Data

public class Batch implements Serializable {

    public Batch() {
    }

    public Batch(Integer id) {
        this.id = id;

    }

    @Id
    @Column(name = "batch_id")
    private Integer id;

    @Column(name = "batch_game_id")
    private Integer game;
}
