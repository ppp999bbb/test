package com.example.ppp999.test;

import io.realm.Realm;

public class setEnemyState implements Realm.Transaction {
    @Override
    public void execute(Realm realm){
        State state=realm.createObject(State.class,new String("Boss"));
        state.setAttack(1);
        state.setHP(30);
    }
}
