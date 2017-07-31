package com.example.dell.lotteryplan.home.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.example.dell.lotteryplan.R;
import com.example.dell.lotteryplan.base.BaseActivity;

public class PersonalDisclaimer extends BaseActivity implements OnClickListener{

	private LinearLayout mz_state_back_layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setView(R.layout.personal_disclaimer);
		initViews();
	}

	public void initViews(){
		mz_state_back_layout = (LinearLayout)findViewById(R.id.mz_state_back_layout);
		mz_state_back_layout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.mz_state_back_layout:
				finish();
				break;
		}
	}
}
