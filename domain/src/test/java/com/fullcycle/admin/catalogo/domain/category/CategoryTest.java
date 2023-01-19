package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.exceptions.DomainException;
import com.fullcycle.admin.catalogo.domain.validation.handler.ThrowsValidatorHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    public void dadoOsValidosParametros_QuandoInstanciarmosUmaNovaCategoria_DeveRetornarEssaNovaInstancia() {
        // Dado
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;
        // Quando

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedActive);
        // Então
        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedActive, actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdateAt());
        Assertions.assertNull(actualCategory.getDeletedAt());

    }

    @Test
    public void dadoOInvalidoParametroNullName_QuandoInstanciarmosUmaNovaCategoria_DeveRetornarError() {
        // Dado
        final String expectedName = null;
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;
        final var expectedErrorMessage = "'name' should not be null";
        final var expectedErrorCount = 1;
        // Quando

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedActive);
        // Então

        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(new ThrowsValidatorHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());

    }

    @Test
    public void dadoOInvalidoParametroEmptyName_QuandoInstanciarmosUmaNovaCategoria_DeveRetornarError() {
        // Dado
        final String expectedName = "  ";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;
        final var expectedErrorMessage = "'name' should not be empty";
        final var expectedErrorCount = 1;
        // Quando

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedActive);
        // Então

        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(new ThrowsValidatorHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());

    }

    @Test
    public void dadoOInvalidoParametroNameComMenosDeTreisCaracter_QuandoInstanciarmosUmaNovaCategoria_DeveRetornarError() {
        // Dado
        final String expectedName = "Fi  ";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;
        final var expectedErrorMessage = "'name' must be between 3 and 255 charater";
        final var expectedErrorCount = 1;
        // Quando

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedActive);
        // Então

        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(new ThrowsValidatorHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());

    }

    @Test
    public void dadoOInvalidoParametroNameComMaisDe255Caracter_QuandoInstanciarmosUmaNovaCategoria_DeveRetornarError() {
        // Dado
        final String expectedName = """
                No entanto, não podemos esquecer que a execução dos pontos do programa estimula a padronização das condições financeiras
                e administrativas exigidas. Acima de tudo, é fundamental ressaltar que a complexidade dos estudos efetuados cumpre um
                papel essencial na formulação das diretrizes de desenvolvimento para o futuro. Desta maneira, a mobilidade dos capitais
                internacionais exige a precisão e a definição dos paradigmas corporativos. Pensando mais a longo prazo, a contínua
                expansão de nossa atividade faz parte de um processo de gerenciamento dos relacionamentos verticais entre as hierarquias.
                """;
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;
        final var expectedErrorMessage = "'name' must be between 3 and 255 charater";
        final var expectedErrorCount = 1;
        // Quando

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedActive);
        // Então

        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(new ThrowsValidatorHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());

    }

    @Test
    public void dadoOParametroDescriptionEmpty_QuandoInstanciarmosUmaNovaCategoria_DeveRetornarEssaNovaInstancia() {
        // Dado
        final var expectedName = "Filmes";
        final var expectedDescription = " ";
        final var expectedActive = true;
        // Quando

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedActive);
        // Então
        Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidatorHandler()));
        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedActive, actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdateAt());
        Assertions.assertNull(actualCategory.getDeletedAt());

    }

    @Test
    public void dadoOParametroActiveFalse_QuandoInstanciarmosUmaNovaCategoria_DeveRetornarEssaNovaInstancia() {
        // Dado
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = false;
        // Quando

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedActive);
        // Então
        Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidatorHandler()));
        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedActive, actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdateAt());
        Assertions.assertNotNull(actualCategory.getDeletedAt());

    }

    @Test
    public void dadoOParametroActiveCategory_QuandoDesativarmosOparametroActive_DeveRetornarUmaCategoryInativa() {
        // Dado
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = false;
        // Quando

        final var aCategory = Category.newCategory(expectedName, expectedDescription, true);
        // Então

        final var createdAt = aCategory.getCreatedAt();
        final var updatedAt = aCategory.getUpdateAt();

        Assertions.assertDoesNotThrow(() -> aCategory.validate(new ThrowsValidatorHandler()));


        Assertions.assertNull(aCategory.getDeletedAt());
        Assertions.assertTrue(aCategory.isActive());

        final var actualCategory = aCategory.deactivate();

        Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidatorHandler()));
        Assertions.assertEquals(aCategory.getId(), actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedActive, actualCategory.isActive());
        Assertions.assertEquals(createdAt, actualCategory.getCreatedAt());
        //Assertions.assertTrue(actualCategory.getUpdateAt().isAfter(updatedAt));
        Assertions.assertNotNull(actualCategory.getDeletedAt());

    }

    @Test
    public void dadoOParametroActiveCategory_QuandoAtivarmosOparametroActive_DeveRetornarUmaCategoryAtiva() {
        // Dado
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;
        // Quando

        final var aCategory = Category.newCategory(expectedName, expectedDescription, false);
        // Então

        Assertions.assertDoesNotThrow(() -> aCategory.validate(new ThrowsValidatorHandler()));

        final var createdAt = aCategory.getCreatedAt();
        final var updatedAt = aCategory.getUpdateAt();

        Assertions.assertFalse(aCategory.isActive());
        Assertions.assertNotNull(aCategory.getDeletedAt());

        final var actualCategory = aCategory.activate();

        Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidatorHandler()));

        Assertions.assertEquals(aCategory.getId(), actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedActive, actualCategory.isActive());
        Assertions.assertEquals(createdAt, actualCategory.getCreatedAt());
        //Assertions.assertTrue(actualCategory.getUpdateAt().isAfter(updatedAt));
        Assertions.assertNull(actualCategory.getDeletedAt());


    }

    @Test
    public void dadoUmacategoriaValida_QuandoAtualizar_deveRetornarACategoriaUpdateAtAtualizada() {
        // Dado
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;

        // Quando
        final var aCategory = Category.newCategory("Film", "A categoria", expectedActive);

        // Então

        Assertions.assertDoesNotThrow(() -> aCategory.validate(new ThrowsValidatorHandler()));

        final var createdAt = aCategory.getCreatedAt();
        final var updatedAt = aCategory.getUpdateAt();

        final var actualCategory = aCategory.update(expectedName, expectedDescription, expectedActive);

        Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidatorHandler()));

        Assertions.assertEquals(aCategory.getId(), actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedActive, actualCategory.isActive());
        Assertions.assertEquals(createdAt, actualCategory.getCreatedAt());
        //Assertions.assertTrue(actualCategory.getUpdateAt().isAfter(updatedAt));
        Assertions.assertNull(actualCategory.getDeletedAt());
    }

    @Test
    public void dadoUmacategoriaValida_QuandoAtualizarCategoriaComParametroInvalido_deveRetornarACategoriaUpdateAtAtualizada() {
        // Dado
        final String expectedName = null;
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;

        // Quando
        final var aCategory = Category.newCategory("Filmes", "A categoria", expectedActive);

        // Então

        Assertions.assertDoesNotThrow(() -> aCategory.validate(new ThrowsValidatorHandler()));


        final var createdAt = aCategory.getCreatedAt();
        final var updatedAt = aCategory.getUpdateAt();

        final var actualCategory = aCategory.update(expectedName, expectedDescription, true);


        Assertions.assertEquals(aCategory.getId(), actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertTrue(aCategory.isActive());
        Assertions.assertNull(aCategory.getDeletedAt());

        Assertions.assertEquals(createdAt, actualCategory.getCreatedAt());
        Assertions.assertNull(aCategory.getDeletedAt());
        //Assertions.assertTrue(actualCategory.getUpdateAt().isAfter(updatedAt));

    }

}