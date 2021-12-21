package com.reflix.server.movie;

import com.reflix.server.movie.client.MovieApiClient;
import com.reflix.server.movie.dto.MoviesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class MoviesService {
    private final MovieApiClient movieApiClient;

    @Transactional(readOnly = true)
    public MoviesResponseDto findByKeyword(String keyword) {
        return movieApiClient.requestMovie(keyword);
    }

}
