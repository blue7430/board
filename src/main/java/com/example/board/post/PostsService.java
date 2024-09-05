package com.example.board.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;
    //글 작성
    public void saveposts(PostDTO postDTO){
        Posts posts = new Posts();
        posts.setUser_id(postDTO.getUser_id());
        posts.setTitle(postDTO.getTitle());
        posts.setContent(postDTO.getContent());
        postsRepository.save(posts);
    }
    // 글 수정
    public void updateposts(PostDTO postDTO, Integer post_id) {
        Optional<Posts> optionalPosts = postsRepository.findById(post_id);
        if (optionalPosts.isPresent()) {
            Posts posts = optionalPosts.get();
            posts.setUser_id(postDTO.getUser_id());
            posts.setTitle(postDTO.getTitle());
            posts.setContent(postDTO.getContent());
            postsRepository.save(posts);
        }
    }
    //글 삭제
    public void deletepost(Integer post_id){
        postsRepository.deleteById(post_id);
    }
}
