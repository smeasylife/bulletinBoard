package sbb.example.demo.question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//QuestionRepository를 리포지토리로 만들기 위해 JpaRepository를 상속한다. 이는 JPA가 제공하는 인터페이스 중 하나이고,
//CRUD 작업을 처리하는 메서드를 내장하고 있어 데이터베이스 테이블에 작업을 할때 편리하게 처리할 수 있다.
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    // findBy + 속성명 : JPA에 메서드명을 분석해서 쿼리를 만들고 실행하는 기능. 속성명의 데이터를 조회하고 리턴
    Question findBySubject(String subject);
    // 메서드 명의 조합으로 여러 쿼리문을 만들 수 있다 ex) And, Or, Between, LessThan, Like, In, Like
    Question findBySubjectAndContent(String subject, String content);
    List<Question> fineBySubjectLike(String subject);
    Page<Question> findAll(Pageable pageable);
}
