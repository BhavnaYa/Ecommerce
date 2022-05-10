package com.demo.account.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AccountBeanTest {
    @Test
    void testCanEqual() {
        assertFalse((new AccountBean()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        AccountBean accountBean = new AccountBean();

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        assertTrue(accountBean.canEqual(accountBean1));
    }

    @Test
    void testConstructor() {
        AccountBean actualAccountBean = new AccountBean();
        actualAccountBean.setEmailId("42");
        actualAccountBean.setLoginStatus(true);
        actualAccountBean.setName("Name");
        actualAccountBean.setPassword("iloveyou");
        actualAccountBean.setPhoneNo("4105551212");
        assertEquals("42", actualAccountBean.getEmailId());
        assertEquals("Name", actualAccountBean.getName());
        assertEquals("iloveyou", actualAccountBean.getPassword());
        assertEquals("4105551212", actualAccountBean.getPhoneNo());
        assertTrue(actualAccountBean.isLoginStatus());
        assertEquals("AccountBean(emailId=42, password=iloveyou, name=Name, phoneNo=4105551212, loginStatus=true)",
                actualAccountBean.toString());
    }

    @Test
    void testEquals() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("4105551212");
        assertFalse(accountBean.equals(null));
    }

    @Test
    void testEquals2() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("4105551212");
        assertFalse(accountBean.equals("Different type to AccountBean"));
    }

    @Test
    void testEquals3() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("4105551212");
        assertTrue(accountBean.equals(accountBean));
        int expectedHashCodeResult = accountBean.hashCode();
        assertEquals(expectedHashCodeResult, accountBean.hashCode());
    }

    @Test
    void testEquals4() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("4105551212");

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        assertTrue(accountBean.equals(accountBean1));
        int expectedHashCodeResult = accountBean.hashCode();
        assertEquals(expectedHashCodeResult, accountBean1.hashCode());
    }

    @Test
    void testEquals5() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("jane.doe@example.org");
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("4105551212");

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        assertFalse(accountBean.equals(accountBean1));
    }

    @Test
    void testEquals6() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId(null);
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("4105551212");

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        assertFalse(accountBean.equals(accountBean1));
    }

    @Test
    void testEquals7() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(false);
        accountBean.setName("Name");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("4105551212");

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        assertFalse(accountBean.equals(accountBean1));
    }

    @Test
    void testEquals8() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName("42");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("4105551212");

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        assertFalse(accountBean.equals(accountBean1));
    }

    @Test
    void testEquals9() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName(null);
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("4105551212");

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        assertFalse(accountBean.equals(accountBean1));
    }

    @Test
    void testEquals10() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword("42");
        accountBean.setPhoneNo("4105551212");

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        assertFalse(accountBean.equals(accountBean1));
    }

    @Test
    void testEquals11() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword(null);
        accountBean.setPhoneNo("4105551212");

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        assertFalse(accountBean.equals(accountBean1));
    }

    @Test
    void testEquals12() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("+44 1865 4960636");

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        assertFalse(accountBean.equals(accountBean1));
    }

    @Test
    void testEquals13() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo(null);

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        assertFalse(accountBean.equals(accountBean1));
    }

    @Test
    void testEquals14() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId(null);
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("4105551212");

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId(null);
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        assertTrue(accountBean.equals(accountBean1));
        int expectedHashCodeResult = accountBean.hashCode();
        assertEquals(expectedHashCodeResult, accountBean1.hashCode());
    }

    @Test
    void testEquals15() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName(null);
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("4105551212");

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName(null);
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        assertTrue(accountBean.equals(accountBean1));
        int expectedHashCodeResult = accountBean.hashCode();
        assertEquals(expectedHashCodeResult, accountBean1.hashCode());
    }

    @Test
    void testEquals16() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword(null);
        accountBean.setPhoneNo("4105551212");

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword(null);
        accountBean1.setPhoneNo("4105551212");
        assertTrue(accountBean.equals(accountBean1));
        int expectedHashCodeResult = accountBean.hashCode();
        assertEquals(expectedHashCodeResult, accountBean1.hashCode());
    }

    @Test
    void testEquals17() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo(null);

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo(null);
        assertTrue(accountBean.equals(accountBean1));
        int expectedHashCodeResult = accountBean.hashCode();
        assertEquals(expectedHashCodeResult, accountBean1.hashCode());
    }
}

