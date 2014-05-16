package com.cbh.player;

import android.content.Context;
import android.content.Intent;

import com.cbh.entity.Constants;
import com.cbh.entity.PlayerStatus;
import com.cbh.entity.Program;

/**
 * Created by Simon on 2014/5/16.
 * 播放管理类
 */
public class PlayerManager {
    private Context context;
    private long prevExecuteTime;
    private static final long MIN_EXECUTION_INTERVEL = 200;

    private static PlayerManager instance;

    private PlayerManager(Context context) {
        this.context = context;
        // 启动播放服务
        context.startService(new Intent(context, PlayerService.class));
    }

    public static PlayerManager getInstance(Context context) {
        if (instance == null) {
            instance = new PlayerManager(context);
        }
        return instance;
    }

    // 播放
    public void play(Program program) {
        if (checkIfIsExecutable()) {
            context.startService(getIntent(program, PlayerStatus.PLAY));
        }
    }

    // 暂停
    public void pause(Program program) {
        if (checkIfIsExecutable()) {
            context.startService(getIntent(program, PlayerStatus.PAUSE));
        }
    }

    // 上一曲
    public void prev(Program program) {
        if (checkIfIsExecutable()) {
            context.startService(getIntent(program, PlayerStatus.PREV));
        }
    }

    // 下一曲
    public void next(Program program) {
        if (checkIfIsExecutable()) {
            context.startService(getIntent(program, PlayerStatus.NEXT));
        }
    }

    // 跳至
    public void seekTo(Program program) {
        if (checkIfIsExecutable()) {
            context.startService(getIntent(program, PlayerStatus.SEEKTO));
        }
    }

    // 添加观察者
    public void addObserver(PlayerWatcher observer) {
        PlayerChanger.getInstance().addObserver(observer);
    }

    // 移除观察者
    public void removeObserver(PlayerWatcher observer) {
        PlayerChanger.getInstance().deleteObserver(observer);
    }

    private Intent getIntent(Program program, PlayerStatus status) {
        Intent intent = new Intent(context, PlayerService.class);
        intent.putExtra(Constants.KEY_PLAYER_ENTITY, program);
        intent.putExtra(Constants.KEY_PLAYER_ACTION, status);
        return intent;
    }

    private boolean checkIfIsExecutable() {
        long currExecuteTime = System.currentTimeMillis();
        if (currExecuteTime - prevExecuteTime < MIN_EXECUTION_INTERVEL) {
            return false;
        } else {
            prevExecuteTime = currExecuteTime;
            return true;
        }
    }
}
