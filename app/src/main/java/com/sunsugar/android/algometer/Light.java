package com.sunsugar.android.algometer;

import android.view.View;
import android.widget.ImageView;

/**
 * Light object class. A light object refers to a certain view in the row of lights.
 * Its visibility and image resource can be set.
 */
public class Light {
    private ImageView mView;
    private int mSerialNr;
    private boolean mVisibility;
    private boolean mOnOff;

    public Light(){}

    public Light(ImageView view, int serialNr){
        mView = view;
        mView.setVisibility(View.VISIBLE);
        mSerialNr = serialNr;
        mVisibility = true;
        mOnOff = false;
    }

    public ImageView getView() {
        return mView;
    }

    public int getSerialNr() {
        return mSerialNr;
    }

    public boolean isOnOff() {
        return mOnOff;
    }

    public boolean isVisibile() {
        return mVisibility;
    }

    public void setView(ImageView mView) {
        this.mView = mView;
    }

    public void setSerialNr(int mSerialNr) {
        this.mSerialNr = mSerialNr;
    }

    public void setOnOff(boolean mOnOff) {
        this.mOnOff = mOnOff;
    }

    public void setVisibility(boolean visibility) {
        this.mVisibility = visibility;
        if (visibility)mView.setVisibility(View.VISIBLE);
        else mView.setVisibility(View.INVISIBLE);
    }
}
