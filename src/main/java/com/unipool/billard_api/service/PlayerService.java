
package com.unipool.billard_api.service;

import com.unipool.billard_api.dto.PlayerDTO;
import com.unipool.billard_api.model.Player;
import com.unipool.billard_api.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll().isEmpty() ? null : playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public Player getPlayerByEmail(String email) {
         return playerRepository.findByEmail(email);
    }

    public Player getPlayerByEmailAndPassword(String email, String password) {
        return playerRepository.findByEmailAndPassword(email, password);
    }

    public Player createPlayer(PlayerDTO playerRequest) {
        if (playerRepository.findByEmail(playerRequest.getEmail())!= null) {
            return null;
        }
        Player player = new Player();
        player.setEmail(playerRequest.getEmail());
        player.setPassword(playerRequest.getPassword());
        player.setFirstName(playerRequest.getFirstName());
        player.setLastName(playerRequest.getLastName());

        return playerRepository.save(player);
    }

    public boolean existsByEmail(String email) {
        return playerRepository.findByEmail(email)!=null;
    }
}