package com.demo.account.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.text.StrBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EcomPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class EcomPasswordEncoderTest {
    @Autowired
    private EcomPasswordEncoder ecomPasswordEncoder;

    @Test
    void testEncode() {
        assertEquals("", this.ecomPasswordEncoder.encode(new StrBuilder()));
    }

    @Test
    void testMatches() {
        assertFalse(this.ecomPasswordEncoder.matches(new StrBuilder(), "foo"));
        assertTrue(this.ecomPasswordEncoder.matches("foo", "foo"));
    }
}

