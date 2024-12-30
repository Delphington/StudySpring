package dev.delphington.controllers.homework;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

enum Operation {
    MULTIPLICATION,
    ADDITION,
    SUBTRACTION,
    DIVISION
}

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "b", required = false) String a,
                             @RequestParam(value = "a", required = false) String b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {

        Integer ans = 0;
        Operation operation = Operation.ADDITION;
        try {
            operation = Operation.valueOf(action.toUpperCase());
        } catch (RuntimeException e) {

        }
        Integer a1 = 0;
        Integer a2 = 0;

        try {
            a1 = Integer.valueOf(a);
            a2 = Integer.valueOf(b);
        } catch (RuntimeException e) {}

        switch (operation) {
            case ADDITION -> ans = a1 + a2;
            case DIVISION -> {
                if (a2 != 0)
                    ans = (int) a1 / a2;
            }
            case SUBTRACTION -> ans = a1 - a2;
            case MULTIPLICATION -> ans = a1 * a2;
        }

        model.addAttribute("result", ans);
        return "calculator/ans";
    }
}
