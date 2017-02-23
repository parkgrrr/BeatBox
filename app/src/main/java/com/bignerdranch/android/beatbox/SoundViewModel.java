package com.bignerdranch.android.beatbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

/**
 * Created by pstev on 2/22/2017.
 */

public class SoundViewModel extends BaseObservable{
    private Sound mSound;
    private BeatBox mBeatBox;
    public ObservableField<String> seekBarValue = new ObservableField<>("");
    private float mRate;

    public SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    public Sound getSound(){
        return mSound;
    }

    @Bindable
    public String getTitle() {
        return mSound.getName();
    }

    public void setSound(Sound sound){
        mSound = sound;
        notifyChange();
    }

    public void onButtonClicked() {
        mBeatBox.play(mSound);
    }
}
