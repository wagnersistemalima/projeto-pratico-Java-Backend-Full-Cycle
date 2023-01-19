package com.fullcycle.admin.catalogo.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserCaseTest {

    @Test
    public void testCreateUsercase() {
        UserCase userCase = new UserCase();

        assertNotNull(userCase);

    }

}