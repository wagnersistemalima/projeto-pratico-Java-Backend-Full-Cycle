package com.fullcycle.admin.catalogo.domain;

// aggregate possue repositorio, possue acesso a uma persistencia, e podem perssistir uma ou mais entidades

// Classe abstrata que vai ditar o comportamento das Entidades

public abstract class AggregateRoot<ID extends Identifier> extends Entity<ID> {


    protected AggregateRoot(final ID id) {
        super(id);
    }


}
