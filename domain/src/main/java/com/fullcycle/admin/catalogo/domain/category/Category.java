package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.AggregateRoot;
import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;

import java.time.Instant;

//  ------------------------------------------  Aggregates  ----------------------------------------
// seguir as praticas de modelagem DDD

public class Category extends AggregateRoot<CategoryId> implements Cloneable {

    private String name;
    private String description;
    private boolean active;
    private Instant createdAt;
    private Instant updateAt;
    private Instant deletedAt;


    private Category(final CategoryId aId, final String aName, final String aDescription, final boolean isActive, final Instant aCreatedAt, final Instant aUpdateAt, final Instant aDeletedAt) {
        super(aId);
        this.name = aName;
        this.description = aDescription;
        this.active = isActive;
        this.createdAt = aCreatedAt;
        this.updateAt = aUpdateAt;
        this.deletedAt = aDeletedAt;
    }

    public static Category newCategory(final String aName, final String aDescription, final boolean isActive) {
        final var id = CategoryId.unique();
        final var now = Instant.now();
        final var deletedAt = isActive ? null: now;
        return new Category(id, aName, aDescription, isActive, now, now, deletedAt);
    }

    @Override
    public void validate(final ValidationHandler handler) {
        new CategoryValidator(this, handler).validate();
    }

    // desativando uma categoria

    public Category activate() {
        this.deletedAt = null;
        this.active = true;
        this.updateAt = Instant.now();
        return this;
    }

    // ativando uma categoria

    public Category deactivate() {
        // validação
        if (getDeletedAt() == null) {
            this.deletedAt = Instant.now();
        }

        this.active = false;
        this.updateAt = Instant.now();
        return this;
    }

    // Atualizando uma categoria
    public Category update(String aName, String aDescription, boolean isActive) {

        // validação
        if (isActive) {
            activate();
        } else {
            deactivate();
        }
        this.name = aName;
        this.description = aDescription;
        this.updateAt = Instant.now();
        return this;
    }


    public CategoryId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }


}
