package org.bibalex.eol.repositories;

import org.bibalex.eol.collections.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ArticleRepository extends MongoRepository<Article, UUID> {

      Page<Article> findByresourceId(int resourceId, Pageable pageable);
      Article findByResourceIdAndArticleId(int resourceId, String articleId);
}
