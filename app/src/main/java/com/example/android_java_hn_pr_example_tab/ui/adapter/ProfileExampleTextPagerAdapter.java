package com.example.android_java_hn_pr_example_tab.ui.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.example.android_java_hn_pr_example_tab.R;

import java.util.ArrayList;

public class ProfileExampleTextPagerAdapter extends PagerAdapter {

    /** コンテキスト. */
    private Context mContext;

    private ArrayList<String> mTextList;

    private static final String TAG_NAME = "#name";
    private static final String TAG_AREA = "#area";
    private static final String TAG_AGE = "#age";

    /**
     * コンストラクタ.
     */
    public ProfileExampleTextPagerAdapter(Context context) {
        mContext = context;
        mTextList = new ArrayList<>();

        // profile_example_text で定義した、一覧を取得している
        String[] stringList = context.getResources().getStringArray(R.array.profile_example_text);


        // profile_example_text の 文章を全て取得して、
        for (int i = 0; i < stringList.length; i++){
            // 文章を整形

            String string = stringList[i];
            string = string.replace(TAG_NAME, "「名前」");
            string = string.replace(TAG_AREA, "「住所」");
            string = string.replace(TAG_AGE, "「年齢」");
            mTextList.add(string);
        }
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(R.string.profile_example)+(position+1);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // View を生成
        TextView textView = new TextView(mContext);
        textView.setText(mTextList.get(position));
        textView.setTextColor(mContext.getResources().getColor(R.color.text_color_default));
        float density = mContext.getResources().getDisplayMetrics().density;

        int padding = (int)density * 10;
        textView.setPadding(padding, padding, padding, padding);

        ScrollView scrollView = new ScrollView(mContext);

        scrollView.setLayoutParams(new ScrollView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        scrollView.addView(textView);
        // コンテナに追加
        container.addView(scrollView);

        return scrollView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // コンテナから View を削除
        container.removeView((View) object);
    }


    // getCount()
    //全体の数を取得する
    @Override
    public int getCount() {
        // リストのアイテム数を返す
        return mTextList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // Object 内に View が存在するか判定する
        return view == object;
    }

    public String getText(int position){
        return mTextList.get(position);
    }
}