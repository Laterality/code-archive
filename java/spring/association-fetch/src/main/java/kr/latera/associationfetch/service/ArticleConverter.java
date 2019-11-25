package kr.latera.associationfetch.service;

import kr.latera.associationfetch.domain.Article;
import kr.latera.associationfetch.domain.Member;

public class ArticleConverter {

    public static Article toEntity(ArticleRequestDto articleRequestDto, Member author) {
        return new Article(articleRequestDto.getContents(), author);
    }

    public static ArticleResponse toResponse(Article article) {
        return new ArticleResponse(
            article.getId(),
            article.getContents(),
            new ArticleResponse.ArticleAuthorResponse(
                article.getAuthor().getId(),
                article.getAuthor().getName()));
    }
}
