
package com.example.dell.lotteryplan.home.activity;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.lotteryplan.R;
import com.example.dell.lotteryplan.base.BaseActivity;
import com.example.dell.lotteryplan.base.Constants;
import com.example.dell.lotteryplan.util.Util;
import com.meiqia.core.callback.OnInitCallback;
import com.meiqia.meiqiasdk.util.MQConfig;
import com.meiqia.meiqiasdk.util.MQIntentBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PersonalActivity extends BaseActivity {

	private LinearLayout        back;
	private Button 				connectBtn, qaBtn, statebtn, updateBtn;
	private View   				updateView;
	private static final int    EMPTY   = 0xFFFFFFFF;
	private static final int    SUCCESS = 0xFFFFEEEE;
	private DownloadManager 	downloadManager;
	private long                id;
	private TimerTask 			mTimerTask;
	private String              downloadUrl;
	private RelativeLayout		rootRelative;
	private boolean 			isUpdate = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setView(R.layout.personal_main);
		initView();
	}

	private void checkClientVersion() {
		mHandler.post(mRunnableCheckVersion);
	}

	public void initView(){
		back       	= (LinearLayout)findViewById(R.id.personal_about_back_layout);
		connectBtn 	= (Button) findViewById(R.id.personal_main_about);
		qaBtn 		= (Button) findViewById(R.id.personal_main_qa);
		statebtn 	= (Button) findViewById(R.id.personal_main_disclaimer);
		updateBtn 	= (Button) findViewById(R.id.personal_main_update);
		rootRelative=(RelativeLayout)findViewById(R.id.rootRelative);

		MQConfig.init(PersonalActivity.this, "a54876992351e243a40ed52de0abb4e1", new OnInitCallback() {
			public void onSuccess(String clientId) {
			}

			public void onFailure(int code, String message) {
				Toast.makeText(PersonalActivity.this, "与客服连接失败", Toast.LENGTH_SHORT).show();
			}
		});
		//设置美洽
		MQConfig.ui.titleBackgroundResId=R.color.orangeTitle;
		MQConfig.ui.titleTextColorResId=R.color.colorwhile;
		MQConfig.isVoiceSwitchOpen=true;
		MQConfig.isSoundSwitchOpen=true;
		MQConfig.isLoadMessagesFromNativeOpen=true;

		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		connectBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				PersonalActivity.this.startActivity(new Intent(PersonalActivity.this, PersonalAbout.class));
			}
		});
		qaBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new MQIntentBuilder(PersonalActivity.this).build();
				startActivity(intent);
			}
		});
		statebtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PersonalActivity.this.startActivity(new Intent(PersonalActivity.this, PersonalDisclaimer.class));
			}
		});
		updateBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				checkClientVersion();
			}
		});

	}

	public void showUpdateItem() {
		updateView = PersonalActivity.this.getLayoutInflater().inflate(R.layout.download_activity, null);
		final PopupWindow popupWindow = new PopupWindow(updateView, LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT, true);
		popupWindow.setTouchable(true);
		popupWindow.setOutsideTouchable(true);
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#80000000")));
		if (popupWindow.isShowing()) {
			popupWindow.dismiss();
		} else {
			popupWindow.showAtLocation(rootRelative, Gravity.CENTER, 0, 0);
			popupWindow.setFocusable(true);
			popupWindow.getContentView().setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View view, MotionEvent motionEvent) {
					return false;
				}
			});
		}
		TextView updateText	   =	(TextView)updateView.findViewById(R.id.update_finish);
		Button   updateButton  = 	(Button)updateView.findViewById(R.id.btn_download);
		updateText.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
		updateButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if(!isUpdate){
					isUpdate=true;
					downloadAPK(downloadUrl);
					popupWindow.dismiss();
				}else{
					Toast.makeText(PersonalActivity.this,"已更新啦!",Toast.LENGTH_SHORT).show();
				}
			}
		});
		updateText.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				popupWindow.dismiss();
			}
		});


	}

	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what != EMPTY) {
				String           localVersion   = Util.getVersion(PersonalActivity.this);
				Bundle           bundles        = msg.getData();
				String           serverVersion  = bundles.getString("version");
				downloadUrl           			= bundles.getString("url");
				if (localVersion.compareTo(serverVersion) >= 0) {
					Toast.makeText(PersonalActivity.this, "当前最新版本", Toast.LENGTH_SHORT).show();
				} else {
					showUpdateItem();
					Toast.makeText(PersonalActivity.this, "有新版本", Toast.LENGTH_SHORT).show();
				}
			}
		}
	};

	private void downloadAPK(String downloadUrl) {
		downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
		DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
		request.setTitle(getString(R.string.app_name));
		request.setMimeType("application/vnd.android.package-archive");
		request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
		Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).mkdir();
		request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, getString(R.string.app_name) + ".apk");
		id = downloadManager.enqueue(request);
		final DownloadManager.Query query = new DownloadManager.Query();
		Timer timer = new Timer();
		mTimerTask = new TimerTask() {
			@Override
			public void run() {
				Cursor cursor = downloadManager.query(query.setFilterById(id));
				if (cursor != null && cursor.moveToFirst()) {
					if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))
							== DownloadManager.STATUS_SUCCESSFUL) {
						mTimerTask.cancel();
						Intent intent = new Intent(Intent.ACTION_VIEW);
						intent.setDataAndType(Uri.parse("file://" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getName() + "/" + getString(R.string.app_name) + ".apk"), "application/vnd.android.package-archive");
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//4.0以上系统弹出安装成功打开界面
						startActivity(intent);
					}
					cursor.close();
				}
			}
		};
		timer.schedule(mTimerTask, 0, 500);
	}

	private OkHttpClient mClient               = new OkHttpClient();
	private Runnable     mRunnableCheckVersion = new Runnable() {
		@Override
		public void run() {
			Request request = new Request.Builder()
					.url(Constants.API + "/client/check_client_version?os=android")
					.build();
			mClient.newCall(request).enqueue(new Callback() {
				@Override
				public void onFailure(Call call, IOException e) {
					mHandler.sendEmptyMessage(EMPTY);
				}

				@Override
				public void onResponse(Call call, Response response) throws IOException {
					try {
						JSONObject 	root        = new JSONObject(response.body().string());
						JSONObject 	data       	= root.getJSONObject("data");
						String     	versions 	= data.getString("version");
						String     	urls       	= data.getString("url");
						Message 	message     = mHandler.obtainMessage();
						Bundle      bundle   	= new Bundle();
						bundle.putString("version",versions);
						bundle.putString("url",urls);
						message.what = SUCCESS;
						message.setData(bundle);
						mHandler.sendMessage(message);
					} catch (JSONException e) {

					}
				}
			});
		}
	};


}