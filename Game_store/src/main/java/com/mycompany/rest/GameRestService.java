package com.mycompany.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.service.GameService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/public/rest/games")
public class GameRestService {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> browse() {
        return ResponseEntity.ok(gameService.listAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        gameService.delete(id);
    }

    @RequestMapping(value = "/{name}/{year}/{developer}/{price}", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@PathVariable("name") String name, @PathVariable("year") Integer year, @PathVariable("developer") String developer, @PathVariable("price") Integer price) {
        return ResponseEntity.ok(gameService.add(name, year, developer, price));
    }
    
    
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Object> findByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(gameService.findByName(name));
}
}
