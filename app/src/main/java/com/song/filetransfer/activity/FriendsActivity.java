package com.song.filetransfer.activity;


import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.song.filetransfer.R;
import com.song.filetransfer.base.BaseWebActivity;
import com.song.filetransfer.service.WebService;

public class FriendsActivity extends BaseWebActivity{
    public final String TAG = getClass().getName();
    private TextView mTextView;
    private Button mButton1;
    private Button mButton2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        mTextView = (TextView) findViewById(R.id.text);
        mButton1 =(Button) findViewById(R.id.bt_friends_send);
        mButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
        mButton2 =(Button) findViewById(R.id.bt_friends_choose_file);
        mButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FriendsActivity.this,FileChooserActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void addFiltersToIntentFilter(IntentFilter mIntentFilter) {
        mIntentFilter.addAction("com.song.transfer.ACTION_DISPLAY_USER_IN");
    }

    @Override
    protected void onReceiveIntent(Context context, Intent intent) {
        Log.d(TAG,"received intent");

        String  action = intent.getAction();
        switch (action){
            case "com.song.transfer.ACTION_DISPLAY_USER_IN":
                mTextView.setText(intent.getExtras().getString("VALUE"));
                mTextView.append(getBaseContext().getClass().getName().toString());
                break;
        }
    }
}
