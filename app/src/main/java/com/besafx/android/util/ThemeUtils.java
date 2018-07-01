package com.besafx.android.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.besafx.android.R;

public class ThemeUtils {

    public static void applyTheme(Activity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("Data", Context.MODE_PRIVATE);
        Integer theme = sharedPreferences.contains("theme") ? Integer.parseInt(sharedPreferences.getString("theme", null)) : R.style.AppTheme;
        activity.getApplicationContext().setTheme(theme);
        activity.setTheme(theme);
    }
}
