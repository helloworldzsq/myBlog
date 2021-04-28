package com.dz.service.serviceImpl;

import com.dz.dao.ArticleMapper;
import com.dz.dao.TypeMapper;
import com.dz.pojo.Article;
import com.dz.pojo.Type;
import com.dz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public int addArticle(Article article) {
        String type = article.getType();
        List<Type> types = typeMapper.allTypes();
        for (Type type1 : types) {
            if (type1.getName().equals(type))
                article.setTid(type1.getId());
        }
        return articleMapper.addArticle(article);
    }

    @Override
    public int deleteArticle(Integer id) {
        return articleMapper.deleteArticle(id);
    }

    @Override
    public int updataArticle(Article article) {
        return articleMapper.updataArticle(article);
    }

    @Override
    public List<Article> allArticles() {
        return articleMapper.allArticles();
    }

    @Override
    public Article getArticleByid(Integer id) {
        return articleMapper.getArticleByid(id);
    }

    @Override
    public int updataHitNum(Integer id, Integer hits) {
        return articleMapper.updataHitNum(id,hits);
    }


    @Override
    public Long getCommentCountById(Integer id) {
        return articleMapper.getCommentCountById(id);
    }


    @Override
    public Long getArticleCount() {
        return articleMapper.getArticleCount();
    }

    @Override
    public List<Article> queryArticlesByInfo(String query) {
        return articleMapper.queryArticlesByInfo(query);
    }
}
