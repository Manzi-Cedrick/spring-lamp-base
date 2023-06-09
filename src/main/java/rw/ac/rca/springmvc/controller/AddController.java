package rw.ac.rca.springmvc.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rw.ac.rca.springmvc.service.CalculatorService;

/**
 * @author Manzi Cedrick
 *
 */
@Controller
public class AddController {
    @RequestMapping("/add.php")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
        int a = Integer.parseInt(request.getParameter("num1"));
        int b = Integer.parseInt(request.getParameter("num2"));
        CalculatorService calcService = new CalculatorService();
        double sum = calcService.addTwoNumbers(a, b);
        double prod = calcService.multiplyTwoNumbers(a, b);
        double sub = calcService.substractTwoNumbers(a,b );
        ModelAndView mv = new ModelAndView();
        mv.setViewName("results.jsp");
        mv.addObject("fv", a);
        mv.addObject("sv", b);
        mv.addObject("theSum", sum);
        mv.addObject("sub",sub);
        mv.addObject("product", prod);
        return mv;
    }
}