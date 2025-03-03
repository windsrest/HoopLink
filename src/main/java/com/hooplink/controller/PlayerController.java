package com.hooplink.controller;

import com.hooplink.domain.entity.Player;
import com.hooplink.dto.player.PlayerForm;
import com.hooplink.service.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("playerForm", new PlayerForm());
        return "players/register";
    }

    @GetMapping
    public String list(Model model) {
        List<Player> players = playerService.getAllPlayers();
        model.addAttribute("players", players);
        return "players/list";  // list.html 뷰를 찾음
    }

    @PostMapping
    public String register(@Valid @ModelAttribute PlayerForm form,
                           BindingResult result) {
        if (result.hasErrors()) {
            return "players/register";
        }

        Player player = new Player();
        BeanUtils.copyProperties(form, player);
        playerService.savePlayer(player);

        return "redirect:/players";
    }
}