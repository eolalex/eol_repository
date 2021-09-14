package org.bibalex.eol.services;


import org.bibalex.eol.collections.Article;
import org.bibalex.eol.handler.APIConfiguration;
import org.bibalex.eol.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

@Service
public class ArticleService {
    
    @Autowired
    private ArticleRepository articleRepo;

    @Autowired
    APIConfiguration apiConfiguration;

    public List<Article> getByResourceId(int resourceId, int page)
    {
        Pageable paging = createArticlesPage(page);
        Page<Article> articlesPage = articleRepo.findByresourceId(resourceId, paging);
        return articlesPage.getContent();
    }

    public Article getByResourceAndPk(int resourceId, String articleId)
    {
        return articleRepo.findByResourceIdAndArticleId(resourceId,articleId);
    }

    public void insertArticles(List<Article> articles)
    {
        articleRepo.insert(articles);

    }

    public long countArticles()
    {
        return articleRepo.count();
    }

    private Pageable createArticlesPage(int page)
    {
        return new PageRequest(page, apiConfiguration.getArticlesBatchSize());
    }

}
