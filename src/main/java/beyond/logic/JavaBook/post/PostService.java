package beyond.logic.JavaBook.post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> posts() {
        return postRepository.findAll();
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public Post get(Long id) {
        return postRepository.findById(id).get();
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
