package com.demo.account.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class JwtRequestTest {
    @Test
    void testCanEqual() {
        assertFalse((new JwtRequest()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        JwtRequest jwtRequest = new JwtRequest();

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail("jane.doe@example.org");
        jwtRequest1.setPassword("iloveyou");
        assertTrue(jwtRequest.canEqual(jwtRequest1));
    }

    @Test
    void testConstructor() {
        JwtRequest actualJwtRequest = new JwtRequest();
        actualJwtRequest.setEmail("jane.doe@example.org");
        actualJwtRequest.setPassword("iloveyou");
        assertEquals("jane.doe@example.org", actualJwtRequest.getEmail());
        assertEquals("iloveyou", actualJwtRequest.getPassword());
        assertEquals("JwtRequest(email=jane.doe@example.org, password=iloveyou)", actualJwtRequest.toString());
    }

    @Test
    void testEquals() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("jane.doe@example.org");
        jwtRequest.setPassword("iloveyou");
        assertFalse(jwtRequest.equals(null));
    }

    @Test
    void testEquals2() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("jane.doe@example.org");
        jwtRequest.setPassword("iloveyou");
        assertFalse(jwtRequest.equals("Different type to JwtRequest"));
    }

    @Test
    void testEquals3() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("jane.doe@example.org");
        jwtRequest.setPassword("iloveyou");
        assertTrue(jwtRequest.equals(jwtRequest));
        int expectedHashCodeResult = jwtRequest.hashCode();
        assertEquals(expectedHashCodeResult, jwtRequest.hashCode());
    }

    @Test
    void testEquals4() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("jane.doe@example.org");
        jwtRequest.setPassword("iloveyou");

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail("jane.doe@example.org");
        jwtRequest1.setPassword("iloveyou");
        assertTrue(jwtRequest.equals(jwtRequest1));
        int expectedHashCodeResult = jwtRequest.hashCode();
        assertEquals(expectedHashCodeResult, jwtRequest1.hashCode());
    }

    @Test
    void testEquals5() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("iloveyou");
        jwtRequest.setPassword("iloveyou");

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail("jane.doe@example.org");
        jwtRequest1.setPassword("iloveyou");
        assertFalse(jwtRequest.equals(jwtRequest1));
    }

    @Test
    void testEquals6() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail(null);
        jwtRequest.setPassword("iloveyou");

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail("jane.doe@example.org");
        jwtRequest1.setPassword("iloveyou");
        assertFalse(jwtRequest.equals(jwtRequest1));
    }

    @Test
    void testEquals7() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("jane.doe@example.org");
        jwtRequest.setPassword("jane.doe@example.org");

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail("jane.doe@example.org");
        jwtRequest1.setPassword("iloveyou");
        assertFalse(jwtRequest.equals(jwtRequest1));
    }

    @Test
    void testEquals8() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("jane.doe@example.org");
        jwtRequest.setPassword(null);

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail("jane.doe@example.org");
        jwtRequest1.setPassword("iloveyou");
        assertFalse(jwtRequest.equals(jwtRequest1));
    }

    @Test
    void testEquals9() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail(null);
        jwtRequest.setPassword("iloveyou");

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail(null);
        jwtRequest1.setPassword("iloveyou");
        assertTrue(jwtRequest.equals(jwtRequest1));
        int expectedHashCodeResult = jwtRequest.hashCode();
        assertEquals(expectedHashCodeResult, jwtRequest1.hashCode());
    }

    @Test
    void testEquals10() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("jane.doe@example.org");
        jwtRequest.setPassword(null);

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail("jane.doe@example.org");
        jwtRequest1.setPassword(null);
        assertTrue(jwtRequest.equals(jwtRequest1));
        int expectedHashCodeResult = jwtRequest.hashCode();
        assertEquals(expectedHashCodeResult, jwtRequest1.hashCode());
    }
}

