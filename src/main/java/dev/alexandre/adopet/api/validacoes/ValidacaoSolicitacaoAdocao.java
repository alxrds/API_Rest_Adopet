package dev.alexandre.adopet.api.validacoes;

import dev.alexandre.adopet.api.dto.SolicitacaoAdocaoDto;

public interface ValidacaoSolicitacaoAdocao {

    void validar(SolicitacaoAdocaoDto dto);

}
