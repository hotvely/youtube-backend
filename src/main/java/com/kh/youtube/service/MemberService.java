package com.kh.youtube.service;

import com.kh.youtube.domain.Member;
import com.kh.youtube.repo.MemberDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j          //<- lombok 에서 제공해 주는 로그 찍을 수 있는 키워드,
public class MemberService
{
    @Autowired
    private MemberDAO dao;


    public List<Member> showAll()
    {
        return dao.findAll();       //select * from member
    }

    public Member show(String id)
    {
        return dao.findById(id).orElse(null);
        // SELECT * FROM MEMBER WHERE ID=?
    }

    public Member create(Member member)
    {
        log.info("member : " + member);

        return dao.save(member);
        // INSERT INTO MEMBER(ID, PASSWORD, NAME, AUTHORITY)
        // VALUES(?, ?, ?, 'ROLE_USER')
    }

    public Member update(Member member)
    {
        log.info("member : " + member);
        Member target = dao.findById(member.getId()).orElse(null);
        if (target != null)
            return dao.save(member);

        return null;


        // INSERT INTO MEMBER(ID, PASSWORD, NAME, AUTHORITY)
        // VALUES(?, ?, ?, 'ROLE_USER')\
    }

    // DELETE FROM MEMBER WHERE ID=?
    public Member delete(String id)
    {
        Member target = dao.findById(id).orElse(null);
        if (target != null)
            dao.delete(target);

        return target;
    }


}
