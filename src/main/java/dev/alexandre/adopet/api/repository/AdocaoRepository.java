package dev.alexandre.adopet.api.repository;

import dev.alexandre.adopet.api.model.Adocao;
import dev.alexandre.adopet.api.model.StatusAdocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

    boolean existsByPetIdAndStatus(Long idPet, StatusAdocao status);

}
