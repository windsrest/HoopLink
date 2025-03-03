package com.hooplink.service;

import com.hooplink.domain.entity.Player;
import com.hooplink.domain.enums.Role;
import com.hooplink.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;

    public Player savePlayer(Player player) {
        // 비밀번호 암호화
        player.setPassword(passwordEncoder.encode(player.getPassword()));
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findByRole(Role.ROLE_PLAYER);
    }

    public Player getPlayer(Long idx) {
        return playerRepository.findById(idx)
                .orElseThrow(() -> new RuntimeException("Player not found"));
    }

    /*public void deletePlayer(Long idx) {
        Player player = getPlayer(idx);
        if (player.getProfileImagePath() != null) {
            Path filePath = Paths.get(uploadPath, player.getProfileImagePath());
            try {
                Files.deleteIfExists(filePath);
            } catch (IOException e) {
                // Log error but continue with player deletion
            }
        }
        playerRepository.deleteById(idx);
    }*/

    private String getExtension(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".")))
                .orElse("");
    }
}
