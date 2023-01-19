package com.fullcycle.admin.catalogo.domain;

// -------------------- ValueObject ---------------------------------
// apenas atributos que descreve esse objeto, ele sao imutaveis
// Classe abstrata que vai ditar o comportamento das Entidades
public abstract class Identifier extends ValueObject{

    public abstract String getValue();
}
