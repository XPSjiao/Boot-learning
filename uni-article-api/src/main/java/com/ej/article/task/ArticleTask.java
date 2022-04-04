package com.ej.article.task;

import com.ej.article.model.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: uni-article-api
 * @description: 文章爬虫类
 * @author: yy
 * @create: 2022-03-28 15:58
 **/
@Component
@Slf4j
public class ArticleTask implements Callable<List<Article>> {
    private static final String BASE_URL = "https://godweiyang.com";
    private List<Article> articleList;

    public static void main(String[] args) throws Exception {
        ArticleTask at = new ArticleTask();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<List<Article>> future = executor.submit(at);
        List<Article> articles = future.get();
        articles.forEach(article -> System.out.println(article.getCategory() + "," + article.getTitle()));


    }

    @Override
    public List<Article> call() throws Exception {
        articleList = new ArrayList<>(100);
        Document document = null;
        //页码
        int index;
        for (index = 2; index < 5; index++) {
            //获取dom树
            document = Jsoup.connect(BASE_URL + "/page/" + index).get();
            Elements cards = document.getElementsByClass("card");
            parseCards(cards);

        }
        return articleList;
    }

    private void parseCards(Elements cards) {
        for (Element card : cards) {
            //    文章id自增
            //    文章标题
            //    通过select方法查询
            Element titleNode = card.select(".card-title").get(0);
            String title = titleNode.text();
            System.out.println(title);
            Element imgNode = card.select(".responsive-img").get(0);
            String cover = BASE_URL + imgNode.attr("src");
            System.out.println(cover);
            //文章分类
            Element categoryNode = card.select(".post-category").get(0);
            String category = categoryNode.html();
            System.out.println(category);
            Random random = new Random();
            int userId = random.nextInt(3) + 1;
            Element summaryNode = card.select(".summary").get(0);
            String summary = summaryNode.html();
            System.out.println(summary);
            //    文章连接
            String url = categoryNode.attr("href");
            //    封装文章对象
            Article article = Article.builder().userId(userId).title(title).cover(cover).category(category).url(url).summary(summary).build();
            articleList.add(article);
        }

    }

}