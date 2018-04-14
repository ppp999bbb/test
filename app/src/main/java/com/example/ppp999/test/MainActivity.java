package com.example.ppp999.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private Realm realm;
    MainActivityInfo mainInfo;
    public static final int PREFERENCE_INIT = 0;
    public static final int PREFERENCE_BOOTED = 1;
    String boss="Boss";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm=Realm.getDefaultInstance();

        setInitDate();

        mainInfo=new MainActivityInfo(this);
        mainInfo.onActivityStart();
    }

    public void BattleStart(View view){
        int enemy;
        State state;
        Intent intent;
        Random rand=new Random();
        enemy=rand.nextInt(1);

        if(enemy==0){
            state=realm.where(State.class).equalTo("name",boss).findFirst();
        }

        intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    private void setState(int state){
        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(this);
        sp.edit().putInt("InitState",state).commit();
    }

    private int getState(){
        int state;
        SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
        state=sp.getInt("InitState",PREFERENCE_INIT);

        return state;
    }

    public void setInitDate(){
        if(PREFERENCE_INIT==getState()){
            setEnemyState set=new setEnemyState();
            setInitPlayerState setP=new setInitPlayerState();
            realm.executeTransaction(set);
            realm.executeTransaction(setP);

            setState(PREFERENCE_BOOTED);
        }
    }

    public void onDestroy(){
        super.onDestroy();
        realm.close();
    }

}
