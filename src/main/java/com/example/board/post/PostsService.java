package com.example.board.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    public void saveposts(Integer user_id, String title, String content){
        Posts posts = new Posts();
        posts.setUser_id(user_id);
        posts.setTitle(title);
        posts.setContent(content);
        postsRepository.save(posts);
    }
}
