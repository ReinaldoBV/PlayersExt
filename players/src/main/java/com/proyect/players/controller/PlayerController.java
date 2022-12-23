package com.proyect.players.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.players.entity.Player;
import com.proyect.players.repository.PlayerRepository;

@RestController
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    //http://localhost:8080/players

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        Player playerToUpdate = playerRepository.findById(id).orElse(null);
        playerToUpdate.setName(player.getName());
        playerToUpdate.setLastName(player.getLastName());
        playerToUpdate.setPosition(player.getPosition());
        playerToUpdate.setTeam(player.getTeam());
        playerToUpdate.setNumber(player.getNumber());
        playerToUpdate.setAge(player.getAge());
        return playerRepository.save(playerToUpdate);
    }
    
    @PostMapping("/players")
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }
    
    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerRepository.deleteById(id);
    }
    
    @DeleteMapping("/players")
    public void deleteAllPlayers() {
        playerRepository.deleteAll();
    }
    
}
