package sbb.example.demo.answer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sbb.example.demo.question.Question;
import sbb.example.demo.user.SiteUser;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String content;

    private LocalDateTime createDate;

    @ManyToOne
    private Question question;

    @ManyToOne
    private SiteUser author;
}
