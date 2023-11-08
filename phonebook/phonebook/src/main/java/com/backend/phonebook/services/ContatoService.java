package com.backend.phonebook.services;

import com.backend.phonebook.models.Contato;
import com.backend.phonebook.models.Telefone;
import com.backend.phonebook.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
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
        Optional<Contato> contato = buscarContatoPorId(id);
        if (contato.isPresent()) {
            contatoRepository.deleteById(id);
            salvarDadosExcluidosEmArquivo(contato);
        }

    }

    private void salvarDadosExcluidosEmArquivo(Optional<Contato> contato) {
        try {
            String fileName = "contato_excluido_" + contato.get().getId() + ".txt";
            File file = new File(fileName);

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write("Nome: " + contato.get().getNome());
            writer.newLine();
            writer.write("Idade: " + contato.get().getIdade());
            writer.newLine();

            for (Telefone telefone : contato.get().getTelefones()) {
                writer.write("Telefone: " + telefone.getNumero());
                writer.newLine();
            }

            writer.newLine();
            writer.write("Data: " + new Date());

            writer.write("========================================");

            writer.close();
        } catch (IOException e) {
            // Lidar com erros de escrita no arquivo, se necessário
            e.printStackTrace();
        }
    }
}
