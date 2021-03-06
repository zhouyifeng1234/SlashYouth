package com.slash.youth.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

import com.slash.youth.global.SlashApplication;

public class CommonUtils {
	public static Context getContext() {
		return SlashApplication.getContext();
	}

	public static int getMainThreadId() {
		return SlashApplication.getMainThreadId();
	}

	public static Handler getHandler() {
		return SlashApplication.getHandler();
	}

	public static String getString(int id) {
		return getContext().getResources().getString(id);
	}

	public static Drawable getDrawable(int id) {
		return getContext().getResources().getDrawable(id);
	}

	public static int getColor(int id) {
		return getContext().getResources().getColor(id);
	}

	public static String[] getStringArr(int id) {
		return getContext().getResources().getStringArray(id);
	}

	public static int getDimen(int id) {
		return getContext().getResources().getDimensionPixelSize(id);
	}

	public static float getDensity() {
		return getContext().getResources().getDisplayMetrics().density;
	}

	public static int dip2px(float dp) {
		float density = getDensity();
		return (int) (dp * density + 0.5f);
	}

	public static float px2dip(int px) {
		float density = getDensity();
		return px / density;
	}

	public static View inflate(int id) {
		return View.inflate(getContext(), id, null);
	}

	public static boolean isRunOnUiThread() {
		int myTid = android.os.Process.myTid();
		if (myTid == getMainThreadId()) {
			return true;
		}
		return false;
	}

	public static void runOnUiThread(Runnable runnable) {
		Handler handler = getHandler();
		if (isRunOnUiThread()) {
			runnable.run();
		} else {
			handler.post(runnable);
		}
	}

	public static ColorStateList getColorStateList(int mTabTextColorResId) {
		// TODO Auto-generated method stub
		return getContext().getResources()
				.getColorStateList(mTabTextColorResId);
	}
}
