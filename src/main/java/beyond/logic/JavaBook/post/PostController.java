package beyond.logic.JavaBook.post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class PostController {


    @Autowired
    private PostService postService;

    @RequestMapping("/home")
    public ModelAndView viewHomePage(Model model) {
        ModelAndView modelAndView = new ModelAndView("feed");
        List<Post> posts = postService.posts();
        modelAndView.addObject("posts",posts);
        return modelAndView;
    }

    @RequestMapping("/post/new")
    public String showNewPostPage(Model model) {
       Post post = new Post();
        model.addAttribute("post", post);
        return "new_post";
    }

    @RequestMapping(value = "post/save", method = RequestMethod.POST)
    public String savePost(@ModelAttribute("post") Post post, Model model) {
        postService.save(post);

        return "redirect:/";
    }

    @RequestMapping("post/edit/{id}")
    public ModelAndView showEditPostPage(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit_post");
        Post post = postService.get(id);
        modelAndView.addObject("post", post);

        return modelAndView;
    }

    @RequestMapping("posts/delete/{id}")
    public String deletePost(@PathVariable(name = "id") Long id) {
        postService.delete(id);
        return "redirect:/home";
    }
}
