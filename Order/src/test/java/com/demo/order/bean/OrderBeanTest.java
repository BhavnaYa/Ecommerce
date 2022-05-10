package com.demo.order.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.demo.order.enums.OrderStatus;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class OrderBeanTest {
    @Test
    void testCanEqual() {
        assertFalse((new OrderBean()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        OrderBean orderBean = new OrderBean();

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(3);
        assertTrue(orderBean.canEqual(orderBean1));
    }

    @Test
    void testConstructor() {
        OrderBean actualOrderBean = new OrderBean();
        actualOrderBean.setAddress("42 Main St");
        actualOrderBean.setEmailId("42");
        actualOrderBean.setOrderId("42");
        ArrayList<String> stringList = new ArrayList<>();
        actualOrderBean.setOrderInfo(stringList);
        actualOrderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        actualOrderBean.setOrderTotal(10.0);
        actualOrderBean.setQuantity(1);
        assertEquals("42 Main St", actualOrderBean.getAddress());
        assertEquals("42", actualOrderBean.getEmailId());
        assertEquals("42", actualOrderBean.getOrderId());
        assertSame(stringList, actualOrderBean.getOrderInfo());
        assertEquals(OrderStatus.ORDER_CREATED, actualOrderBean.getOrderStatus());
        assertEquals(10.0, actualOrderBean.getOrderTotal());
        assertEquals(1, actualOrderBean.getQuantity());
        assertEquals(
                "OrderBean(orderId=42, emailId=42, address=42 Main St, orderStatus=ORDER_CREATED, orderInfo=[], quantity=1,"
                        + " orderTotal=10.0)",
                actualOrderBean.toString());
    }

    @Test
    void testEquals() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);
        assertFalse(orderBean.equals(null));
    }

    @Test
    void testEquals2() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);
        assertFalse(orderBean.equals("Different type to OrderBean"));
    }

    @Test
    void testEquals3() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);
        assertTrue(orderBean.equals(orderBean));
        int expectedHashCodeResult = orderBean.hashCode();
        assertEquals(expectedHashCodeResult, orderBean.hashCode());
    }

    @Test
    void testEquals4() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertTrue(orderBean.equals(orderBean1));
        int expectedHashCodeResult = orderBean.hashCode();
        assertEquals(expectedHashCodeResult, orderBean1.hashCode());
    }

    @Test
    void testEquals5() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertFalse(orderBean.equals(orderBean1));
    }

    @Test
    void testEquals6() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress(null);
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertFalse(orderBean.equals(orderBean1));
    }

    @Test
    void testEquals7() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("jane.doe@example.org");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertFalse(orderBean.equals(orderBean1));
    }

    @Test
    void testEquals8() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId(null);
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertFalse(orderBean.equals(orderBean1));
    }

    @Test
    void testEquals9() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42 Main St");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertFalse(orderBean.equals(orderBean1));
    }

    @Test
    void testEquals10() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId(null);
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertFalse(orderBean.equals(orderBean1));
    }

    @Test
    void testEquals11() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("42");

        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(stringList);
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertFalse(orderBean.equals(orderBean1));
    }

    @Test
    void testEquals12() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(null);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertFalse(orderBean.equals(orderBean1));
    }

    @Test
    void testEquals13() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_REJECTED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertFalse(orderBean.equals(orderBean1));
    }

    @Test
    void testEquals14() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(0.5);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertFalse(orderBean.equals(orderBean1));
    }

    @Test
    void testEquals15() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(3);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertFalse(orderBean.equals(orderBean1));
    }

    @Test
    void testEquals16() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress(null);
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress(null);
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertTrue(orderBean.equals(orderBean1));
        int expectedHashCodeResult = orderBean.hashCode();
        assertEquals(expectedHashCodeResult, orderBean1.hashCode());
    }

    @Test
    void testEquals17() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId(null);
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId(null);
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertTrue(orderBean.equals(orderBean1));
        int expectedHashCodeResult = orderBean.hashCode();
        assertEquals(expectedHashCodeResult, orderBean1.hashCode());
    }

    @Test
    void testEquals18() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId(null);
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId(null);
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertTrue(orderBean.equals(orderBean1));
        int expectedHashCodeResult = orderBean.hashCode();
        assertEquals(expectedHashCodeResult, orderBean1.hashCode());
    }

    @Test
    void testEquals19() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(null);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(null);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertTrue(orderBean.equals(orderBean1));
        int expectedHashCodeResult = orderBean.hashCode();
        assertEquals(expectedHashCodeResult, orderBean1.hashCode());
    }
}

