package sbb.example.demo.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//질문 등록 페이지에서 사용자로부터 입력받은 값을 검증하고 받아오기 위한 클래스
@Getter
@Setter
public class QuestionForm {
    //값 검증하기
    @NotEmpty(message = "제목은 필수 항목입니다.")
    @Size(max=200)
    private String subject;
    @NotEmpty(message = "내용은 필수 항목입니다.")
    private String content;
}
