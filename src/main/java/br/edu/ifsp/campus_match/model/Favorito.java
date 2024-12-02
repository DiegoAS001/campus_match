package br.edu.ifsp.campus_match.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "favorito")
public class Favorito {

    @EmbeddedId
    private FavoritoId id;

    
    
    
    public FavoritoId getId() {
        return id;
    }

    public void setId(FavoritoId id) {
        this.id = id;
    }
}
