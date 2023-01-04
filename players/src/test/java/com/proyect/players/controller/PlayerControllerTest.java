package com.proyect.players.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import com.proyect.players.entity.Player;
import com.proyect.players.repository.PlayerRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerController playerController;


    @BeforeEach
    void createPlayer() {

        Player player1 = new Player("Peter", "Parker", "Goalkeeper", "Barcelona", 1, 20, 123456789);
		Player player2 = new Player("Tony", "Stark", "Defender", "Real Madrid", 2, 30, 987654321);
		Player player3 = new Player("Steve", "Rogers", "Midfielder", "Manchester City", 3, 40, 123456789);
		Player player4 = new Player("Bruce", "Banner", "Forward", "Liverpool", 4, 50, 987654321);
		Player player5 = new Player("Natasha", "Romanoff", "Goalkeeper", "Bayern Munich", 5, 60, 123456789);
		Player player6 = new Player("Thor", "Odinson", "Defender", "Juventus", 6, 70, 987654321);
		Player player7 = new Player("Clint", "Barton", "Midfielder", "PSG", 7, 80, 123456789);
		playerRepository.save(player1);
		playerRepository.save(player2);
		playerRepository.save(player3);
		playerRepository.save(player4);
		playerRepository.save(player5);
		playerRepository.save(player6);
		playerRepository.save(player7);

    }

    @Test
    void testCreatePlayer() {
      
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


		assertEquals("Bayern Munich", playerRepository.findById(5L).orElse(null).getTeam());
		assertEquals("Juventus", playerRepository.findById(6L).orElse(null).getTeam());
		assertEquals("PSG", playerRepository.findById(7L).orElse(null).getTeam());

    }

    @Test
    @AfterEach
    void testDeleteAllPlayers() {
        playerRepository.deleteAll();

        assertNull(playerRepository.findAll());

    }

    @Test
    void testDeletePlayer() {
        
        assertEquals(7, playerRepository.findAll().size());

        playerRepository.deleteById(1L);

        assertNull(playerRepository.findById(1L).orElse(null));
        assertEquals(6, playerRepository.findAll().size());

    }

    @Test
    void testGetAllPlayers() {

        assertEquals("Bayern Munich", playerRepository.findById(5L).orElse(null).getTeam());
		assertEquals("Juventus", playerRepository.findById(6L).orElse(null).getTeam());
		assertEquals("PSG", playerRepository.findById(7L).orElse(null).getTeam());

    }

    @Test
    void testGetPlayerById() throws Exception {
        //Realizar una petición GET al endpoint /players/{id} y comprobar que el status code sea 200
        mockMvc.perform(get("/players/{id}", 1L))
                .andExpect(status().isOk());
        perform(get("/players/{id}", 1L))
                .andExpect(status().isOk());
                

        //Realizar una petición GET al endpoint /players/{id} y comprobar que el status code sea 404
        mockMvc.perform(get("/players/{id}", 8L))
                .andExpect(status().isNotFound());
        
        // Realizar una petición HTTP GET al endpoint /players/{id}
		mockMvc.perform(get("/players/{id}", 1))
        // Verificar que se obtiene un estado HTTP 200 OK
        .andExpect(status().isOk())
        // Verificar que se esté obteniendo el nombre y apellido del jugador con id 1
        .andExpect(jsonPath("$.name").value("Lionel"))
        .andExpect(jsonPath("$.lastName").value("Messi"));
        
        }
            
    private ResultActions perform(RequestBuilder requestBuilder) {
		
		return null;
	}

	private RequestBuilder get(String string, long l) {
        return null;
    }

}
