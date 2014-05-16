package com.cbh.player;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import com.cbh.entity.Constants;
import com.cbh.entity.PlayerStatus;
import com.cbh.entity.Program;

/**
 * Created by Simon on 2014/5/16.
 */
public class PlayerService extends Service {

    private PlayerChanger mPlayerChanger;

    private Handler mPlayerHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constants.KEY_HANDLER_DATA_CHANGED:
                    //
                    break;
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();

        // init PlayerChanger
        mPlayerChanger = PlayerChanger.getInstance();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // get action、Program
        if (intent != null && intent.getExtras() != null) {
            Program program = (Program) intent.getSerializableExtra(Constants.KEY_PLAYER_ENTITY);
            PlayerStatus status = (PlayerStatus) intent.getSerializableExtra(Constants.KEY_PLAYER_ACTION);
            switch (status) {
                case PLAY:
                    play(program);
                    break;
                case PAUSE:
                    pause(program);
                    break;
                case PREV:
                    prev(program);
                    break;
                case NEXT:
                    next(program);
                    break;
                case SEEKTO:
                    seekTo(program);
                    break;
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    private void play(Program program) {
        PlayerThread thread = new PlayerThread(PlayerStatus.PLAY, program, mPlayerHandler);
        thread.start();
    }

    private void pause(Program program) {
    }

    private void prev(Program program) {
    }

    private void next(Program program) {
    }

    private void seekTo(Program program) {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
