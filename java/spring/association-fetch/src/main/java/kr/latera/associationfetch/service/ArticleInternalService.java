package kr.latera.associationfetch.service;

import kr.latera.associationfetch.domain.Article;
import kr.latera.associationfetch.domain.Member;
import kr.latera.associationfetch.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ArticleInternalService {

    private final ArticleRepository articleRepository;

    private final MemberInternalService memberInternalService;

    @Autowired
    public ArticleInternalService(ArticleRepository articleRepository, MemberInternalService memberInternalService) {
        this.articleRepository = articleRepository;
        this.memberInternalService = memberInternalService;
    }

    public Article save(ArticleRequestDto articleRequestDto) {
        Member member = memberInternalService.findByName(articleRequestDto.getAuthorName())
            .orElseGet(() -> memberInternalService.save(articleRequestDto.getAuthorName()));
        return articleRepository.save(ArticleConverter.toEntity(articleRequestDto, member));
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
