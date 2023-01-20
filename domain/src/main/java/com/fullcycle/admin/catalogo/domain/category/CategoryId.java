package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

// Entidade / TDD a entidade possui um Id, e é identificada por ele

public class CategoryId extends Identifier {

    // atributos

    private final String value;

    private CategoryId(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    // Factory methods statico para gerar um id

    public static CategoryId unique() {

        return CategoryId.from(UUID.randomUUID());
    }

    public static CategoryId from(final String anId) {
        return new CategoryId(anId);
    }

    // Factory methods statico para gerar um id
    public static CategoryId from(final UUID anId) {
        return new CategoryId(anId.toString().toLowerCase());
    }

    // getters

    public String getValue() {
        return value;
    }

    // equals & hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryId that = (CategoryId) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
