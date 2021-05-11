package beyond.logic.JavaBook.post;

import beyond.logic.JavaBook.user.User;

import javax.persistence.*;

@Entity
public class Post {
    private Long id;
    private String body;
    private String postTime;



    @ManyToOne
    private User user;

    public Post(User user) {
        this.user = user;
    }

    public Post() {
    }

    public Post(Long id, String body,String postTime) {
        this.id = id;
        this.body = body;
        this.postTime = postTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
