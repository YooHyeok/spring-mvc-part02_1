package hello.thymeleaf.basic;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
public class BasicController {

    /**
     * 타임리프 기본 문법
     * templates/baisc/text-basic.html
     */
    @GetMapping("text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello Spring!");
        return "basic/text-basic";
    }

    /**
     * 타임리프 escape 제어
     * 텍스트 문자열 안에 Html 엘리먼트 태그를 추가한다.
     * templates/baisc/text-unescaped.html
     */
    @GetMapping("text-unescaped")
    public String textUnescaped(Model model) {
        model.addAttribute("data", "Hello <b>Spring!</b>");
        return "basic/text-unescaped";
    }

    /**
     * 타임리프 Spring El 표현식 - Object, List, Map
     * templates/baisc/variable.html
     */
    @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);
        List<Object> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);
        Map<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);
        return "basic/variable";
    }

    /**
     * 타임리프 기본 객체
     * templates/baisc/basic-objects.html
     */
    @GetMapping("/basic-objects")
    public String basicObjects(HttpSession session) {
        session.setAttribute("sessionData", "Hello Session");
        return "basic/basic-objects";
    }
    // --------------타임리프 기본객체 컴포넌트--------------------------
    @Component("helloBean")
    static class HelloBean {
        public String hello(String data) {
            return "Hello " + data;
        }
    }
    // --------------타임리프 기본객체 오브젝트--------------------------
    @Data
    static class User {
        private String username;
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

    /**
     * 타임리프 유틸리티 객체 및 날짜
     * templates/baisc/date.html
     */
    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "basic/date";
    }

    /**
     * 타임리프 URL Link
     * templates/baisc/link.html
     */
    @GetMapping("link")
    public String link(Model model) {
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        return "/basic/link";
    }

    /**
     * 타임리프 리터럴 및 연산
     * templates/baisc/literal.html
     */
    @GetMapping("literal")
    public String literal(Model model) {
        model.addAttribute("data", "Spring!");
        return "basic/literal";
    }

    /**
     * 타임리프 순수 연산
     * templates/basic/operation.html
     */
    @GetMapping("operation")
    public String operation(Model model) {
        model.addAttribute("nullData", null);
        model.addAttribute("data", "Spring!");
        return "basic/operation";
    }

    /**
     * 타임리프 속성 값 설정 (치환)
     * templates/basic/attribute.html
     */
    @GetMapping("/attribute")
    public String attribute() {
        return "basic/attribute";
    }

}
