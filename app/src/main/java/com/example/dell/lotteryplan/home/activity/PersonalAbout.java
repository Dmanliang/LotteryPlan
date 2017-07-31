package com.example.dell.lotteryplan.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.dell.lotteryplan.R;
import com.example.dell.lotteryplan.base.BaseActivity;

public class PersonalAbout extends BaseActivity implements OnClickListener{

	private LinearLayout	personal_about_back_layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setView(R.layout.personal_aboutus);
		initView();
	}

	public void initView(){
		personal_about_back_layout = (LinearLayout) findViewById(R.id.personal_about_back_layout);
		personal_about_back_layout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.personal_about_back_layout:
				finish();
				break;
		}
	}
}
