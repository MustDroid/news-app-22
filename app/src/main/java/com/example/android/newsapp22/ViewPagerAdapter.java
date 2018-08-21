package com.example.android.newsapp22;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Emoke Hajdu on 7/5/2018.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        Bundle args = new Bundle();

        switch (position) {
            case 0:
                args.putString("newsUrl", "https://newsapi.org/v2/top-headlines?country=hu&apiKey=1367ca6037c84efdbc1a89eff9a1569c");
                break;
            case 1:
                args.putString("newsUrl", "https://newsapi.org/v2/top-headlines?country=tr&apiKey=1367ca6037c84efdbc1a89eff9a1569c");
                break;
            case 2:
                args.putString("newsUrl", "https://newsapi.org/v2/top-headlines?country=sk&apiKey=1367ca6037c84efdbc1a89eff9a1569c");
                break;
            case 3:
                args.putString("newsUrl", "https://newsapi.org/v2/top-headlines?country=ru&apiKey=1367ca6037c84efdbc1a89eff9a1569c");
                break;
            case 4:
                args.putString("newsUrl", "https://newsapi.org/v2/top-headlines?country=at&apiKey=1367ca6037c84efdbc1a89eff9a1569c");
                break;
        }
        ArticlesFragment result = new ArticlesFragment();
        result.setArguments(args);
        return result;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}