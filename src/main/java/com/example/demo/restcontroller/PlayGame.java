package com.example.demo.restcontroller;

import com.example.demo.domain.Box;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayGame {

  @Autowired
  private com.example.demo.service.PlayGame playGame;

  @RequestMapping("/")
  public String index() {
    Box[] boxes = playGame.createBoxes();
    return playGame.playNumberOfGames(100, boxes);
  }
}
