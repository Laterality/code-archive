package kr.latera.associationfetch.controller;

import kr.latera.associationfetch.service.ArticleRequestDto;
import kr.latera.associationfetch.service.ArticleResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArticleControllerTests {

    private static final Long DEFAULT_MEMBER_ID = 1L;
    private static final String DEFAULT_MEMBER_NAME = "John";
    private static final Long DEFAULT_ARTICLE_ID = 1L;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void save() {
        String contents = UUID.randomUUID().toString();
        EntityExchangeResult<ArticleResponse> response = webTestClient.post().uri("/articles")
            .body(Mono.just(new ArticleRequestDto(contents, DEFAULT_MEMBER_NAME)), ArticleRequestDto.class)
            .exchange()
            .expectStatus().isCreated()
            .expectBody(ArticleResponse.class).returnResult();

        String[] tokens = response.getResponseHeaders().getLocation().getPath().split("/");
        Long id = Long.valueOf(tokens[tokens.length - 1]);

        assertThat(response.getResponseBody())
            .isEqualTo(new ArticleResponse(id, contents,
                new ArticleResponse.ArticleAuthorResponse(DEFAULT_MEMBER_ID, DEFAULT_MEMBER_NAME)));
    }

    @Test
    void find_all() {
        webTestClient.get().uri("/articles")
            .exchange()
            .expectBody()
            .jsonPath("$").isArray();
    }
}
