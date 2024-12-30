package legacy.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/first")
@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        //System.out.println(name + " " + age);

        model.addAttribute("message", "name: " + name  + " age: " + age);

        return "first/hello";
    }


    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "age", required = false ) String age) {
        System.out.println(name + " " + age);

        return "first/goodbye";
    }

}
