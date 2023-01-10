package com.proyect.players;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.proyect.players.entity.Player;
import com.proyect.players.repository.PlayerRepository;


@SpringBootApplication
public class PlayersApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PlayersApplication.class, args);
		PlayerRepository repository = context.getBean(PlayerRepository.class);
		
		repository.save(new Player("Lionel", "Messi", "Delantero", "Barcelona", 10, 33, 999888777, new Date(12-12-1980), true));
		repository.save(new Player("Cristiano", "Ronaldo", "Delantero", "Juventus", 7, 36, 99999, new Date(7/7/1987), true));
		repository.save(new Player("Neymar", "Jr", "Delantero", "PSG", 10, 29, 999999, new Date(12/12/1990), true));
		repository.save(new Player("Kevin", "De Bruyne", "Mediocampista", "Manchester City", 17, 30, 999999, new Date(8/9/1991), true));
		repository.save(new Player("Kylian", "Mbappe", "Delantero", "PSG", 7, 23, 99999, new Date(27/1/2001), true));
		repository.save(new Player("Robert", "Lewandowski", "Delantero", "Bayern Munich", 9, 32, 999999, new Date (29/02/2000), true));
		repository.save(new Player("Sadio", "Mane", "Delantero", "Liverpool", 10, 29, 999999, new Date(11/11/2001), true));
		repository.save(new Player("Mohamed", "Salah", "Delantero", "Liverpool", 11, 29, 999999, new Date(3/2/1972), true));
		repository.save(new Player("Eden", "Hazard", "Delantero", "Real Madrid", 7, 30, 999999, new Date(25/5/1999), true));
		
		/*repository.findAll().forEach(System.out::println);
		System.out.println("El jugador con el id 7 es: " + repository.findById(7L).orElse(null).getName() + " " + repository.findById(7L).orElse(null).getLastName());
		System.out.println("El jugador con el id 4 es: " + repository.findById(4L).orElse(null).getName() + " " + repository.findById(4L).orElse(null).getLastName());
		System.out.println("El equipo del jugador con el id 5 es: " + repository.findById(5L).orElse(null).getTeam());*/

	
		
	}

}
