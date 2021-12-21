package com.reflix.server.movie;


import com.reflix.server.configure.response.DataResponse;
import com.reflix.server.configure.response.ResponseService;
import com.reflix.server.movie.client.ImageApiClient;
import com.reflix.server.movie.dto.ImageResponseDto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Image API"})
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app")
public class ImageController {

    private final ImageApiClient imageApiClient;
    private final ResponseService responseService;

    @Operation(summary = "이미지 조회 API", description = "API로 이미지 정보 호출")
    @GetMapping(value = "/images/api/{keyword}")
    public DataResponse<ImageResponseDto.Item> getImageByAPI(@PathVariable(name = "keyword") String keyword) {
        ImageResponseDto.Item item = imageApiClient.requestImage(keyword).getItems()[0];
        return responseService.getDataResponse(item);
    }

}
