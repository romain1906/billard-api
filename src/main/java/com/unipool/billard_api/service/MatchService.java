package com.unipool.billard_api.service;

import com.unipool.billard_api.dto.MatchCreatDTO;
import com.unipool.billard_api.model.Match;
import com.unipool.billard_api.model.Player;
import com.unipool.billard_api.repository.MatchRepository;
import com.unipool.billard_api.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class MatchService {

    @Autowired
    private  MatchRepository matchRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public Match createMatch(MatchCreatDTO dto) {
        Match match = new Match();
        Player player1 = playerRepository.findById(dto.getPlayer1Id())
                .orElseThrow(() -> new RuntimeException("Player 1 not found"));

        Player player2 = playerRepository.findById(dto.getPlayer2Id())
                .orElseThrow(() -> new RuntimeException("Player 2 not found"));

        Player createdBy = playerRepository.findById(dto.getCreateBy())
                .orElseThrow(() -> new RuntimeException("Creator not found"));

        match.setPlayer1(player1);
        match.setPlayer2(player2);
        match.setCreatedBy(createdBy);
        Date date = new Date();
        match.setDateMatch(date.toString());

        return matchRepository.save(match);
    }

}
