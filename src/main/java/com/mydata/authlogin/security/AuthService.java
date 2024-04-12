package com.mydata.authlogin.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.mydata.authlogin.entity.Member;
import com.mydata.authlogin.mapper.MemberMapper;




@Service
// public class AuthService extends DefaultOAuth2UserService  {
public class AuthService extends DefaultOAuth2UserService implements UserDetailsService {
    
    @Autowired
    MemberMapper memberMapper;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // UserDetails 자체 로그인
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       System.out.println("디테일즈"+username);
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }

    // OAUTH 로그인
    @SuppressWarnings("unchecked")
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
      
        String social = (String)userRequest.getClientRegistration().getRegistrationId();
        String email ="";
        Member member = new Member();
        
        Map<String,Object> atteributes = new HashMap<>();

        if(social.contains("google")){
            email = (String)super.loadUser(userRequest).getAttributes().get("email");
            social = "google";
            atteributes =super.loadUser(userRequest).getAttributes();

        }else if(social.contains("naver")){
            atteributes = (Map<String, Object>) super.loadUser(userRequest).getAttributes().get("response");
            email = (String)atteributes.get("email");
            social = "naver";

        }else if(social.contains("kakao")){
            System.out.println("카카오");
            
        }

        member = memberMapper.findMemberByEmail(email);

        if(member == null){
            member = collectMember(social,atteributes);
            int status = memberMapper.memberJoin(member);
            // int status = memberMapper.memberJoin2("member");
            
        }


        //authUser 리턴
        return new AuthUser(member,super.loadUser(userRequest).getAttributes());
    }
    

    
    private Member collectMember(String social, Map<String,Object>atteributes){
        Member member = null;
        if(social.contains("google")){
            String passward = encoder.encode((String)atteributes.get("sub"));
            member = Member.builder()
                .email((String)atteributes.get("email")).name((String)atteributes.get("name"))
                .passward(passward).authSocial((String)social).build();
            

        }else if(social.contains("naver")){
            String passward = encoder.encode((String)atteributes.get("id"));
            member = Member.builder()
            .email((String)atteributes.get("email")).name((String)atteributes.get("name"))
            .passward(passward).authSocial((String)social).build();
          
        }else if(social.contains("kakao")){
            // System.out.println("카카오");
        }
        System.out.println(member.toString());
        return member;
    }
}
