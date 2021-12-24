package com.reflix.server.movie.client;

import com.reflix.server.movie.dto.ImageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class ImageApiClient {

    @Value("${naver.X_NAVER_CLIENT_ID}")
    private String CLIENT_ID;

    @Value("${naver.X_NAVER_CLIENT_SECRET}")
    private String CLIENT_SECRET;

    RestTemplate restTemplate = new RestTemplate();
    private final String OpenNaverImageUrl_getImage = "https://openapi.naver.com/v1/search/image.json?query={keyword}&display=1&start=1&sort=sim";

    public ImageResponseDto requestImage(String keyword) {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(OpenNaverImageUrl_getImage, HttpMethod.GET, entity, ImageResponseDto.class, keyword).getBody();
    }
}