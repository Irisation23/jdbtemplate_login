package com.nhnacademy.edu.jdbc1.controller;

import com.nhnacademy.edu.jdbc1.domain.User;
import com.nhnacademy.edu.jdbc1.repository.JdbcUserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    private final JdbcUserRepository jdbcUserRepository;

    public LoginController(JdbcUserRepository jdbcUserRepository) {
        this.jdbcUserRepository = jdbcUserRepository;
    }

    @GetMapping("/login")
    public String login(@CookieValue(value = "SESSION", required = false) String session,
                        Model model) {
        if (StringUtils.hasText(session)) {
            model.addAttribute("id", session);
            return "loginSuccess";
        } else {
            return "loginForm";
        }
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("name") String name,
                          @RequestParam("pwd") String pwd,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          ModelMap modelMap) {
        List<User> userList = jdbcUserRepository.findByAll();
        for (User user : userList) {
            if (user.getName().equals(name) && user.getPassword().equals(pwd)) {
                HttpSession session = request.getSession(true);

                Cookie cookie = new Cookie("SESSION", session.getId());
                response.addCookie(cookie);

                modelMap.put("id", session.getId());
                modelMap.put("username", user.getName());
                return "loginSuccess";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/")
    public String loginForm() {
        return "loginForm";
    }
}
