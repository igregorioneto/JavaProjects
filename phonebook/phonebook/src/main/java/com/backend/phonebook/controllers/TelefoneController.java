package com.backend.phonebook.controllers;

import com.backend.phonebook.models.Telefone;
import com.backend.phonebook.services.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {
    @Autowired
    private TelefoneService telefoneService;

    @GetMapping
    public List<Telefone> listarTelefones() {
        return telefoneService.listarTelefones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Telefone> buscarTelefonePorId(@PathVariable Long id) {
        Optional<Telefone> telefone = telefoneService.buscarTelefonePorId(id);
        if (telefone.isPresent()) {
            return ResponseEntity.ok(telefone.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Telefone salvarTelefone(@RequestBody Telefone telefone) {
        return telefoneService.salvarTelefone(telefone);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirTelefone(@PathVariable Long id) {
        telefoneService.excluirTelefone(id);
    }
}
