package br.com.fatec.catalogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private InMemoryUserDetailsManager userManager;

    @GetMapping("/novo")
    public String exibirCadastro() {
        return "cadastro-usuario";
    }

    @PostMapping("/novo")
    public String cadastrarUsuario(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String role) {

        // Criando a definição do novo usuário
        UserDetails novoUsuario = User.builder()
                .username(username)
                .password("{noop}" + password) // Mantendo o padrão noop
                .roles(role)
                .build();

        // Adicionando ao gerenciador de memória
        userManager.createUser(novoUsuario);

        return "redirect:/produtos";
    }
}