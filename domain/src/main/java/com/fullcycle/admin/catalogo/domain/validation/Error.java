package com.fullcycle.admin.catalogo.domain.validation;

// Um Record, nada mais é que um tipo de classe que armazena dados.
// É a mesma ideia de construção similar a um JavaBean, possui construtor, atributos e métodos acessores.
// Porém, ao invés de possibilitar qualquer alteração a classe é imutável. Também possui os métodos equals,
// hashCode e toString().

public record Error(String message) {
}
