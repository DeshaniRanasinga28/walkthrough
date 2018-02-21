package com.newsalerts.ef.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by EF on 20-Feb-18.
 */

public class Prefs {
    public static final String PREFS_NAME = "WalkTrought";

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor prefsEditor;

    public Prefs(Context context) {
        this.mPrefs = context.getSharedPreferences(PREFS_NAME, Activity.MODE_PRIVATE);
        this.prefsEditor = mPrefs.edit();
    }
    public void setIntroShowed(boolean isShowed) {
        prefsEditor.putBoolean("isShowed", isShowed);
        prefsEditor.commit();
    }


}
