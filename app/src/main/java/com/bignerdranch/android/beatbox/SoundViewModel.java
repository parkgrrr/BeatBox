package com.bignerdranch.android.beatbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.util.Log;
import android.widget.SeekBar;

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

    public void onValueChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
        Log.v("OVC", "On value change method called");
        seekBarValue.set(progressValue + "");
        int id = mSound.getSoundId();
        mRate = ((float) progressValue);
        mBeatBox.setRate(id, mRate);
    }
}
