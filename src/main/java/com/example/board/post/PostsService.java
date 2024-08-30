package com.example.board.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;
    //글 작성
    public void saveposts(Integer user_id, String title, String content){
        Posts posts = new Posts();
        posts.setUser_id(user_id);
        posts.setTitle(title);
        posts.setContent(content);
        postsRepository.save(posts);
    }
    // 글 수정
    public void updateposts(Integer user_id, String title, String content, Integer post_id){
        Optional<Posts> optionalPosts = postsRepository.findById(post_id);
        Posts posts = optionalPosts.get();
        posts.setPost_id(post_id);
        posts.setUser_id(user_id);
        posts.setTitle(title);
        posts.setContent(content);
        postsRepository.save(posts);
    }
}
