package com.wahyuridiansyah.abrakadabra;

import android.app.Application;
import android.content.Context;

/**
 * Created by Andri Ginting on 4/15/2017.
 */

public class App extends Application {
    private static Context mainContext;

    public static Context getMainContext() {
        return mainContext;
    }

    public static void setMainContext(Context mainContext) {
        App.mainContext = mainContext;
    }
}
