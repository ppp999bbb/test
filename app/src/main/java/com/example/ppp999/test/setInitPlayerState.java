package com.example.ppp999.test;

import io.realm.Realm;

public class setInitPlayerState implements Realm.Transaction {
    @Override
    public void execute(Realm realm){
        PlayerState InitState=realm.createObject(PlayerState.class,new String("Player"));
        InitState.setHP(10);
        InitState.setMP(10);
        InitState.setMaxHP(10);
        InitState.setMaxMP(10);
        InitState.setATK(1);
    }
}
