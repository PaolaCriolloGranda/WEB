package com.example.prueba_web.controller;

import com.example.prueba_web.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api")
public class IndexController {
    // @RequestMapping(value="/index",method= RequestMethod.GET)

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.listar.titulo}")
    private String TextoLista;

    @GetMapping({"/index","/","/home"})
    public String index1(Model model){
        model.addAttribute("titulo",textoIndex);
    return "index";
    }



    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();

        usuario.setNombre("Paola");
        usuario.setApellido("Criollo");
        usuario.setEmail("paola@gmail.com");

        model.addAttribute("usuario", usuario);
        //model.addAttribute("titulo", "HOLA A TODOS");
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
       // List<Usuario> usuarios = new ArrayList<>();

        //model.addAttribute("titulo", "Listado de usuarios");
        // model.addAttribute("usuarios",usuarios);
        model.addAttribute("titulo",TextoLista);
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {

       List<Usuario> usuarios = Arrays.asList(new Usuario("Paola", "Criollo", "priscilapaolacg@gmail.com"),
                new Usuario("William", "Tocto", "williiiiii123@gmail.com"),
                new Usuario("Danny", "Tenemea", "danny123@gmail.com"),
                new Usuario("Jose", "Murillo", "laroca@gmail.com"),
                new Usuario("Marlon", "Velez", "estuco@gmail.com"));
        return usuarios;
    }

}
