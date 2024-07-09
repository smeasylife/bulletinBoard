package sbb.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sbb.example.demo.question.Question;
import sbb.example.demo.question.QuestionRepository;
import sbb.example.demo.question.QuestionService;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private QuestionService questionService;

	@Test
	void testJpa(){
		for(int i = 1; i <= 300; i++){
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용 없음";
			questionService.create(subject,content);
		}
	}

}
