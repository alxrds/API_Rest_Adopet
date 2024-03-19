package dev.alexandre.adopet.api.validacoes;

import dev.alexandre.adopet.api.dto.SolicitacaoAdocaoDto;
import dev.alexandre.adopet.api.excpetion.ValidacaoException;
import dev.alexandre.adopet.api.model.Adocao;
import dev.alexandre.adopet.api.model.StatusAdocao;
import dev.alexandre.adopet.api.model.Tutor;
import dev.alexandre.adopet.api.repository.AdocaoRepository;
import dev.alexandre.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidacaoTutorComLimiteDeAdocoes implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private TutorRepository tutorRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        List<Adocao> adocoes = adocaoRepository.findAll();
        Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());
        for (Adocao a : adocoes) {
            int contador = 0;
            if (a.getTutor() == tutor && a.getStatus() == StatusAdocao.APROVADO) {
                contador = contador + 1;
            }
            if (contador == 5) {
                throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
            }
        }
    }

}
