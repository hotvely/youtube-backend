package com.kh.youtube.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class CommentLike
{
    @Id
    @Column(name = "comm_like_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "commonLikeSequence")
    @SequenceGenerator(name = "commonLikeSequence", sequenceName = "SEQ_COMMENT_LIKE", allocationSize = 1)
    private int commLikeCode;

    @Column(name = "comm_like_date")
    private Date commLikeDate;


    @ManyToOne
    @JoinColumn(name = "comment_code")
    private VideoComment comment;

    @ManyToOne
    @JoinColumn(name = "id")
    private Member member;
}
