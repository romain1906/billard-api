package com.unipool.billard_api.controller;

import com.unipool.billard_api.dto.MatchCreatDTO;
import com.unipool.billard_api.model.Match;
import com.unipool.billard_api.repository.MatchRepository;
import com.unipool.billard_api.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchService matchService;


    @PostMapping("/resultats")
    public ResponseEntity<?> enregistrerResultat(@RequestBody Match match) {
        matchRepository.save(match);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> creerMatch(@RequestBody MatchCreatDTO match) {
        Match savedMatch = matchService.createMatch(match);
        return ResponseEntity.ok(savedMatch);
    }


}

