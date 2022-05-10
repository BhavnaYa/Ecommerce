package com.inventory.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.demo.utility.exceptions.NotFoundException;
import com.inventory.bean.InventoryBean;
import com.inventory.repository.InventoryRepo;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {InventoryServiceImpl.class})
@ExtendWith(SpringExtension.class)
class InventoryServiceImplTest {
    @MockBean
    private InventoryRepo inventoryRepo;

    @Autowired
    private InventoryServiceImpl inventoryServiceImpl;

    @Test
    void testGetProductInfo() {
        ArrayList<InventoryBean> inventoryBeanList = new ArrayList<>();
        when(this.inventoryRepo.findAll()).thenReturn(inventoryBeanList);
        List<InventoryBean> actualProductInfo = this.inventoryServiceImpl.getProductInfo();
        assertSame(inventoryBeanList, actualProductInfo);
        assertTrue(actualProductInfo.isEmpty());
        verify(this.inventoryRepo).findAll();
    }

    @Test
    void testGetProductInfo2() {
        when(this.inventoryRepo.findAll()).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.inventoryServiceImpl.getProductInfo());
        verify(this.inventoryRepo).findAll();
    }

    @Test
    void testAddProduct() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        when(this.inventoryRepo.save((InventoryBean) any())).thenReturn(inventoryBean);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        assertSame(inventoryBean, this.inventoryServiceImpl.addProduct(inventoryBean1));
        verify(this.inventoryRepo).save((InventoryBean) any());
        assertTrue(this.inventoryServiceImpl.getProductInfo().isEmpty());
    }

    @Test
    void testAddProduct2() {
        when(this.inventoryRepo.save((InventoryBean) any())).thenThrow(new NotFoundException("An error occurred"));

        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        assertThrows(NotFoundException.class, () -> this.inventoryServiceImpl.addProduct(inventoryBean));
        verify(this.inventoryRepo).save((InventoryBean) any());
    }

    @Test
    void testGetProductDetails() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        Optional<InventoryBean> ofResult = Optional.of(inventoryBean);
        when(this.inventoryRepo.findById((String) any())).thenReturn(ofResult);
        Optional<InventoryBean> actualProductDetails = this.inventoryServiceImpl.getProductDetails("42");
        assertSame(ofResult, actualProductDetails);
        assertTrue(actualProductDetails.isPresent());
        verify(this.inventoryRepo).findById((String) any());
        assertTrue(this.inventoryServiceImpl.getProductInfo().isEmpty());
    }

    @Test
    void testGetProductDetails2() {
        when(this.inventoryRepo.findById((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.inventoryServiceImpl.getProductDetails("42"));
        verify(this.inventoryRepo).findById((String) any());
    }

    @Test
    void testUpdateproductDetails() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        Optional<InventoryBean> ofResult = Optional.of(inventoryBean);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        when(this.inventoryRepo.save((InventoryBean) any())).thenReturn(inventoryBean1);
        when(this.inventoryRepo.findById((String) any())).thenReturn(ofResult);

        InventoryBean inventoryBean2 = new InventoryBean();
        inventoryBean2.setProductDetails("Product Details");
        inventoryBean2.setProductId("42");
        inventoryBean2.setProductInventory(1);
        inventoryBean2.setProductPrice(10.0);
        assertSame(inventoryBean1, this.inventoryServiceImpl.updateproductDetails(inventoryBean2, "42"));
        verify(this.inventoryRepo).save((InventoryBean) any());
        verify(this.inventoryRepo).findById((String) any());
        assertEquals("42", inventoryBean2.getProductId());
        assertTrue(this.inventoryServiceImpl.getProductInfo().isEmpty());
    }

    @Test
    void testUpdateproductDetails2() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        Optional<InventoryBean> ofResult = Optional.of(inventoryBean);
        when(this.inventoryRepo.save((InventoryBean) any())).thenThrow(new NotFoundException("An error occurred"));
        when(this.inventoryRepo.findById((String) any())).thenReturn(ofResult);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        assertThrows(NotFoundException.class, () -> this.inventoryServiceImpl.updateproductDetails(inventoryBean1, "42"));
        verify(this.inventoryRepo).save((InventoryBean) any());
        verify(this.inventoryRepo).findById((String) any());
    }

    @Test
    void testUpdateproductDetails3() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        when(this.inventoryRepo.save((InventoryBean) any())).thenReturn(inventoryBean);
        when(this.inventoryRepo.findById((String) any())).thenReturn(Optional.empty());

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        assertThrows(NotFoundException.class, () -> this.inventoryServiceImpl.updateproductDetails(inventoryBean1, "42"));
        verify(this.inventoryRepo).findById((String) any());
    }

    @Test
    void testUpdateProductInventory() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        Optional<InventoryBean> ofResult = Optional.of(inventoryBean);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        when(this.inventoryRepo.save((InventoryBean) any())).thenReturn(inventoryBean1);
        when(this.inventoryRepo.findById((String) any())).thenReturn(ofResult);
        assertSame(inventoryBean1, this.inventoryServiceImpl.updateProductInventory("42", "Flag"));
        verify(this.inventoryRepo).save((InventoryBean) any());
        verify(this.inventoryRepo).findById((String) any());
        assertTrue(this.inventoryServiceImpl.getProductInfo().isEmpty());
    }

    @Test
    void testUpdateProductInventory2() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        Optional<InventoryBean> ofResult = Optional.of(inventoryBean);
        when(this.inventoryRepo.save((InventoryBean) any())).thenThrow(new NotFoundException("An error occurred"));
        when(this.inventoryRepo.findById((String) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class, () -> this.inventoryServiceImpl.updateProductInventory("42", "Flag"));
        verify(this.inventoryRepo).save((InventoryBean) any());
        verify(this.inventoryRepo).findById((String) any());
    }

    @Test
    void testUpdateProductInventory3() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        when(this.inventoryRepo.save((InventoryBean) any())).thenReturn(inventoryBean);
        when(this.inventoryRepo.findById((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.inventoryServiceImpl.updateProductInventory("42", "Flag"));
        verify(this.inventoryRepo).findById((String) any());
    }

    @Test
    void testUpdateProductInventory4() {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        Optional<InventoryBean> ofResult = Optional.of(inventoryBean);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        when(this.inventoryRepo.save((InventoryBean) any())).thenReturn(inventoryBean1);
        when(this.inventoryRepo.findById((String) any())).thenReturn(ofResult);
        assertSame(inventoryBean1, this.inventoryServiceImpl.updateProductInventory("42", "add"));
        verify(this.inventoryRepo).save((InventoryBean) any());
        verify(this.inventoryRepo).findById((String) any());
        assertTrue(this.inventoryServiceImpl.getProductInfo().isEmpty());
    }
}

