package com.fullcycle.admin.catalogo.domain.category;

// novo tipo no java, dto imutavel para passar dados de um lado para o outro, nao tem comportamento
// perPage = quantos itens por pagina
// parge = qual a pagina
// terms = filtrar por algum termo especifico
// sort = por qual atributo a lista retornarar ordenada
// direction = direção da ordenação ASC ou DESC

public record CategorySearchQuery(
        int page,
        int perPage,
        String terms,
        String sort,
        String direction

) {
}
