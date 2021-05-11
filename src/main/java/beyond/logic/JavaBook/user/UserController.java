package beyond.logic.JavaBook.user;

import beyond.logic.JavaBook.post.Post;
import beyond.logic.JavaBook.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView showLogin(){
        return new ModelAndView("index");
    }

     @RequestMapping(value = "/register", method = RequestMethod.POST)
     public ModelAndView showRegister(){
         ModelAndView modelAndView = new ModelAndView("signup");
         modelAndView.addObject("user");
         return modelAndView;
     }


    @RequestMapping(value = "user/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        userService.save(user);
        String message = "You have successfully registered, now login!!";
        return "redirect:/home";
    }

    @RequestMapping("user/edit/{id}")
    public ModelAndView showEditPostPage(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit_user");
        User user = userService.get(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }


    @RequestMapping("posts/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userService.delete(id);
        String message = "You account has been deleted";
        return "redirect:/";
    }
}
