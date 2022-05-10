package com.demo.order.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.demo.order.bean.OrderBean;
import com.demo.order.enums.OrderStatus;
import com.demo.order.repository.OrderRepository;
import com.demo.utility.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;

@ContextConfiguration(classes = {OrderService.class})
@ExtendWith(SpringExtension.class)
class OrderServiceTest {
    @MockBean
    private WebClient.Builder builder;

    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Test
    void testAddOrder() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);
        when(this.orderRepository.save((OrderBean) any())).thenReturn(orderBean);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertSame(orderBean, this.orderService.addOrder(orderBean1));
        verify(this.orderRepository).save((OrderBean) any());
        assertEquals(0, orderBean1.getQuantity());
        assertEquals(0.0, orderBean1.getOrderTotal());
        assertEquals(OrderStatus.ORDER_CREATED, orderBean1.getOrderStatus());
    }

    @Test
    void testAddOrder2() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);
        when(this.orderRepository.save((OrderBean) any())).thenReturn(orderBean);
        when(this.builder.build()).thenThrow(new NotFoundException("An error occurred"));

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("http://localhost:8083/inventory/getProductInfo/");

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(stringList);
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        assertThrows(NotFoundException.class, () -> this.orderService.addOrder(orderBean1));
        verify(this.builder).build();
    }

    @Test
    void testCancelOrder() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);
        Optional<OrderBean> ofResult = Optional.of(orderBean);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        when(this.orderRepository.save((OrderBean) any())).thenReturn(orderBean1);
        when(this.orderRepository.findById((String) any())).thenReturn(ofResult);
        assertSame(orderBean1, this.orderService.cancelOrder("42"));
        verify(this.orderRepository).save((OrderBean) any());
        verify(this.orderRepository).findById((String) any());
    }

    @Test
    void testCancelOrder2() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);
        Optional<OrderBean> ofResult = Optional.of(orderBean);
        when(this.orderRepository.save((OrderBean) any())).thenThrow(new NotFoundException("An error occurred"));
        when(this.orderRepository.findById((String) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class, () -> this.orderService.cancelOrder("42"));
        verify(this.orderRepository).save((OrderBean) any());
        verify(this.orderRepository).findById((String) any());
    }

    @Test
    void testCancelOrder3() {
        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(new ArrayList<>());
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);
        when(this.orderRepository.save((OrderBean) any())).thenReturn(orderBean);
        when(this.orderRepository.findById((String) any())).thenReturn(Optional.empty());
        when(this.builder.build()).thenReturn(null);
        assertThrows(NotFoundException.class, () -> this.orderService.cancelOrder("42"));
        verify(this.orderRepository).findById((String) any());
    }

    @Test
    void testCancelOrder4() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("http://localhost:8083/inventory/updateProductInventory/");

        OrderBean orderBean = new OrderBean();
        orderBean.setAddress("42 Main St");
        orderBean.setEmailId("42");
        orderBean.setOrderId("42");
        orderBean.setOrderInfo(stringList);
        orderBean.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean.setOrderTotal(10.0);
        orderBean.setQuantity(1);
        Optional<OrderBean> ofResult = Optional.of(orderBean);

        OrderBean orderBean1 = new OrderBean();
        orderBean1.setAddress("42 Main St");
        orderBean1.setEmailId("42");
        orderBean1.setOrderId("42");
        orderBean1.setOrderInfo(new ArrayList<>());
        orderBean1.setOrderStatus(OrderStatus.ORDER_CREATED);
        orderBean1.setOrderTotal(10.0);
        orderBean1.setQuantity(1);
        when(this.orderRepository.save((OrderBean) any())).thenReturn(orderBean1);
        when(this.orderRepository.findById((String) any())).thenReturn(ofResult);
        when(this.builder.build()).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.orderService.cancelOrder("42"));
        verify(this.orderRepository).findById((String) any());
        verify(this.builder).build();
    }

    @Test
    void testGetOrderHistory() {
        ArrayList<OrderBean> orderBeanList = new ArrayList<>();
        when(this.orderRepository.findByEmailId((String) any())).thenReturn(orderBeanList);
        List<OrderBean> actualOrderHistory = this.orderService.getOrderHistory("jane.doe@example.org");
        assertSame(orderBeanList, actualOrderHistory);
        assertTrue(actualOrderHistory.isEmpty());
        verify(this.orderRepository).findByEmailId((String) any());
    }

    @Test
    void testGetOrderHistory2() {
        when(this.orderRepository.findByEmailId((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.orderService.getOrderHistory("jane.doe@example.org"));
        verify(this.orderRepository).findByEmailId((String) any());
    }
}

