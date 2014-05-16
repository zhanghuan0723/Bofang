package com.cbh.player;

import com.cbh.entity.Program;

import java.util.LinkedHashMap;
import java.util.Observable;

/**
 * Created by Simon on 2014/5/16.
 * 被观察者
 */
public class PlayerChanger extends Observable {

    // 当前正在播放节目
    private Program currProgram;

    // 当前播放列表
    private LinkedHashMap<String, Program> currProgramList;

    public Program getCurrProgram() {
        return currProgram;
    }

    public LinkedHashMap<String, Program> getCurrProgramList() {
        return currProgramList;
    }

    private static PlayerChanger instance;

    private PlayerChanger() {
        currProgram = new Program();
        currProgramList = new LinkedHashMap<String, Program>();
    }

    public static PlayerChanger getInstance() {
        if (instance == null) {
            instance = new PlayerChanger();
        }
        return instance;
    }

    public void notifyDataChanged(Program program) {
        setChanged();
        notifyObservers();
    }
}
