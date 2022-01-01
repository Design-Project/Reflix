package com.reflix.server.movie.repository;

import com.reflix.server.configure.entity.Status;
import com.reflix.server.movie.dto.PostRes;
import com.reflix.server.movie.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<PostRes> findAllByStatusOrderByUpdatedAtDesc(Status status);

    Optional<Post> findPostByPostIdAndStatus(Long postId, Status status);
}
