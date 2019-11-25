package kr.latera.associationfetch.repository;

import kr.latera.associationfetch.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
