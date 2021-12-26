package com.reflix.server.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostReq {

    private String movieNameByClient;

    private String contents;

    private Integer rating;

}
