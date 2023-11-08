package com.backend.phonebook.controllers;

import com.backend.phonebook.models.Contato;
import com.backend.phonebook.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("contato", new Contato());
        return "cadastro-contato";
    }

    @GetMapping
    public List<Contato> listarContatos() {
        return contatoService.listarContatos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscarContatoPorId(@PathVariable Long id) {
        Optional<Contato> contato = contatoService.buscarContatoPorId(id);
        if (contato.isPresent()) {
            return ResponseEntity.ok(contato.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Contato salvarContato(@RequestBody Contato contato) {
        return contatoService.salvarContato(contato);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirContato(@PathVariable Long id) {
        contatoService.excluirContato(id);
    }

}
