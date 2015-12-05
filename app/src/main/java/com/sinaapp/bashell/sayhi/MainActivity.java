package com.sinaapp.bashell.sayhi;

import com.gauss.recorder.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private Button startBtn, stopBtn;
	private EditText serverEdt, myStreamEdt, toStreamEdt;
	private RtmpClientTest mRtmpClient = new RtmpClientTest();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();

	}

	private void initView() {
		startBtn = (Button) findViewById(R.id.button1);
		stopBtn = (Button) findViewById(R.id.button2);
		serverEdt = (EditText) findViewById(R.id.editText1);
		myStreamEdt = (EditText) findViewById(R.id.editText2);
		toStreamEdt = (EditText) findViewById(R.id.editText3);

		startBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final String server = serverEdt.getText().toString().trim();
				final String myStream = myStreamEdt.getText().toString().trim();
				final String toStream = toStreamEdt.getText().toString().trim();
				byte myId = Byte.parseByte(myStream);
				byte peerId = Byte.parseByte(toStream);
				mRtmpClient.init(server, myId);
				mRtmpClient.sayTo(peerId);
			}
		});
		stopBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mRtmpClient.close();
			}
		});
	}

}
