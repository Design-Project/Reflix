package com.reflix.server.movie;

import com.reflix.server.configure.response.CommonResponse;
import com.reflix.server.configure.response.DataResponse;
import com.reflix.server.configure.response.ResponseService;
import com.reflix.server.configure.security.authentication.CustomUserDetails;
import com.reflix.server.movie.client.ImageApiClient;
import com.reflix.server.movie.client.MovieAPI;
import com.reflix.server.movie.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Account API"})
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app")
public class MovieController {

    private final MovieAPI movieAPI;
    private final ResponseService responseService;
    private final PostService postService;
    private final ImageApiClient imageApiClient;

    @Operation(summary = "영화 순위 조회 API", description = "API로 영화 정보 호출")
    @GetMapping(value = "/movies/ranking")
    public DataResponse<List<MoviesResponseDto.Item>> getMoviesRanking() {
        List<MoviesResponseDto.Item> items = movieAPI.requestAPI();
        return responseService.getDataResponse(items);
    }

    @Operation(summary = "영화 이름으로 검색 API", description = "이름으로 영화 정보 호출")
    @GetMapping(value = "/movies/name/{title}")
    public DataResponse<MoviesResponseDto.Item> getMovieByTitle(@PathVariable String title) {
        MoviesResponseDto.Item item = movieAPI.getMovieByTitle(title);
        ImageResponseDto.Item imageItem = imageApiClient.requestImage(item.title).getItems()[0];
        item.setImage(imageItem.getLink());
        return responseService.getDataResponse(item);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-ACCESS-TOKEN", value = "로그인 성공 후 토큰", dataTypeClass = String.class, paramType = "header")
    })
    @Operation(summary = "영화 정보 포스팅 API", description = "dto를 기준으로 포스팅")
    @PostMapping(value = "/movies/posts")
    public CommonResponse createPost(@AuthenticationPrincipal CustomUserDetails customUserDetails, @RequestBody CreatePostReq dto) {
        postService.createPost(customUserDetails, dto);
        return responseService.getSuccessResponse();
    }

    @Operation(summary = "영화 정보 포스트 조회 API", description = "모든 포스트를 조회")
    @GetMapping(value = "/movies/posts")
    public DataResponse<List<PostRes>> getAllPost() {
        List<PostRes> list = postService.getAllPost();
        return responseService.getDataResponse(list);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-ACCESS-TOKEN", value = "로그인 성공 후 토큰", dataTypeClass = String.class, paramType = "header")
    })
    @Operation(summary = "포스트 댓글 생성 API", description = "JWT 토큰과 PostId를 기준으로 댓글 생성")
    @PostMapping(value = "/movies/posts/{postId}/replies")
    public CommonResponse createReply
            (@AuthenticationPrincipal CustomUserDetails customUserDetails,@PathVariable(value = "postId") Long postId, @RequestBody CreateReplyReq dto) {
        postService.createPost(customUserDetails, postId, dto);
        return responseService.getSuccessResponse();
    }

    @Operation(summary = "포스트 댓글 조회", description = "postId를 기준으로 댓글 조회")
    @GetMapping(value = "/movies/posts/{postId}/replies")
    public DataResponse<List<ReplyListRes>> getReplyList(@PathVariable(value = "postId") Long postId) {
        List<ReplyListRes> list = postService.getReplyList(postId);
        return responseService.getDataResponse(list);
    }



}
