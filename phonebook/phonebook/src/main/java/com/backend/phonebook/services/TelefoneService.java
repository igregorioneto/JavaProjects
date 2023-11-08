package com.backend.phonebook.services;

import com.backend.phonebook.models.Telefone;
import com.backend.phonebook.repositories.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneService {
    @Autowired
    private TelefoneRepository telefoneRepository;

    public List<Telefone> listarTelefones() {
        return telefoneRepository.findAll();
    }

    public Optional<Telefone> buscarTelefonePorId(Long id) {
        return telefoneRepository.findById(id);
    }

    public Telefone salvarTelefone(Telefone telefone) {
        return telefoneRepository.save(telefone);
    }

    public void excluirTelefone(Long id) {
        telefoneRepository.deleteById(id);
    }
}
