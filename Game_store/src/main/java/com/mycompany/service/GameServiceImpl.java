package com.mycompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.db.dao.GameRepository;
import com.mycompany.db.model.Game;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public Iterable<Game> listAll() {
        return gameRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        gameRepository.deleteById(id);
    }

    @Override
    public Game add(String name, Integer year, String developer, Integer price) {
        return gameRepository.save(new Game(name, year, developer, price));
    }

    @Override
    public Game findByName(String name) {
        return gameRepository.findByName(name);
    }
}