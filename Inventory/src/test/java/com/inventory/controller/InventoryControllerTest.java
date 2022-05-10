package com.inventory.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventory.bean.InventoryBean;
import com.inventory.service.InventoryService;

import java.util.ArrayList;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {InventoryController.class})
@ExtendWith(SpringExtension.class)
class InventoryControllerTest {
    @Autowired
    private InventoryController inventoryController;

    @MockBean
    private InventoryService inventoryService;

    @Test
    void testAddProduct() throws Exception {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        when(this.inventoryService.addProduct((InventoryBean) any())).thenReturn(inventoryBean);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        String content = (new ObjectMapper()).writeValueAsString(inventoryBean1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/inventory/addProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.inventoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"productId\":\"42\",\"productInventory\":1,\"productPrice\":10.0,\"productDetails\":\"Product Details\"}"));
    }

    @Test
    void testGetProductInfo() throws Exception {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        Optional<InventoryBean> ofResult = Optional.of(inventoryBean);
        when(this.inventoryService.getProductDetails((String) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/inventory/getProductInfo/{productId}",
                "42");
        MockMvcBuilders.standaloneSetup(this.inventoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"productId\":\"42\",\"productInventory\":1,\"productPrice\":10.0,\"productDetails\":\"Product Details\"}"));
    }

    @Test
    void testSearchProduct() throws Exception {
        when(this.inventoryService.getProductInfo()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/inventory/searchProduct");
        MockMvcBuilders.standaloneSetup(this.inventoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testUpdateProductDetails() throws Exception {
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setProductDetails("Product Details");
        inventoryBean.setProductId("42");
        inventoryBean.setProductInventory(1);
        inventoryBean.setProductPrice(10.0);
        when(this.inventoryService.updateproductDetails((InventoryBean) any(), (String) any())).thenReturn(inventoryBean);

        InventoryBean inventoryBean1 = new InventoryBean();
        inventoryBean1.setProductDetails("Product Details");
        inventoryBean1.setProductId("42");
        inventoryBean1.setProductInventory(1);
        inventoryBean1.setProductPrice(10.0);
        String content = (new ObjectMapper()).writeValueAsString(inventoryBean1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/inventory/updateProductDetails/{productId}", "42")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.inventoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"productId\":\"42\",\"productInventory\":1,\"productPrice\":10.0,\"productDetails\":\"Product Details\"}"));
    }
}

