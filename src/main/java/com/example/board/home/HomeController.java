package com.example.board.home;

import com.example.board.post.Posts;
import com.example.board.post.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {


    @GetMapping("/")
    public String main () {
        return "redirect:/board";
    }

}