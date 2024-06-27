package com.mydata.authlogin.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //롬복의 데이터 게터,세터,투스트링 생성
@AllArgsConstructor //전체 맴버변수 생성자 생성
@NoArgsConstructor //기본아무것도없는 생성자 생성
@Builder //빌더 추가적으로 맴버변수가 생길때 빌더생성시 노오류
public class Member {
    private int idx;
    private String email;
    private String passward;
    private String name;
    private String role;
    private int employee_number;
    private String authSocial;

}
