package com.di6.jsoupdemo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.ldy.htmllibrary.HtmlParseUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity {

    private String htmlUrl = "https://m.toutiao.com/is/dePMvgf/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String htmlContent = HtmlParseUtil.parseHtml(htmlUrl);
                Document document = Jsoup.parse(htmlContent);
                Elements article = document.getElementsByClass("syl-article-base");
                Log.i("4654564", "onCreate: " + article.html());
            }
        }).start();
    }
}