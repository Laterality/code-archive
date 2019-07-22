package kr.latera.customvalidationtest.web;

import kr.latera.customvalidationtest.domain.User;
import kr.latera.customvalidationtest.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @PostMapping("/user")
    public String register(@Valid UserRegisterRequestDto request, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            logger.error("User register failed: " + bindingResult.getAllErrors().get(0).getDefaultMessage());
            model.addAttribute("error", true);
            model.addAttribute("message", bindingResult.getAllErrors().get(0).getDefaultMessage());
            model.addAttribute("users", userRepository.findAll());
            return "index";
        }
        userRepository.save(User.of(request.getUsername(), request.getEmail()));
        return "redirect:/";
    }
}

