package sbb.example.demo.question;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// 그냥 Controller로 다 하면 될 것 같은데 Service가 필요한 이유
// 코드 모듈화 -> 여러 컨트롤러들에게 필요한 메서드들을 만들어놓음
// 가장 중요한 엔티티 객체 DTO(Data Transfer Object) 객체로 변환하기! -> 엔티티 클래스는 데이터베이스와 직접 연결되는 클래스라 타임리프에
// 전달해서 사용하는건 위험하다. 민감한 데이터가 노출될 수 있음. 그래서 DTO 객체로 변환해서 전달함.
@Service
@RequiredArgsConstructor
public class QuestionService {

    //리포지토리 의존관계 주입
    private final QuestionRepository questionRepository;

    public Page<Question> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page,10, Sort.by(sorts));
        return questionRepository.findAll(pageable);
    }

    public List<Question> getList(){
        return questionRepository.findAll();
    }

    //Optional 활용해서 null-safe하게 코딩
    // 리포지토리에서 질문 조회하기
    public Question getQuestion(Integer id){
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()){
            return question.get();
        }else{
            // 나만의 예외 커스텀
            throw new DataNotFoundException("question not found");
        }
    }
    public void create(String subject, String content){
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        questionRepository.save(q);
    }
}
