package sbb.example.demo.question;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sbb.example.demo.answer.AnswerForm;

//final이 붙은 속성을 포함해서 생성자를 만들어주는 롬복 애노테이션(여기서는 questionService)
@RequiredArgsConstructor
@RequestMapping("/question")
@Controller
public class QuestionController {

    //의존 관계 주입
    private final QuestionService questionService;

    //model은 타임리프와 자바 사이의 연결고리, 파라미터로 선언하면 자동으로 객체를 생성함.
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page){
        Page<Question> paging = questionService.getList(page);
        model.addAttribute("paging",paging);
        return "question_list";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm){
        Question question = questionService.getQuestion(id);
        model.addAttribute("question",question);
        return "question_detail";
    }
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm){
        return "question_form";
    }

    //매개변수를 subject, content 이렇게 하지않고 그냥 객체 이름으로 했다. 그러면 스프링이 자동으로 이름을 매칭해서 바인딩한다.
    //@Valid 가 검증 기능을 동작시킨다. BindingResult 객체는 검증을 하고 난 후 결과를 담는다.
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "question_form";
        }
        questionService.create(questionForm.getSubject(),questionForm.getContent());
        return "redirect:/question/list";
    }
}
