package com.example.ppp999.test;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class State extends RealmObject {
    @PrimaryKey
    private String name;
    private int HP;
    private int Attack;

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }
}
