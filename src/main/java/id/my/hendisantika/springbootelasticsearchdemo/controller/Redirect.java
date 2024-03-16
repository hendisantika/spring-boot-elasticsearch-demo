package id.my.hendisantika.springbootelasticsearchdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elasticsearch-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/16/24
 * Time: 09:15
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class Redirect {

    @GetMapping(value = "/")
    public ModelAndView redirectToDocPage() {
        return new ModelAndView("redirect:/swagger-ui/index.html");
    }

    @GetMapping(value = "/apidocs")
    public ModelAndView redirectToApiPage() {
        return new ModelAndView("redirect:/swagger-ui/index.html");
    }
}
