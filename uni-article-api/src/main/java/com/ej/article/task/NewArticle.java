package com.ej.article.task;

import com.ej.article.model.entity.Article;
import com.ej.article.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: uni-article-api
 * @description: 开源中国
 * @author: yy
 * @create: 2022-03-29 10:57
 **/
@Component
@Slf4j
public class NewArticle implements Callable<List<Article>> {
    private static final String BASE_URL = "https://www.oschina.net/news/widgets/_news_index_project_list_new?";
    @Resource
    private DateUtil dateUtil;
    private List<Article> articleList;

    public static void main(String[] args) throws Exception {
        NewArticle at = new NewArticle();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<List<Article>> future = executor.submit(at);
        List<Article> articles = future.get();
        //articles.forEach(article -> System.out.println(article.getCover()));
    }

    @Override
    public List<Article> call() throws Exception {
        articleList = new ArrayList<>(100);
        for (int i = 2; i <= 49; i++) {
            Document document = Jsoup.connect(BASE_URL + "p=" + i + "&type=ajax").userAgent("Mozilla/5.0 (Windows NT 6.1; rv:30.0) Gecko/20100101 Firefox/30.0")
                    .get();
            Elements contentList = document.getElementsByClass("news-item-hover");
            parseItem(contentList);

        }
        return articleList;
    }


    private void parseItem(Elements list) {
        for (Element item : list) {
            //文章标题
            Element titleNode = item.select(".title").get(0);
            String title = titleNode.html();
            System.out.println(title);
            //文章简介
            Element summaryNode = item.select(".line-clamp").get(0);
            String summary = summaryNode.text();
            //封面图
            String cover = "";
            Elements aNode = item.select(".ui");
            //文章链接
            String url = "";
            for (Element img : aNode) {
                if (img.getElementsByTag("img") != null) {
                    cover = img.getElementsByTag("img").tagName("img").attr("data-src");
                }
                url = img.getElementsByTag("a").last().getElementsByTag("a").tagName("a").attr("href");
                int position = url.lastIndexOf("#");
                if (position != -1) {
                    url = url.substring(0, position);
                    System.out.println(url);
                } else {
                    url = img.getElementsByTag("a").last().getElementsByTag("a").tagName("a").attr("href");
                }

            }
            //用户id
            Random random = new Random();
            int userId = random.nextInt(5) + 1;
            //总字数
            int totalWords = random.nextInt(1000);
            //浏览次数
            int pageView = random.nextInt(100);
            //便签
            String[] tags = {"大前端专区", "开发技能专区", "数据库专区", "云计算专区", "飞桨专区", "OpenHarmony专区"};
            int num = random.nextInt(5) + 1;
            //Article article = Article.builder().title(title)
            //        .summary(summary).cover(cover).url(url)
            //        .userId(userId).pageView(pageView)
            //        .createTime(dateUtil.randomDate())
            //        .category(tags[num])
            //        .duration(random.nextInt(100))
            //        .totalWords(String.valueOf(totalWords)).build();
            //articleList.add(article);
        }

    }


}