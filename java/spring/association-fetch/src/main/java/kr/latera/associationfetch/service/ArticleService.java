package kr.latera.associationfetch.service;

import kr.latera.associationfetch.domain.Article;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleInternalService articleInternalService;

    public ArticleService(ArticleInternalService articleInternalService) {
        this.articleInternalService = articleInternalService;
    }

    public ArticleResponse save(ArticleRequestDto request) {
        Article article = articleInternalService.save(request);

        return ArticleConverter.toResponse(article);
    }

    public List<ArticleResponse> findAll() {
        return articleInternalService.findAll()
            .stream()
            .map(ArticleConverter::toResponse)
            .collect(Collectors.toList());
    }

}
