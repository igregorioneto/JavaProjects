package com.backend.phonebook.services;

import com.backend.phonebook.models.Contato;
import com.backend.phonebook.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> listarContatos() {
        return (List<Contato>) contatoRepository.findAll();
    }

    public Optional<Contato> buscarContatoPorId(Long id) {
        return contatoRepository.findById(id);
    }

    public Contato salvarContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    public void excluirContato(Long id) {
        contatoRepository.deleteById(id);
    }
}
