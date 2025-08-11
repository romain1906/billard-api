package com.unipool.billard_api.controller;

import com.unipool.billard_api.dto.PlayerDTO;
import com.unipool.billard_api.model.ApiResponse;
import com.unipool.billard_api.model.Player;
import com.unipool.billard_api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/all")
    public ApiResponse getAllPlayers() {
        return new ApiResponse(true, "List of all players", playerService.getAllPlayers());
    }

    @GetMapping("/{id}")
    public ApiResponse getPlayerById(@PathVariable Long id) {
        return new ApiResponse(true, "Player with id " + id, playerService.getPlayerById(id));
    }
    @PostMapping("")
    public ApiResponse createPlayer(@RequestBody PlayerDTO player) {
        if (playerService.existsByEmail(player.getEmail())) {
            return new ApiResponse(false, "Player with this email already exists", null);
        }
        try {
            if (player.getEmail() == null || player.getPassword() == null || player.getFirstName() == null || player.getLastName() == null) {
                return new ApiResponse(false, "All fields are required", null);
            }else{
                return new ApiResponse(true, "Player created", playerService.createPlayer(player));
            }
        } catch (Exception e) {
            return new ApiResponse(false, "Error processing request: " + e.getMessage(), null);
        }
    }

    @PostMapping("/exists")
    public ApiResponse existsByEmail(@RequestBody String email) {
        if(playerService.existsByEmail(email)){
            return new ApiResponse(true, "Player already exists", true);
        } else {
            return new ApiResponse(true, "Player does not exist", false);
        }
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody PlayerDTO player) {
        if (player.getEmail() == null || player.getPassword() == null) {
            return new ApiResponse(false, "Email and password are required", null);
        }
        Player existingPlayer = playerService.getPlayerByEmailAndPassword(player.getEmail(), player.getPassword());

        if (existingPlayer != null) {
            return new ApiResponse(true, "Login successful", existingPlayer);
        } else {
            return new ApiResponse(false, "Invalid email or password", null);
        }
    }

}
