package com.unipool.billard_api.repository;

import com.unipool.billard_api.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    
    Player findByEmailAndPassword(String email, String password);

    Player findByEmail(String email);
}


