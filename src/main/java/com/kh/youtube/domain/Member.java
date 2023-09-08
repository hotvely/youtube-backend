package com.kh.youtube.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert          //<- Default 사용하려고 하면 DynamicInsert 키워드 필요함
public class Member
{
    @Id
    private String id;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String authority;

//
//    private String memberId;
//    private String memberPassword;
//    private String memberNickname;
//    private String memberEmail;
//    private String memberPhone;
//    private char memberGender;
//    private String memberAuthority;


}
