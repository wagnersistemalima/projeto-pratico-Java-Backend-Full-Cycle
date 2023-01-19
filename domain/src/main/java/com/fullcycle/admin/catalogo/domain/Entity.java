package com.fullcycle.admin.catalogo.domain;

import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;

import java.util.Objects;

// TDD a entidade possui um Id, e é identificada por ele
// Classe abstrata que vai ditar o comportamento das Entidades
public abstract class Entity<ID extends Identifier> {

    // Atributos

    protected final ID id;

    // Construtor
    protected Entity(final ID id) {
        Objects.requireNonNull(id, " 'id' should not be null");
        this.id = id;
    }

    // Getters
    public ID getId() {
        return id;
    }

    // Equals e hascode

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Entity<?> entity = (Entity<?>) o;
        return getId().equals(entity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // metods

    public abstract void validate(ValidationHandler handler);
}
