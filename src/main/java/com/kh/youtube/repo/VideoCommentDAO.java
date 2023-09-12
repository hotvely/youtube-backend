package com.kh.youtube.repo;

import com.kh.youtube.domain.VideoComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoCommentDAO extends JpaRepository<VideoComment, Integer>
{
    @Query(value = "SELECT * FROM video_Comment WHERE video_code = :code", nativeQuery = true)
    List<VideoComment> findByVideCode(int code);

}
