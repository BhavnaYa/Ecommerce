package com.demo.order.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.demo.order.bean.OrderBean;
import com.demo.order.enums.OrderStatus;
import com.demo.order.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

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

@ContextConfiguration(classes = {OrderController.class})
@ExtendWith(SpringExtension.class)
class OrderControllerTest {
    @Autowired
    private OrderController orderController;

    @MockBean
    private OrderService orderService;

    @Test
    void testAddToCart() throws Exception {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);
        when(this.orderService.addOrder((OrderBean) any())).thenReturn(orderBean);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        String content = (new ObjectMapper()).writeValueAsString(orderBean1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/order/addOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"orderId\":\"42\",\"emailId\":\"42\",\"address\":\"42 Main St\",\"orderStatus\":\"ORDER_CREATED\",\"orderInfo\":[],"
                                        + "\"quantity\":1,\"orderTotal\":10.0}"));
    }

    @Test
    void testCancelOrder() throws Exception {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);
        when(this.orderService.cancelOrder((String) any())).thenReturn(orderBean);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/order/cancelOrder/{orderId}", "42");
        MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"orderId\":\"42\",\"emailId\":\"42\",\"address\":\"42 Main St\",\"orderStatus\":\"ORDER_CREATED\",\"orderInfo\":[],"
                                        + "\"quantity\":1,\"orderTotal\":10.0}"));
    }

    @Test
    void testGetOrderHistory() throws Exception {
        when(this.orderService.getOrderHistory((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/order/orderHistory")
                .param("email", "foo");
        MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

