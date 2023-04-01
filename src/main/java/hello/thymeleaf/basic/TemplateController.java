package hello.thymeleaf.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class TemplateController {

    /**
     * 타임리프 템플릿 조각
     * templates/template/fragment/fragmentMain.html
     * templates/template/fragment/footer.html
     */
    @GetMapping("fragment")
    public String template() {
        return "template/fragment/fragmentMain";
    }

    /**
     * 타임리프 템플릿 레이아웃1
     * templates/template/layout/layoutMain.html
     * templates/template/layout/base.html
     */
    @GetMapping("layout")
    public String layout() {
        return "template/layout/layoutMain";
    }

    /**
     * 타임리프 템플릿 레이아웃2
     * templates/template/layoutExtend/layoutExtendMain.html
     * templates/template/layoutExtend/layoutFile.html
     */
    @GetMapping("layoutExtend")
    public String layoutExtemd() {
        return "template/layoutExtend/layoutExtendMain";
    }

}
