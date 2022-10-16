package com.example.prueba_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {


    @GetMapping("/")
    public String index() {
        return "params/vista_index";
    }

    @GetMapping("/string")
    //public String param(@RequestParam(name="texto")String texto, Model model){
    public String param(@RequestParam(name = "texto", required = false, defaultValue = "cualquier valor") String texto, Model model) {
        model.addAttribute("resultado", "El texto enviado es" + texto);
        return "params/vista";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
        model.addAttribute("resultado", "El saludo enviado es:  '" + saludo + " 'y el numero '" + numero + "'");
        return "params/vista";
    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");

        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            numero = 0;
        }
        model.addAttribute("resultado", "El saludo enviado es:  '" + saludo + "' y el numero es '" + numero + "'");
        return "params/vista";
    }
}
