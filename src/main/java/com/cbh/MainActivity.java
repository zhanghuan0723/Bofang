package com.cbh;

import android.app.Activity;
import android.os.Bundle;

import com.cbh.entity.Program;
import com.cbh.player.PlayerWatcher;
import com.cbh.player.PlayerManager;

import java.util.LinkedHashMap;

public class MainActivity extends Activity {

    private PlayerWatcher mPlayerWatcher = new PlayerWatcher() {
        @Override
        public void onPlayStatusChanged(LinkedHashMap<String, Program> currProgramList) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        PlayerManager.getInstance(this).addObserver(mPlayerWatcher);
    }

    @Override
    protected void onPause() {
        super.onPause();
        PlayerManager.getInstance(this).removeObserver(mPlayerWatcher);
    }

}
