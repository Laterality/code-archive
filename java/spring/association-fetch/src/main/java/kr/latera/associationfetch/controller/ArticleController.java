package kr.latera.associationfetch.controller;

import kr.latera.associationfetch.service.ArticleRequestDto;
import kr.latera.associationfetch.service.ArticleResponse;
import kr.latera.associationfetch.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    private ResponseEntity save(@RequestBody ArticleRequestDto request) {
        ArticleResponse article = articleService.save(request);

        return ResponseEntity.created(URI.create("/articles/" + article.getId()))
            .body(article);
    }

    @GetMapping
    private ResponseEntity findAll() {
        return ResponseEntity.ok(articleService.findAll());
    }
}
