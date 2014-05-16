package com.cbh.player;

import com.cbh.entity.Program;

import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Simon on 2014/5/16.
 * 观察者
 */
public abstract class PlayerWatcher implements Observer {

    @Override
    public void update(Observable observable, Object data) {
        onPlayStatusChanged(((PlayerChanger) observable).getCurrProgramList());
    }

    public abstract void onPlayStatusChanged(LinkedHashMap<String, Program> currProgramList);

}
