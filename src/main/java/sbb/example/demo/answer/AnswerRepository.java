package sbb.example.demo.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import sbb.example.demo.answer.Answer;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
}
