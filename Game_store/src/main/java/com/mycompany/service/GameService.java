package com.mycompany.service;

import com.mycompany.db.model.Game;

public interface GameService {

    Iterable<Game> listAll();

    void delete(Integer id);
    
    Game add(String name, Integer year, String developer, Integer price);
    
    Game findByName(String name);

}
