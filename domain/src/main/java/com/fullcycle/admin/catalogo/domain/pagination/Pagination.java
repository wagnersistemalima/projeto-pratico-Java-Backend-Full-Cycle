package com.fullcycle.admin.catalogo.domain.pagination;


import java.util.List;

// novo tipo no java, dto imutavel para passar dados de um lado para o outro, não tem comportamento
// perPage = quantos itens por pagina

public record Pagination<T>(
        int currentPage,
        int perPage,
        long total,
        List<T> items
) {

}
