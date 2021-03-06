package beyond.logic.JavaBook.post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long> {
    Post findByName(Long id);
}
