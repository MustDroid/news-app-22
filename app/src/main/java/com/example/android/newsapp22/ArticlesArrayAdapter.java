package com.example.android.newsapp22;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Emoke Hajdu on 6/23/2018.
 */

public class ArticlesArrayAdapter extends ArrayAdapter<Article> {

    private List<Article> mArticles;

    public ArticlesArrayAdapter(Context context, List<Article> articles) {
        super(context, R.layout.article, articles);

        this.mArticles = articles;
    }
    private class ViewHolder {
        public TextView txtTitle;
        public TextView txtAuthor;
        public TextView txtPublishedAt;
        public TextView txtDescription;
        public TextView txtURL;
}

    public List<Article> getArticles() {
        return mArticles;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.article, parent, false);

            viewHolder.txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
            viewHolder.txtAuthor = (TextView) convertView.findViewById(R.id.txtAuthor);
            viewHolder.txtPublishedAt = (TextView) convertView.findViewById(R.id.txtPublishedAt);
            viewHolder.txtDescription = (TextView) convertView.findViewById(R.id.txtDescription);
            viewHolder.txtURL = (TextView) convertView.findViewById(R.id.txtURL);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Article article = mArticles.get(position);
        viewHolder.txtTitle.setText(article.getTitle());
        if(article.getAuthor().equals("null")) {
            viewHolder.txtAuthor.setText("no author");
        }
        else {
            viewHolder.txtAuthor.setText(article.getAuthor());
        }
        viewHolder.txtPublishedAt.setText(article.getPublishedAt());
        viewHolder.txtDescription.setText(article.getDescription());
        String html = "<a href='" + article.getURL() + "'>Read More...</a>";
        //viewHolder.txtURL.setText(article.getURL());

        viewHolder.txtURL.setText(Html.fromHtml(html));
        viewHolder.txtURL.setMovementMethod(LinkMovementMethod.getInstance());

        return convertView;
    }
}
