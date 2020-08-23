package com.rdbf.demo.apiauth.controller;

import com.rdbf.demo.apiauth.domain.Article;
import com.rdbf.demo.apiauth.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
    private final ArticleRepository articleRepository;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value = "/article")
    List<Article> findAll() {
        return articleRepository.findAll();
    }

    @GetMapping(value = "/article/{id}")
    Article findByArticleId(@PathVariable Integer id) {

        return articleRepository.findByArticleId(id);
    }

    @PostMapping(value = "/article")
    public void createArticle( @RequestBody @DateTimeFormat(pattern = "yyyy-MM-DD") Article creteArticleData) {

        LOGGER.info("createArticle::::::::::::::::::::::::::" + creteArticleData.toString());
        articleRepository.createArticle(creteArticleData);

    }

    @PutMapping(value = "/article")
    public void updateArticle( @RequestBody Article updateArticleData) {


        articleRepository.updateArticle(updateArticleData);

    }









}
