package com.demo.order.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OrderStatusTest {
    @Test
    void testValueOf() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by valueOf(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        OrderStatus.valueOf("ORDER_CANCELLED");
    }

    @Test
    void testValueOf2() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by valueOf(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        OrderStatus.valueOf("ORDER_CREATED");
    }

    @Test
    void testValueOf3() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by valueOf(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        OrderStatus.valueOf("ORDER_REJECTED");
    }

    @Test
    void testValues() {
        OrderStatus[] actualValuesResult = OrderStatus.values();
        assertEquals(3, actualValuesResult.length);
        assertEquals(OrderStatus.ORDER_CREATED, actualValuesResult[0]);
        assertEquals(OrderStatus.ORDER_REJECTED, actualValuesResult[1]);
        assertEquals(OrderStatus.ORDER_CANCELLED, actualValuesResult[2]);
    }
}

