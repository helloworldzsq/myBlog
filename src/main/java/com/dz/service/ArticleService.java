package com.dz.service;

import com.dz.pojo.Article;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleService {
    //添加文章
    int addArticle(Article article);
    //删除文章
    int deleteArticle(Integer id);
    //更新文章
    int updataArticle(Article article);
    //获取全部文章
    List<Article> allArticles();
    //根据id获取文章
    Article getArticleByid(Integer id);
    //更新文章的评论数
    int updataHitNum(Integer id,Integer hits);
    //获取文章的评论数
    Long getCommentCountById(Integer id);
    //获取文章数量
    Long getArticleCount();
    //根据关键字查询文章
    List<Article> queryArticlesByInfo(String query);
}
