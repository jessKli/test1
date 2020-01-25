package com.example.demo.service;

import com.example.demo.domain.Box;

public interface PlayGame {

  Box [] createBoxes();

  String playNumberOfGames(int numberOfGames, Box ... boxes);
}
