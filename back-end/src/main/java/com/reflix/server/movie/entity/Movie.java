package com.reflix.server.movie.entity;

import com.reflix.server.account.entity.Account;
import com.reflix.server.configure.entity.BaseTimeEntity;
import com.reflix.server.configure.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Movie extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String title;
    private String link;
    private String image;
    private String subtitle;
    private Date pubDate;
    private String director;
    private String actor;
    private float userRating;

    @BatchSize(size = 200)
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "accountId")
    private Account account;

}
