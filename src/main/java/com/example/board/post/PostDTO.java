package com.example.board.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
    private Integer post_id;
    private Integer user_id;
    private String title;
    private String content;
}
