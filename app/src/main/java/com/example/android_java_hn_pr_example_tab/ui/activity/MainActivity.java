package com.example.android_java_hn_pr_example_tab.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_java_hn_pr_example_tab.R;
import com.example.android_java_hn_pr_example_tab.ui.dialog.ProfileExampleTextDialog;

public class MainActivity extends AppCompatActivity {

    Button mDialog_open_bt;

    EditText mPr_container;

//    Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 画面要素を取得
        mDialog_open_bt = findViewById(R.id.dialog_open_bt);
        mPr_container = findViewById(R.id.pr_container);

        mDialog_open_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileExampleTextDialog mProfileExampleTextDialog = new ProfileExampleTextDialog();
                mProfileExampleTextDialog.showExampleTextDialog (getParent(), new ProfileExampleTextDialog.ProfileExampleTextDialogListener() {
                    @Override
                    public void onSelectListener(String selectText) {
                        mPr_container.setText(selectText);
                    }
                });
            }
        });


    }


}


