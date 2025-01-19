package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

public class HelloController {
    // 웹 애플리케이션에서 /hello 라고 들어오면 이 메소드 호출한다.
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    // 외부에서 파라미타를 받음
    // 옵션 넣을 떄 단축키 -> command + p
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);   // 키 - name
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    // http 응답 body 부분에 "hello " + name 이 데이터를 직접 넣어 주겠다는 뜻
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // 문자적은 것이 그대로 내려간다.
    }

    // json 방식으로 결과 나옴 -> 요즘은 다 JSON 반환으로 함
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        // command + shift + enter 해주면 자동 완성
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
