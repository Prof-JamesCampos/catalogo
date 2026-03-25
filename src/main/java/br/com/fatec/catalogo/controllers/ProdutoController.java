package br.com.fatec.catalogo.controllers;

import br.com.fatec.catalogo.models.ProdutoModel;
import br.com.fatec.catalogo.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("produtos", service.listarTodos());
        return "lista-produtos";
    }

    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("produto", new ProdutoModel());
        return "cadastro-produto";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("produto") ProdutoModel produto,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "cadastro-produto";
        }
        service.salvar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable long id, Model model) {
        model.addAttribute("produto", service.buscarPorId(id));
        return "cadastro-produto"; // Reutilizamos o mesmo form para editar
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable long id) {
        service.excluir(id);
        return "redirect:/produtos";
    }
}