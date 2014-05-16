package com.cbh.player;

import android.os.Handler;

import com.cbh.entity.PlayerStatus;
import com.cbh.entity.Program;

/**
 * Created by Simon on 2014/5/16.
 */
public class PlayerThread extends Thread {

    private Program program;
    private Handler handler;
    private PlayerStatus status = PlayerStatus.STOP;

    public PlayerThread(PlayerStatus status, Program program, Handler handler) {
        this.status = status;
        this.program = program;
        this.handler = handler;
    }

    @Override
    public void run() {
        // 播放

    }
}
