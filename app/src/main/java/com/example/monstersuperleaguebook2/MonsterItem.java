package com.example.monstersuperleaguebook2;

public class MonsterItem {

    String monsterName;
    int monsterPicture;

    public MonsterItem() {
    }

    public MonsterItem(String name, int monsterPicture) {
        this.monsterName = name;
        this.monsterPicture = monsterPicture;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMonsterPicture() {
        return monsterPicture;
    }

    public void setMonsterPicture(int monsterPicture) {
        this.monsterPicture = monsterPicture;
    }
}
