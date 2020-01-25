package com.example.demo.domain;

public class Box {

  private int name;

  private boolean money = false;

  private boolean turned = false;

  public Box(int name) {
    this.name = name;
  }

  public int getName() {
    return name;
  }

  public void setName(int name) {
    this.name = name;
  }

  public boolean isMoney() {
    return money;
  }

  public void setMoney(boolean money) {
    this.money = money;
  }

  public boolean isTurned() {
    return turned;
  }

  public void setTurned(boolean turned) {
    this.turned = turned;
  }

  @Override
  public String toString() {
    return "Box{" +
        "name=" + name +
        ", money=" + money +
        ", turned=" + turned +
        '}';
  }
}
