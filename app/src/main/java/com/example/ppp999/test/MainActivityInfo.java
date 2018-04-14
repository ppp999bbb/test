package com.example.ppp999.test;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import io.realm.Realm;

public class MainActivityInfo {
    Realm realm;
    private AppCompatActivity mMain;
    PlayerState player;
    TextView textView1,textView2,textView3,textView4;
    CheckBox w_1,w_2,w_3;
    String name="Player";

    public MainActivityInfo(AppCompatActivity main){
        mMain=main;
        textView1=(TextView)mMain.findViewById(R.id.textView1);
        textView2=(TextView)mMain.findViewById(R.id.textView2);
        textView3=(TextView)mMain.findViewById(R.id.textView3);
        textView4=(TextView)mMain.findViewById(R.id.textView4);
        w_1=(CheckBox)mMain.findViewById(R.id.checkBox1);
        w_2=(CheckBox)mMain.findViewById(R.id.checkBox2);
        w_3=(CheckBox)mMain.findViewById(R.id.checkBox3);
    }

    public void onActivityStart(){
        realm=Realm.getDefaultInstance();
        player=realm.where(PlayerState.class).equalTo("playerName",name).findFirst();
        onClickW_1 click1=new onClickW_1();
        onClickW_2 click2=new onClickW_2();
        onClickW_3 click3=new onClickW_3();

        textView1.setText(player.getPlayerName());
        textView2.setText(""+player.getHP());
        textView3.setText(""+player.getMP());

        w_1.setOnClickListener(click1);
        w_2.setOnClickListener(click2);
        w_3.setOnClickListener(click3);
    }

    public class onClickW_1 implements View.OnClickListener{
        @Override
        public void onClick(View view){
            if(w_1.isChecked()==true){
                w_2.setChecked(false);
                w_3.setChecked(false);

                realm.beginTransaction();
                player=realm.where(PlayerState.class).equalTo("playerName",name).findFirst();
                player.setWeapon(1);
                realm.commitTransaction();

                textView4.setText("今装備している武器は武器１です。");
            }
        }
    }

    public class onClickW_2 implements View.OnClickListener{
        @Override
        public void onClick(View view){
            if(w_2.isChecked()==true){
                w_1.setChecked(false);
                w_3.setChecked(false);

                realm.beginTransaction();
                player=realm.where(PlayerState.class).equalTo("playerName",name).findFirst();
                player.setWeapon(2);
                realm.commitTransaction();

                textView4.setText("今装備している武器は武器２です。");
            }
        }
    }

    public class onClickW_3 implements View.OnClickListener{
        @Override
        public void onClick(View view){
            if(w_3.isChecked()==true){
                w_1.setChecked(false);
                w_2.setChecked(false);

                realm.beginTransaction();
                player=realm.where(PlayerState.class).equalTo("playerName",name).findFirst();
                player.setWeapon(3);
                realm.commitTransaction();

                textView4.setText("今装備している武器は武器３です。");
            }
        }
    }

}
