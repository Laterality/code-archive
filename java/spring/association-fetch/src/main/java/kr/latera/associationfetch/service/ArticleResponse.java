package kr.latera.associationfetch.service;

import java.util.Objects;

public class ArticleResponse {

    private final Long id;
    private final String contents;
    private final ArticleAuthorResponse author;

    public ArticleResponse() {
        id = null;
        contents = null;
        author = null;
    }

    public ArticleResponse(Long id, String contents, ArticleAuthorResponse author) {
        this.id = id;
        this.contents = contents;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }

    public ArticleAuthorResponse getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleResponse that = (ArticleResponse) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(contents, that.contents) &&
            Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contents, author);
    }

    @Override
    public String toString() {
        return String.format("{ id: %d, contents: %s, authorName: %s }", id, contents, author.name);
    }

    public static class ArticleAuthorResponse {

        private final Long id;
        private final String name;

        public ArticleAuthorResponse() {
            id = null;
            name = null;
        }

        public ArticleAuthorResponse(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArticleAuthorResponse that = (ArticleAuthorResponse) o;
            return id == that.id &&
                Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
}
