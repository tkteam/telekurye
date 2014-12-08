package com.telekurye.ui2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.telekurye.utils.Info;

public class Statusbar2 extends LinearLayout {

	private TextView	tvVersion;

	public Statusbar2(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.setOrientation(HORIZONTAL);

		// Textview Layout params
		LayoutParams lptvHeader = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		// lptvHeader.weight=10;
		lptvHeader.width = 50;
		lptvHeader.topMargin = 5;
		lptvHeader.rightMargin = 5;

		tvVersion = new TextView(context);
		tvVersion.setTextSize(12);
		tvVersion.setTextColor(Color.parseColor("#FFFFFF"));
		tvVersion.setTypeface(null, Typeface.BOLD);
		addView(tvVersion, lptvHeader);

		tvVersion.setText("v." + Integer.toString(Info.CURRENT_VERSION));
	}

}
