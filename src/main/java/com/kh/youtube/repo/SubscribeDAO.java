package com.kh.youtube.repo;

import com.kh.youtube.domain.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubscribeDAO extends JpaRepository<Subscribe, Integer>
{
    //SELECT * FROM CHANNEL WHERE ID=?
    @Query(value = "SELECT * FROM CHANNEL WHERE ID=:id", nativeQuery = true)
    List<Subscribe> findByMemberId(String id);

}
