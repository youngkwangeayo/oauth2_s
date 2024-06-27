
package com.mydata.authlogin.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.mydata.authlogin.entity.Member;

import lombok.Data;


@Data
public class AuthUser implements UserDetails,OAuth2User {


    private Member member;
    private Map<String,Object> attributes;


    public AuthUser(Member member){
        this.member = member;
        System.out.println("1개매개"+member);
    }

    public AuthUser(Member member, Map<String,Object> attributes){
        this.member = member;
        this.attributes = attributes;
        System.out.println("2개매개"+member);
        System.out.println(attributes);
        // //여기서 맴버 구성 어트리뷰드스로
        // if(member ==null){

            
        // }

        
    }

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {
                // TODO Auto-generated method stub
                return member.getRole();
                // throw new UnsupportedOperationException("Unimplemented method 'getAuthority'");
            }
            
        });
   
        return collect;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
        return member.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAccountNonExpired'");
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAccountNonLocked'");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCredentialsNonExpired'");
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
        
    }

    @Override
    public Map<String, Object> getAttributes() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAttributes'");
        return attributes;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getName'");
        return member.getName();
    }


    
}