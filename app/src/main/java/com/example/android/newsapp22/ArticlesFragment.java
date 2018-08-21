package com.example.android.newsapp22;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Emoke Hajdu on 7/5/2018.
 */

public class ArticlesFragment extends Fragment {
    private ArticlesArrayAdapter articlesArrayAdapter;
    private ListView lstArticles;
    private String newsUrl;

    private class UpdateNewsTask extends AsyncTask<Void, Integer, NewsResponse> {
        protected NewsResponse doInBackground(Void... params) {
            String json = RestClient.doGETRequest(newsUrl);

            return new NewsResponse(json);
        }

        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(final NewsResponse result) {

            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    updateNewsList(result.getArticles());
                }
            });
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.articles_fragment, container, false);

        lstArticles = view.findViewById(R.id.lstArticles);

        newsUrl = getArguments().getString("newsUrl");

        UpdateNewsTask task = new UpdateNewsTask();
        task.execute();

        return view;
    }

    private void updateNewsList(List<Article> articles) {
        // TODO: create list in MainActivity
        articlesArrayAdapter = new ArticlesArrayAdapter(getActivity(), articles);
        lstArticles.setAdapter(articlesArrayAdapter);
    }
}




