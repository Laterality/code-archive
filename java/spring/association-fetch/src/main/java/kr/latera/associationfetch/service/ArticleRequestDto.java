package kr.latera.associationfetch.service;

public class ArticleRequestDto {

    private String contents;
    private String authorName;

    public ArticleRequestDto() {
    }

    public ArticleRequestDto(String contents, String authorName) {
        this.contents = contents;
        this.authorName = authorName;
    }

    public String getContents() {
        return contents;
    }

    public String getAuthorName() {
        return authorName;
    }
}
