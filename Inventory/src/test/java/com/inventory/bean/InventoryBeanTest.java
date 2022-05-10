package com.inventory.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class InventoryBeanTest {
    @Test
    void testCanEqual() {
        assertFalse((new InventoryBean()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        InventoryBean inventoryBean = new InventoryBean();

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(3);
        inventoryBean1.setProductPrice(10.0);
        assertTrue(inventoryBean.canEqual(inventoryBean1));
    }

    @Test
    void testConstructor() {
        InventoryBean actualInventoryBean = new InventoryBean();
        actualInventoryBean.setProductDetails("Product Details");
        actualInventoryBean.setProductId("42");
        actualInventoryBean.setProductInventory(1);
        actualInventoryBean.setProductPrice(10.0);
        assertEquals("Product Details", actualInventoryBean.getProductDetails());
        assertEquals("42", actualInventoryBean.getProductId());
        assertEquals(1, actualInventoryBean.getProductInventory());
        assertEquals(10.0, actualInventoryBean.getProductPrice());
        assertEquals("InventoryBean(productId=42, productInventory=1, productPrice=10.0, productDetails=Product Details)",
                actualInventoryBean.toString());
    }

    @Test
    void testEquals() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        assertFalse(inventoryBean.equals(null));
    }

    @Test
    void testEquals2() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        assertFalse(inventoryBean.equals("Different type to InventoryBean"));
    }

    @Test
    void testEquals3() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        assertTrue(inventoryBean.equals(inventoryBean));
        int expectedHashCodeResult = inventoryBean.hashCode();
        assertEquals(expectedHashCodeResult, inventoryBean.hashCode());
    }

    @Test
    void testEquals4() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        assertTrue(inventoryBean.equals(inventoryBean1));
        int expectedHashCodeResult = inventoryBean.hashCode();
        assertEquals(expectedHashCodeResult, inventoryBean1.hashCode());
    }

    @Test
    void testEquals5() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("42");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        assertFalse(inventoryBean.equals(inventoryBean1));
    }

    @Test
    void testEquals6() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails(null);
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        assertFalse(inventoryBean.equals(inventoryBean1));
    }

    @Test
    void testEquals7() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("Product Details");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        assertFalse(inventoryBean.equals(inventoryBean1));
    }

    @Test
    void testEquals8() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId(null);
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        assertFalse(inventoryBean.equals(inventoryBean1));
    }

    @Test
    void testEquals9() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(3);
        inventoryBean.setProductPrice(10.0);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        assertFalse(inventoryBean.equals(inventoryBean1));
    }

    @Test
    void testEquals10() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(0.5);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        assertFalse(inventoryBean.equals(inventoryBean1));
    }

    @Test
    void testEquals11() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails(null);
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails(null);
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        assertTrue(inventoryBean.equals(inventoryBean1));
        int expectedHashCodeResult = inventoryBean.hashCode();
        assertEquals(expectedHashCodeResult, inventoryBean1.hashCode());
    }

    @Test
    void testEquals12() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId(null);
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId(null);
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        assertTrue(inventoryBean.equals(inventoryBean1));
        int expectedHashCodeResult = inventoryBean.hashCode();
        assertEquals(expectedHashCodeResult, inventoryBean1.hashCode());
    }
}

