package com.mycompany.db.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GAME")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    public Game(String name, Integer year, String developer, Integer price) {
        this.name = name;
        this.year = year;
        this.developer = developer;
        this.price = price;
    }

    @Id
    @Column(name = "GAME_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(targetEntity = Batch.class, mappedBy = "game", fetch = FetchType.LAZY)
    private List<Batch> batchesList;

    @Column(name = "GAME_NAME", unique = true)
    private String name;
    
    @Column(name = "GAME_YEAR")
    private Integer year;
    
    @Column(name = "GAME_DEVELOPER")
    private String developer;
    
    @Column(name = "GAME_PRICE")
    private Integer price;
}