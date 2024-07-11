package sbb.example.demo.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//스프링 부트가 엔티티로 인식하게 함
@Entity
public class SiteUser {
    //id 속성을 기본키로 지정해서 각 데이터들을 구분짓는 값으로 사용
    @Id
    //이 데이터를 저장할 때 자동으로 1씩 증가해서 저장
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //데이터베이스 테이블의 열
    @Column(unique = true)
    private String username;

    private  String password;

    @Column(unique = true)
    private String email;
}
