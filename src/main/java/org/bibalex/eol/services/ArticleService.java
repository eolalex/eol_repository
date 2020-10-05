package org.bibalex.eol.services;


import org.bibalex.eol.collections.Article;
import org.bibalex.eol.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    
    @Autowired
    ArticleRepository articleRepo;

    public List<Article> getByResourceId(int resourceId)
    {
        return articleRepo.findByresourceId(resourceId);
    }

    public Article getByResourceAndPk(int resourceId, String articleId)
    {
        return articleRepo.findByResourceIdAndArticleId(resourceId,articleId);
    }

    public void insertArticles(List<Article> media)
    {

    }

    public long countArticles()
    {
        return articleRepo.count();
    }

}
