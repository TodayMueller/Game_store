package com.mycompany.db.dao;

import com.mycompany.db.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {

    public Game findByName(String name);
}
