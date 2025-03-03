package com.hooplink.domain.entity;

import com.hooplink.domain.enums.Position;
import com.hooplink.domain.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String uniformNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    private Integer height;

    private Integer weight;

    @ElementCollection(targetClass = Position.class)
    @CollectionTable(
            name = "player_positions",
            joinColumns = @JoinColumn(name = "player_idx"),
            indexes = @Index(name = "idx_player_position", columnList = "position")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Set<Position> positions = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_PLAYER;

    private String profileImagePath;
}