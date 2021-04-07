package ru.alex.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message", "Hello " + name + " " + surname);
//        System.out.println("Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int varA,
                            @RequestParam(value = "b", required = false) int varB,
                            @RequestParam(value = "action", required = false) String action,
                            Model modelCalc) {
        double result = 0;
        String message = "";
        switch (action){
            case "multiplication":
                result = varA * varB;
                message = "Multiplication successful: " + result;
                break;
            case "addition":
                result = varA + varB;
                message = "Addition successful: " + result;
                break;
            case "subtraction":
                result = varA - varB;
                message = "Subtraction successful: " + result;
                break;
            case "division":
                if ( varA == 0 ) {
                    message = "Zero division - ERROR!";
                } else {
                    result = varA / (double) varB;
                    message = "Division successful: " + result;
                }
                break;
            default:
                message = "Invalid operation! ";
            }

        modelCalc.addAttribute("message", message);
        return "first/calculator";
        }
}

/*

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello " + name + " " + surname);
        return "first/hello";
    }
 */