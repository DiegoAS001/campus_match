package br.edu.ifsp.campus_match.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavoritoId implements Serializable {
    private Long idEstudante;
    private Long idInstituicao;

    public FavoritoId() {}

    public FavoritoId(Long idEstudante, Long idInstituicao) {
        this.idEstudante = idEstudante;
        this.idInstituicao = idInstituicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavoritoId)) return false;
        FavoritoId that = (FavoritoId) o;
        return Objects.equals(idEstudante, that.idEstudante) &&
               Objects.equals(idInstituicao, that.idInstituicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstudante, idInstituicao);
    }
}
