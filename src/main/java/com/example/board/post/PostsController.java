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

    @GetMapping("/board")//글 목록
    public String board(Model model) {
        List<Posts> result = postsRepository.findAll();
        model.addAttribute("posts", result);
        return "board";
    }

    @GetMapping("/board/write-form")//글 작성
    public String write() {
        return "write-form";
    }

    @PostMapping("/board/write-form")
    public String writePost(Integer user_id, String title, String content) {
        postsService.saveposts(user_id, title, content);
        return "redirect:/board";
    }

    @GetMapping("/board/post/{post_id}")//상세페이지
    public String post(@PathVariable Integer post_id, Model model) {
        Optional<Posts> result = postsRepository.findById(post_id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "post";
        } else {
            return "redirect:/board";
        }
    }

    @GetMapping("/board/post/{post_id}/edit")//글 수정
    public String edit(@PathVariable Integer post_id, Model model) {
        Optional<Posts> result = postsRepository.findById(post_id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "edit";
        } else {
            return "redirect:/board";
        }
    }

    @PostMapping("/board/post/{post_id}/edit")
    public String editpost(Integer user_id, String title, String content, Integer post_id){
        postsService.updateposts(user_id, title, content, post_id);
        return "redirect:/board";
    }

    @GetMapping("/board/post/{post_id}/delete")
    public String delete(@PathVariable Integer post_id, Model model) {
        Optional<Posts> result = postsRepository.findById(post_id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "delete";
        } else {
            return "redirect:/board";
        }
    }

    @PostMapping("/board/post/{post_id}/delete")
    public String deletePost(@PathVariable Integer post_id, Model model){
        postsService.deletepost(post_id);
        return "redirect:/board";
    }
}