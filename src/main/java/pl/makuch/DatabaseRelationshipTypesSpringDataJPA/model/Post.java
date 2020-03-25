package pl.makuch.DatabaseRelationshipTypesSpringDataJPA.model;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    private User postUser;

    public Post(String content) {
        this.content = content;
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getPostUser() {
        return postUser;
    }

    public void setPostUser(User postUser) {
        this.postUser = postUser;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", postUser=" + postUser +
                '}';
    }
}
