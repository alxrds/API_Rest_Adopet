package dev.alexandre.adopet.api.service;

import dev.alexandre.adopet.api.dto.CadastroPetDto;
import dev.alexandre.adopet.api.dto.PetDto;
import dev.alexandre.adopet.api.model.Abrigo;
import dev.alexandre.adopet.api.model.Pet;
import dev.alexandre.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<PetDto> buscarPetsDisponiveis() {
        return repository
                .findAllByAdotadoFalse()
                .stream()
                .map(PetDto::new)
                .toList();
    }

    public void cadastrarPet(Abrigo abrigo, CadastroPetDto dto) {
        repository.save(new Pet(dto, abrigo));
    }
}
