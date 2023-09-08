package com.kh.youtube.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category
{
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "categorySequence")
//    설정한 categorySequence라는 이름의 sequenceGenerator를 찾아서 실행하겠다,, 라는 의미임

    @Id
    @Column(name = "category_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "categorySequence")
    @SequenceGenerator(name = "categorySequence", sequenceName = "SEQ_CATEGORY", allocationSize = 1)
    private int categoryCode;

    @Column(name = "category_name")
    private String categoryName;


}
