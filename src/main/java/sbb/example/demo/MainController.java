package sbb.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/sbb")
    @ResponseBody
    public String index(){
        return "안녕하세요 sbb에 오신것을 환영합니다.";
    }

    //Root URL을 질문 목록 페이지로 등록.
    @GetMapping("/")
    public String root(){
        return "redirect:/question/list";
    }
}
