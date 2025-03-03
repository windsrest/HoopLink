package com.hooplink.repository;

import com.hooplink.domain.entity.Player;
import com.hooplink.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByRole(Role role);
}