package com.ldy.htmllibrary;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class HtmlParseUtil {

    public static String parseHtml(String url) {
        WebClient wc = new WebClient(BrowserVersion.CHROME);
        // 启用JS解释器，默认为true
        wc.getOptions().setJavaScriptEnabled(true);
        // 禁用css支持
        wc.getOptions().setCssEnabled(false);
        // js运行错误时，是否抛出异常
        wc.getOptions().setThrowExceptionOnScriptError(false);
        // 状态码错误时，是否抛出异常
        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
        // 设置连接超时时间 ，这里是5S。如果为0，则无限期等待
        wc.getOptions().setTimeout(5000);
        // 是否允许使用ActiveX
        wc.getOptions().setActiveXNative(false);
        // 等待js时间
        wc.waitForBackgroundJavaScript(2 * 1000);
        // 设置Ajax异步处理控制器即启用Ajax支持
        wc.setAjaxController(new NicelyResynchronizingAjaxController());
        // 不跟踪抓取
        wc.getOptions().setDoNotTrackEnabled(false);
        try {
            HtmlPage htmlPage = wc.getPage(url);
            return htmlPage.asXml();
//            Document document = Jsoup.parse(htmlPage.asXml());
//            Elements article = document.getElementsByClass("syl-article-base");
//            Log.i("4654564", "onCreate: " + article.html());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
