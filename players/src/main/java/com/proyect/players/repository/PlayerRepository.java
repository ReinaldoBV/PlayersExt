package com.proyect.players.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyect.players.entity.Player;

@Service
public interface PlayerRepository extends JpaRepository<Player, Long> {
    
}
