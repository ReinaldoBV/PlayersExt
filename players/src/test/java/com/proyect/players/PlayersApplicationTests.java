package com.proyect.players;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyect.players.entity.Player;
import com.proyect.players.repository.PlayerRepository;

@SpringBootTest
class PlayersApplicationTests {

	@Autowired
	private PlayerRepository playerRepository;

	//Crear jugadores
	@Test
	public void createPlayers() {
		
        Player player1 = new Player("Peter", "Parker", "Goalkeeper", "Barcelona", 1, 20, 123456789, new Date (1/1/2001), true);
		Player player2 = new Player("Tony", "Stark", "Defender", "Real Madrid", 2, 30, 987654321, new Date(12/10/1982), true);
		Player player3 = new Player("Steve", "Rogers", "Midfielder", "Manchester City", 3, 40, 123456789, new Date (27/7/1917), false);
		Player player4 = new Player("Bruce", "Banner", "Forward", "Liverpool", 4, 50, 987654321, new Date (13/3/1973), true);
		Player player5 = new Player("Natasha", "Romanoff", "Goalkeeper", "Bayern Munich", 5, 60, 123456789, new Date (9/9/1999), true);
		Player player6 = new Player("Thor", "Odinson", "Defender", "Juventus", 6, 70, 987654321, new Date(15/5/1925), false);
		Player player7 = new Player("Clint", "Barton", "Midfielder", "PSG", 7, 80, 123456789, new Date(8/8/1998), true);
		playerRepository.save(player1);
		playerRepository.save(player2);
		playerRepository.save(player3);
		playerRepository.save(player4);
		playerRepository.save(player5);
		playerRepository.save(player6);
		playerRepository.save(player7);

		//Probar que se crean los jugadores
		List<Player> players = playerRepository.findAll();
		assertEquals(7, players.size());

		//Probar que se encuentra el jugador con el id 7
		assertEquals("Clint", playerRepository.findById(7L).orElse(null).getName());
		assertEquals("Odinson", playerRepository.findById(6L).orElse(null).getLastName());
		assertEquals("Goalkeeper", playerRepository.findById(5L).orElse(null).getPosition());
		assertEquals("Liverpool", playerRepository.findById(4L).orElse(null).getTeam());
		assertEquals(3, playerRepository.findById(3L).orElse(null).getNumber());
		assertEquals("Tony", playerRepository.findById(2L).orElse(null).getName());
		assertEquals("Peter", playerRepository.findById(1L).orElse(null).getName());


		//Probar que se encuentra el equipo del jugador con el id 5
		assertEquals("Bayern Munich", playerRepository.findById(5L).orElse(null).getTeam());
		assertEquals("Juventus", playerRepository.findById(6L).orElse(null).getTeam());
		assertEquals("PSG", playerRepository.findById(7L).orElse(null).getTeam());



	}
	
}
