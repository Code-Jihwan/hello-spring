package hello.hello_spring.domain;

import jakarta.persistence.*;

@Entity
public class Member {

    // 데이터 구분하기 위해서 시스템에 저장하는 id값
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
