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
public class Subscribe
{
    @Id
    @Column(name = "subs_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "subsSequence")
    @SequenceGenerator(name = "subsSequence", sequenceName = "SEQ_SUBSCRIBE", allocationSize = 1)
    private int subsCode;

    @Column(name = "SUBS_DATE")
    private Date subsDate;

    @ManyToOne
    @JoinColumn(name = "id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_CODE")
    private Channel channel;

}
