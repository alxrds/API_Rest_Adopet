package dev.alexandre.adopet.api.validacoes;

import dev.alexandre.adopet.api.dto.SolicitacaoAdocaoDto;
import dev.alexandre.adopet.api.excpetion.ValidacaoException;
import dev.alexandre.adopet.api.model.Pet;
import dev.alexandre.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPetDisponivel implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private PetRepository petRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        Pet pet = petRepository.getReferenceById(dto.idPet());
        if (pet.getAdotado()) {
            throw new ValidacaoException("Pet já foi adotado!");
        }
    }

}
