package com.fullcycle.admin.catalogo.domain.validation;

// Classe pai dos validadores

public abstract class Validator {

    private final ValidationHandler handler;

    protected Validator(final ValidationHandler aHandler) {
        this.handler = aHandler;

    }

    public abstract void validate();

    protected ValidationHandler validatorHandler() {
        return this.handler;
    }
}
