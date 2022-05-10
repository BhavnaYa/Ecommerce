package com.demo.account.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JwtResponseTest {
    @Test
    void testConstructor() {
        assertEquals("ABC123", (new JwtResponse("ABC123")).getJwttoken());
    }
}

