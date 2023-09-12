package com.kh.youtube.controller;

import com.kh.youtube.domain.CommentLike;
import com.kh.youtube.domain.Video;
import com.kh.youtube.domain.VideoComment;
import com.kh.youtube.domain.VideoLike;
import com.kh.youtube.service.CommentLikeService;
import com.kh.youtube.service.VideoCommentService;
import com.kh.youtube.service.VideoLikeService;
import com.kh.youtube.service.VideoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/*")
public class VideoController
{
    @Autowired
    VideoService videoService;
    @Autowired
    VideoCommentService videoCommentService;
    @Autowired
    VideoLikeService videoLikeService;
    @Autowired
    CommentLikeService commentLikeService;


    //영상 전체 조회 : http://localhost:8080/api/video (get)
    @GetMapping("/video")
    public ResponseEntity<List<Video>> showVideos()
    {
        return ResponseEntity.status(HttpStatus.OK).body(videoService.showAll());
    }

    //영상추가 : http://localhost:8080/api/video (post)
    @PostMapping("/video")
    public ResponseEntity<Video> createVideo(@RequestBody Video video)
    {
        return ResponseEntity.status(HttpStatus.OK).body(videoService.create(video));
    }

    //영상수정 : http://localhost:8080/api/video (put)
    @PutMapping("/video")
    public ResponseEntity<Video> updateVideo(@RequestBody Video video)
    {
        return ResponseEntity.status(HttpStatus.OK).body(videoService.update(video));
    }

    //영상삭제 : http://localhost:8080/api/video/1 (delete)
    @DeleteMapping("video/{code}")
    public ResponseEntity<Video> deleteVideo(@PathVariable int code)
    {
        return ResponseEntity.status(HttpStatus.OK).body(videoService.delete(code));
    }

    //영상1개조회 : http://localhost:8080/api/video/1 (get)
    @GetMapping("/video/{code}")
    public ResponseEntity<Video> showVideo(@PathVariable int code)
    {
        return ResponseEntity.status(HttpStatus.OK).body(videoService.show(code));
    }

    //영상1개에 따른 댓글 전체 조회 : http://localhost:8080/api/video/1/comment (get)
    @GetMapping("/video/{code}/comment")
    public ResponseEntity<List<VideoComment>> showVideoComments(@PathVariable int code)
    {
        return ResponseEntity.status(HttpStatus.OK).body(videoCommentService.findByVideoCode(code));
    }

    //좋아요추가 : http://localhost:8080/api/video/like (post)
    @PostMapping("/video/like")
    public ResponseEntity<VideoLike> createVideoLike(@RequestBody VideoLike like)
    {
        return ResponseEntity.status(HttpStatus.OK).body(videoLikeService.create(like));
    }

    //좋아요취소 : http://localhost:8080/api/video/list/1 (delete)
    @DeleteMapping("/video/like/{code}")
    public ResponseEntity<VideoLike> deleteVideoLike(@PathVariable int code)
    {
        return ResponseEntity.status(HttpStatus.OK).body(videoLikeService.delete(code));
    }

    //댓글추가 : http://localhost:8080/api/video/comment (post)
    @PostMapping("/video/comment")
    public ResponseEntity<VideoComment> createVideoComment(@RequestBody VideoComment videoComment)
    {
        return ResponseEntity.status(HttpStatus.OK).body(videoCommentService.create(videoComment));
    }

    //댓글수정 : http://localhost:8080/api/video/comment (put)
    @PutMapping("/video/comment")
    public ResponseEntity<VideoComment> updateVideoComment(@RequestBody VideoComment videoComment)
    {
        return ResponseEntity.status(HttpStatus.OK).body(videoCommentService.create(videoComment));
    }

    //댓글삭제 : http://localhost:8080/api/video/comment/1 (delete)
    @DeleteMapping("/video/comment/{code}")
    public ResponseEntity<VideoComment> deleteComment(@PathVariable int code)
    {
        return ResponseEntity.status(HttpStatus.OK).body(videoCommentService.delete(code));
    }

    //댓글좋아요추가 : http://localhost:8080/api/video/comment/like (post)
    @PostMapping("video/comment/like")
    public ResponseEntity<CommentLike> createCommentLike(@RequestBody CommentLike commentLike)
    {
        return ResponseEntity.status(HttpStatus.OK).body(commentLikeService.create(commentLike));
    }


    //댓글좋아요취소 : http://localhost:8080/api/video/comment/like/1 (delete)
    @DeleteMapping("video/comment/like/{code}")
    public ResponseEntity<CommentLike> deleteCommentLike(@PathVariable int code)
    {
        return ResponseEntity.status(HttpStatus.OK).body(commentLikeService.delete(code));
    }


}
