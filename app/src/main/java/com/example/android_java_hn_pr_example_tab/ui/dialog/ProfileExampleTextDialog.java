package com.example.android_java_hn_pr_example_tab.ui.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.viewpager.widget.ViewPager;

import com.example.android_java_hn_pr_example_tab.R;
import com.example.android_java_hn_pr_example_tab.ui.adapter.ProfileExampleTextPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class ProfileExampleTextDialog {

    public void showExampleTextDialog(Activity activity, final ProfileExampleTextDialogListener listener){

        // activity で受け取ったcontextに作成する

        // https://techacademy.jp/magazine/3715
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = LayoutInflater.from(activity);
        final View view = inflater.inflate(R.layout.dialog_profile_example_text, null, false);

        final ViewPager viewPager = view.findViewById(R.id.pager);

        final ProfileExampleTextPagerAdapter adapter = new ProfileExampleTextPagerAdapter(activity);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        builder.setTitle(R.string.profile_example_title);
        builder.setView(view);

        // テキスト IDを取得して、クリックリスナーを作成している

        //
        builder.setPositiveButton(R.string.profile_example_use, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onSelectListener(
                        adapter.getText(viewPager.getCurrentItem()));
            }
        });

        // キャンセルボタンも同時に定義している
        builder.setNegativeButton(R.string.button_common_cancel, null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public interface ProfileExampleTextDialogListener {
        void onSelectListener(String selectText);
    }
}