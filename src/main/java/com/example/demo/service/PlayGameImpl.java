package com.example.demo.service;

import com.example.demo.domain.Box;
import com.example.demo.domain.Contestant;
import com.example.demo.domain.PersonType;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class PlayGameImpl implements PlayGame {


  @Override
  public Box[] createBoxes() {
    // Create three boxes and select which one has the money
    Box[] boxes = new Box[3];
    for(int i = 0; i<3; i++) {
      boxes[i] = (new Box(i));
    }
    return boxes;
  }

  @Override
  public String playNumberOfGames(int numberOfGames, Box... boxes) {
    int winningNoChangeOfBox = 0;
    int winningChangeOfBox = 0;

    Contestant contestant = new Contestant();
    contestant.setPersonType(PersonType.CONTESTANT);
    contestant.setChangeBox(false);

    for(int i = 0;i<numberOfGames;i++){

      if(startGame(contestant, boxes)){
        winningNoChangeOfBox++;
      }
      resetBoxes(boxes);
    }
    contestant.setChangeBox(true);
    for(int i = 0;i<numberOfGames;i++){

      if(startGame(contestant, boxes)){
        winningChangeOfBox++;
      }
      resetBoxes(boxes);
    }
    String result = " When playing {0} times if you change box you won {1} times." +
        " When playing another {0} times and you didn''t change box you won {2} times";
    return MessageFormat.format(result, numberOfGames, winningChangeOfBox, winningNoChangeOfBox);
  }

  private void resetBoxes(Box ... boxes) {
    for(Box box : boxes) {
      box.setMoney(false);
      box.setTurned(false);
    }
  }

  private boolean startGame(Contestant contestant, Box ... boxes) {
    setBoxHasMoney(boxes);

    // Choose which box he thinks the money are in
    contestant.setSelected(boxes[selectBox(boxes)]);

    // Turn one box that isnt selected by contestant and not has money
    turnBox(contestant.getSelected(), boxes);

    return isAWinner(contestant);
  }

  private boolean isAWinner(Contestant contestant) {

    return (contestant.isChangeBox() && !contestant.getSelected().isMoney())
        || (!contestant.isChangeBox() && contestant.getSelected().isMoney());
  }

  private void turnBox(Box selectedByContestant, Box ... boxes) {
    List<Box> possibleToTurn = new ArrayList<>();
    for(Box box : boxes) {
      if(!box.equals(selectedByContestant) && !box.isMoney()) {
        possibleToTurn.add(box);
      }
    }
    int i = selectBox(possibleToTurn.toArray(new Box[possibleToTurn.size()]));
    possibleToTurn.get(i).setTurned(true);
  }

  private void setBoxHasMoney(Box ... boxes) {
    int boxHasMoney = selectBox(boxes);
    boxes[boxHasMoney].setMoney(true);
  }

  public static int selectBox(Box ... boxes) {
    return new Random().nextInt(boxes.length);
  }
}
