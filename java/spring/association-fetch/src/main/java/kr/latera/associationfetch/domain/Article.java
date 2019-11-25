package kr.latera.associationfetch.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contents;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Member author;

    protected Article() {
    }

    public Article(String contents, Member author) {
        this.contents = contents;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }

    public Member getAuthor() {
        return author;
    }
}
