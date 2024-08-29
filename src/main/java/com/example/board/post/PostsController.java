package com.example.board.post;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PostsController {
    private final PostsRepository postsRepository;
    private final PostsService postsService;

    @GetMapping("/board")
    public String board(Model model) {
        List<Posts> result = postsRepository.findAll();
        model.addAttribute("posts", result);
        return "board";
    }

    @GetMapping("/board/write-form")
    public String write() {
        return "write-form";
    }

    @PostMapping("/board/write-form")
    public String addPost(Integer user_id, String title, String content) {
        postsService.saveposts(user_id, title, content);
        return "redirect:/board";
    }

    @GetMapping("/board/post/{id}")
    public String post(@PathVariable Integer post_id, Model model) {
        return "post";
    }
}






