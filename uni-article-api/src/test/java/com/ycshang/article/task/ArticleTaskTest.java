package com.yy.article.task;

import com.ej.article.model.entity.Article;
import com.ej.article.task.ArticleTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ArticleTaskTest {
    @Resource
    private ArticleTask articleTask;

    @Test
    void getArticle() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), Executors.defaultThreadFactory());
        Future<List<Article>> future = executor.submit(articleTask);
        List<Article> articles = future.get();
        System.out.println(articles);

    }

}