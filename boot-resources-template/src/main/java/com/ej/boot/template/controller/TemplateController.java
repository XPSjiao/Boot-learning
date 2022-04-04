package com.ej.boot.template.controller;


import com.ej.boot.template.entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-04-04
 **/
@Controller
@RequestMapping("/template")
public class TemplateController {
    @GetMapping("/freemarker")
    public String freemarkerIndex(Model model){
        List<Article> articles = Arrays.asList(
                new Article(1,"笑笑","Daily"),
                new Article(2,"小一","Weekly"),
                new Article(3,"豆豆","Monthly"),
                new Article(4,"小怪兽","Yearly")
        );
        //把创建好的集合放在里面  属性名就叫articles
        model.addAttribute("articles",articles);
        System.out.println(articles);
        //模板名称，实际目录为：resources/templates/freemarker-demo.ftl
        return "freemarker-demo";
    }

    @GetMapping("/thymeleaf")
    public String thymeleafIndex(Model model){
        List<Article> articles = Arrays.asList(
                new Article(1,"笑笑","Daily"),
                new Article(2,"小一","Weekly"),
                new Article(3,"豆豆","Monthly"),
                new Article(4,"小怪兽","Yearly"),
                new Article(5,null,"forever")
        );
        //把创建好的集合放在里面  属性名就叫articles
        model.addAttribute("articles",articles);
        System.out.println(articles);
        //模板名称，实际目录为：resources/templates/thymeleaf-demo.html
        return "thymeleaf-demo";
    }
}
