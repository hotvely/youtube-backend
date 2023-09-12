package com.kh.youtube.controller;

import com.kh.youtube.domain.Channel;
import com.kh.youtube.domain.Member;
import com.kh.youtube.domain.Subscribe;
import com.kh.youtube.domain.Video;
import com.kh.youtube.service.ChannelService;
import com.kh.youtube.service.SubscribeService;
import com.kh.youtube.service.VideoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/*")
@RestController
public class ChannelController
{
    @Autowired
    private VideoService videoService;
    @Autowired
    private ChannelService channelService;
    @Autowired
    private SubscribeService subscribeService;

    //채널조회 : http://localhost:8080/api/channel/1 (get)
    @GetMapping("/channel/{code}")
    public ResponseEntity<Channel> showChannel(@PathVariable int code)
    {
        return ResponseEntity.status(HttpStatus.OK).body(channelService.show(code));
    }

    //채널에 있는 영상조회 : http://localhost:8080/api/channel/1/video (get)
    @GetMapping("/channel/{code}/video")
    public ResponseEntity<List<Video>> showVideosInChannel(@PathVariable int code)
    {
        //SELECT * FROM video WHERE channel_code=?
        return ResponseEntity.status(HttpStatus.OK).body(videoService.findByChannel(code));

//        Channel channel = channelService.show(code);
//        List<Video> channelVideo = new ArrayList<>();
//        List<Video> videos = videoService.showAll();
//        for (Video v : videos)
//        {
//            if (v.getChannel().getChannelCode() == channel.getChannelCode())
//            {
//                channelVideo.add(v);
//            }
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body(channelVideo);

    }

    //채널추가 : http://localhost:8080/api/channel (post)
    @PostMapping("/channel")
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel)
    {
        return ResponseEntity.status(HttpStatus.OK).body(channelService.create(channel));
    }

    //채널수정 : http://localhost:8080/api/channel (put)
    @PutMapping("/channel")
    public ResponseEntity<Channel> updateChannel(@RequestBody Channel channel)
    {
        Channel result = channelService.update(channel);
        if (result != null)
            return ResponseEntity.status(HttpStatus.OK).body(result);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //채널삭제 : http://localhost:8080/api/channel/1 (delete)
    @DeleteMapping("/channel/{code}")
    public ResponseEntity<Channel> deleteChannel(@PathVariable int code)
    {
        return ResponseEntity.status(HttpStatus.OK).body(channelService.delete(code));
    }


    //내가 구독한 채널 조회 : http://localhost:8080/api/subscribe/user1 (get)
    @GetMapping("/subscribe/{id}")
    public ResponseEntity<List<Subscribe>> showSubs(@PathVariable String userId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(subscribeService.findByMemberId(userId));
    }

    //채널구독 : http://localhost:8080/api/subscribe (post)
    @PostMapping("/subscribe")
    public ResponseEntity<Subscribe> createSubs(@RequestBody Subscribe subscribe)
    {
        return ResponseEntity.status(HttpStatus.OK).body(subscribeService.create(subscribe));
    }


    //채널구독취소 : http://localhost:8080/api/subscribe/1 (delete)
    @DeleteMapping("/subscribe/{code}")
    public ResponseEntity<Subscribe> deleteSubs(@PathVariable int code)
    {
        return ResponseEntity.status(HttpStatus.OK).body(subscribeService.delete(code));
    }

}
