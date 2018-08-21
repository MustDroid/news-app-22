package com.example.android.newsapp22;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emoke Hajdu on 7/5/2018.
 */

public class NewsResponse {
    private String mStatus;
    private int mTotalResults;
    private List<Article> mArticles;

    public NewsResponse(String json) {
        try {
            JSONObject jsonNewsResponse = new JSONObject(json);

            mStatus = jsonNewsResponse.getString("status");
            mTotalResults = jsonNewsResponse.getInt("totalResults");

            JSONArray jsonArticlesArray = jsonNewsResponse.getJSONArray("articles");
            mArticles = new ArrayList<>();

            for (int i = 0; i < jsonArticlesArray.length(); i++) {
                JSONObject jsonArticle = jsonArticlesArray.getJSONObject(i);
                Article article = new Article(jsonArticle.getString("author"),
                        jsonArticle.getString("title"),
                        jsonArticle.getString("description"),
                        jsonArticle.getString("url"),
                        jsonArticle.getString("urlToImage"),
                        jsonArticle.getString("publishedAt"));
                mArticles.add(article);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public List<Article> getArticles() {
        return mArticles;
    }
}

