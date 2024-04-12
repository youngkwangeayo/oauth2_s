package com.mydata.authlogin.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mydata.authlogin.entity.Member;



@Mapper
public interface MemberMapper {

    @Results(id = "member",value = {
        @Result(property = "idx",column = "member_id"),
        @Result(property = "email",column = "user_email"),
        @Result(property = "passward",column = "user_passward"),
        @Result(property = "name",column = "user_name"),
        @Result(property = "authSocial",column = "auth_social")
    })
    @Select("SELECT * FROM `member` WHERE user_email = #{userEmail};")
    Member findMemberByEmail(String userEmail);


    @ResultMap("member")
    @Insert("INSERT INTO member (user_email,user_name,user_passward,auth_social) VALUES (#{email},#{name},#{passward},#{authSocial});")
    int memberJoin(Member member);

    // @ResultMap("member")
    @Insert("INSERT INTO member (user_email) VALUES (#{member});")
    int memberJoin2(String member);
 
    @Select("SELECT user_email FROM `member` WHERE user_email = #{userEmail};")
    String mapping(String userEmail);
}