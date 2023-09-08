package com.kh.youtube.service;

import com.kh.youtube.domain.Category;
import com.kh.youtube.domain.Channel;
import com.kh.youtube.domain.Member;
import com.kh.youtube.repo.ChannelDAO;
import com.kh.youtube.repo.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService
{
    @Autowired
    private ChannelDAO channelDAO;

    @Autowired
    private MemberDAO memberDAO;

    public List<Channel> showAll()
    {
        return channelDAO.findAll();
    }

    public Channel show(int id)
    {
        Channel channel = channelDAO.findById(id).orElse(null);
        if (channel != null)
        {
            Member member = memberDAO.findById(channel.getMember().getId()).orElse(null);
            channel.setMember(member);
        }
        return channel;
    }

    public List<Channel> showAllByMember(String id)
    {
        Member member = memberDAO.findById(id).orElse(null);
        if (member != null)
            return channelDAO.findChannelByMemberId(member.getId());

        return null;
    }

    public Channel create(Channel channel)
    {
        Channel target = channelDAO.findById(channel.getChannelCode()).orElse(null);
        if (target == null)
            return channelDAO.save(channel);

        return null;
    }

    public Channel update(Channel channel)
    {
        Channel target = channelDAO.findById(channel.getChannelCode()).orElse(null);
        if (target != null)
            return channelDAO.save(channel);

        return null;
    }

    public Channel delete(int code)
    {
        Channel data = channelDAO.findById(code).orElse(null);
        if (data != null)
            channelDAO.delete(data);

        return data;
    }


}
