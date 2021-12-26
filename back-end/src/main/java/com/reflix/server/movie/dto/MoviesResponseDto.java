package com.reflix.server.movie.dto;

import com.reflix.server.movie.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class MoviesResponseDto {
    private int display;
    private Item[] items;

    @Data
    @NoArgsConstructor
    public static class Item {
        private Integer rank;
        public String title;
        public String link;
        public String image;
        public String subtitle;
        public Date pubDate;
        public String director;
        public String actor;
        public float userRating;
        public Item(Movie movie) {
            this.title = movie.getTitle();
            this.link = movie.getLink();
            this.image = movie.getImage();
            this.subtitle = movie.getSubtitle();
            this.pubDate = movie.getPubDate();
            this.director = movie.getDirector();
            this.actor = movie.getActor();
            this.userRating = movie.getUserRating();
        }
    }
}