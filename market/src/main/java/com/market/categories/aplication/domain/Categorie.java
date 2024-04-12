package com.market.categories.aplication.domain;

import com.market.categories.aplication.domain.valueObj.CategorieDescription;
import com.market.categories.aplication.domain.valueObj.CategorieId;
import com.market.categories.aplication.domain.valueObj.CategorieName;

public class Categorie {
    private final CategorieId id;
    private final CategorieName name;
    private final CategorieDescription description;

    public Categorie(CategorieId id, CategorieName name, CategorieDescription description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public CategorieId getId() {
        return id;
    }

    public CategorieName getName() {
        return name;
    }

    public CategorieDescription getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                '}';
    }
}
