package dev.alexandre.adopet.api.service;

import dev.alexandre.adopet.api.dto.AtualizacaoTutorDto;
import dev.alexandre.adopet.api.dto.CadastroTutorDto;
import dev.alexandre.adopet.api.excpetion.ValidacaoException;
import dev.alexandre.adopet.api.model.Tutor;
import dev.alexandre.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public void cadastrar(CadastroTutorDto dto) {
        boolean jaCadastrado = repository.existsByTelefoneOrEmail(dto.telefone(), dto.email());

        if (jaCadastrado) {
            throw new ValidacaoException("Dados já cadastrados para outro tutor!");
        }

        repository.save(new Tutor(dto));
    }

    public void atualizar(AtualizacaoTutorDto dto) {
        Tutor tutor = repository.getReferenceById(dto.id());
        tutor.atualizarDados(dto);
    }

}
