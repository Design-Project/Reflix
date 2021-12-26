package com.reflix.server.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponseDto {

    private int display;
    private ImageResponseDto.Item[] items;

    @Data
    @NoArgsConstructor
    public static class Item {
        private String title;
        private String link;
        private String thumbnail;
    }

}
