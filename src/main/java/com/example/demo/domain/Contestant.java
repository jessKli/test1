package com.example.demo.domain;

public class Contestant extends Person {

  private Box selected;

  private boolean changeBox;

  public Box getSelected() {
    return selected;
  }

  public void setSelected(Box selected) {
    this.selected = selected;
  }

  public boolean isChangeBox() {
    return changeBox;
  }

  public void setChangeBox(boolean changeBox) {
    this.changeBox = changeBox;
  }

  @Override
  public String toString() {
    return "Contestant{"
        + "selected=" + selected
        + ", changeBox=" + changeBox
        + '}';
  }
}
