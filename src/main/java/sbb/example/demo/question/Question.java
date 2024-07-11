package sbb.example.demo.question;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sbb.example.demo.answer.Answer;
import sbb.example.demo.user.SiteUser;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //열의 최대 길이 설정
    @Column(length = 200)
    private String subject;

    //텍스트를 열 데이터로 넣을때 사용
    @Column(columnDefinition = "TEXT")
    private String content;
    //꼭 Colummn 애노테이션을 사용하지 않더라도 열로 인식한다.
    private LocalDateTime createDate;

    // 답변과 1:N 관계이니 붙여준다. 답변이 다수이니 List 형태로 구성한다.
    // mappedBy 속성에 참조 엔티티로 question을 정의하고 CascadeType.REMOVE는 질문이 삭제되면 답변들도 다같이 사라지는 속성이다.
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;
}
