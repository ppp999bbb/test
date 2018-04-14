package com.example.ppp999.test;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PlayerState extends RealmObject {
    @PrimaryKey
    private String playerName;
    private int position;
    private int maxHP;
    private int maxMP;
    private int HP;
    private int MP;
    private int SP;
    private int ATK;
    private int weapon;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) { this.maxHP = maxHP; }

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int attack) {
        ATK = attack;
    }

    public int getPosition() { return position; }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getSP() { return SP; }

    public void setSP(int SP) { this.SP = SP; }

    public int getWeapon() { return weapon; }

    public void setWeapon(int weapon) { this.weapon = weapon; }
}
