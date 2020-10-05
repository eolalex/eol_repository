package org.bibalex.eol.repositories;

import org.bibalex.eol.collections.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ArticleRepository extends MongoRepository<Article, UUID> {

      List<Article> findByresourceId(int resourceId);
      Article findByResourceIdAndArticleId(int resourceId, String articleId);
}
