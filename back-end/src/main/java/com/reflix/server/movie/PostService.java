package com.reflix.server.movie;

import com.reflix.server.account.AccountRepository;
import com.reflix.server.account.entity.Account;
import com.reflix.server.configure.response.exception.CustomException;
import com.reflix.server.configure.response.exception.CustomExceptionStatus;
import com.reflix.server.configure.security.authentication.CustomUserDetails;
import com.reflix.server.movie.client.ImageApiClient;
import com.reflix.server.movie.client.MovieAPI;
import com.reflix.server.movie.dto.*;
import com.reflix.server.movie.entity.Post;
import com.reflix.server.movie.entity.Reply;
import com.reflix.server.movie.repository.PostRepository;
import com.reflix.server.movie.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.reflix.server.configure.entity.Status.VALID;

@Service
@RequiredArgsConstructor
public class PostService {

    private final AccountRepository accountRepository;
    private final MovieAPI movieAPI;
    private final ImageApiClient imageApiClient;
    private final PostRepository postRepository;
    private final ReplyRepository replyRepository;

    @Transactional
    public void createPost(CustomUserDetails customUserDetails, CreatePostReq dto) {

        Account account = accountRepository.findByEmailAndStatus(customUserDetails.getEmail(), VALID)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.ACCOUNT_NOT_VALID));

        MoviesResponseDto.Item movieByTitle = movieAPI.getMovieByTitle(dto.getMovieNameByClient());
        ImageResponseDto.Item item = imageApiClient.requestImage(movieByTitle.getTitle()).getItems()[0];
        String movieImage = item.getLink();

        Post build = Post.builder()
                .status(VALID)
                .movieTitle(movieByTitle.getTitle())
                .account(account)
                .content(dto.getContents())
                .imageUrl(movieImage)
                .rating(dto.getRating())
                .likeCount(0)
                .build();

        postRepository.save(build);

    }

    @Transactional(readOnly = true)
    public List<PostRes> getAllPost() {
        return postRepository.findAllByStatusOrderByUpdatedAtDesc(VALID);
    }

    @Transactional
    public void createPost(CustomUserDetails customUserDetails, Long postId, CreateReplyReq dto) {

        Account account = accountRepository.findByEmailAndStatus(customUserDetails.getEmail(), VALID)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.ACCOUNT_NOT_VALID));

        Post post = postRepository.findPostByPostIdAndStatus(postId, VALID)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.POST_NOT_FOUND));

        Reply reply = new Reply(account, post, dto.getContents());

        replyRepository.save(reply);


    }

    @Transactional(readOnly = true)
    public List<ReplyListRes> getReplyList(Long postId) {

        Post post = postRepository.findPostByPostIdAndStatus(postId, VALID)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.POST_NOT_FOUND));

        return replyRepository.findAllByPostAndStatus(post, VALID);

    }
}
