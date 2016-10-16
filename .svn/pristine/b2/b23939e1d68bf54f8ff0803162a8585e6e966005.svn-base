/*
 * Assignment - 2
 * 
 * TCSS 305 Autumn 2015
 */

package tests;

import static org.junit.Assert.*;


import java.math.BigDecimal;
import model.Item;
import model.ItemOrder;
import model.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test for the ShoppingCart Class.
 * 
 * @author Jeremy Wolf email: jwolf059@uw.edu
 * @version 15 October 2015
 */
public class ShoppingCartTest {
    /** 
     * A test fixture. The ShoppingCart object test used in the test. 
     */
    private ShoppingCart myTestCart;
    
    /** 
     * A test fixture. The ItemOrder object test used in the test. 
     */
    private ItemOrder myTestOrder;
    
    /** 
     * A test fixture. The ItemOrder object test used in the test. 
     */
    private ItemOrder myTestOrderTwo;
    
    /** 
     * A test fixture. The ItemOrder object test used in the test. 
     */
    private ItemOrder myTestOrderThree;
    
    /** 
     * A test fixture. The ItemOrder object test used in the test. 
     */
    private ItemOrder myTestOrderFour;
    
    /** 
     * A test fixture. The ItemOrder object test used in the test. 
     */
    private ItemOrder myTestOrderNoBulk;

    

    /**
     * 
     */
    @Before
    public void setUp() {
        myTestCart = new ShoppingCart();
        final BigDecimal price = new BigDecimal("25.00");
        final BigDecimal bulkPrice = new BigDecimal("100.00");
        final BigDecimal priceTwo = new BigDecimal("499.00");
        final BigDecimal bulkPriceTwo = new BigDecimal("800.00");
        final BigDecimal priceThree = new BigDecimal("10.00");
        final Item pencil = new Item("No. 4 Pencil", priceThree);
        final Item ipad = new Item("Ipad 4", priceTwo, 2, bulkPriceTwo);
        final Item shirts = new Item("UWT T-Shirt", price, 5, bulkPrice);
        final Item invisiblePen = new Item("Pen-that-writes-nothing", price, 5, bulkPrice);
        myTestOrder = new ItemOrder(shirts, 5);
        myTestOrderTwo = new ItemOrder(invisiblePen, 6);
        myTestOrderThree = new ItemOrder(ipad, 2);
        myTestOrderFour = new ItemOrder(shirts, 2);
        myTestOrderNoBulk = new ItemOrder(pencil, 10);
    }

    /**
     * Test Method for {@link ShoppingCart#add(ItemOrder)}.
     */
    @Test
    public void testAdd() {

        myTestCart.add(myTestOrder);
        final String testString = myTestCart.toString();
        final String expectedString = "UWT T-Shirt, $25.00 (5 for $100.00) Number "
                                 + "of Items ordered: 5 Total = $100.00\n";
        assertEquals(expectedString, testString);  
    }
    
    /**
     * Test Method for {@link ShoppingCart#setMembership(boolean)}.
     */
    @Test
    public void testSetMembership() {
        myTestCart.setMembership(true);
    }
    
    /**
     * Test Method for {@link ShoppingCart#calculateTotal()}.
     */
    @Test
    public void testCalculateTotal() {
        myTestCart.setMembership(true);
        myTestCart.add(myTestOrder);
        myTestCart.add(myTestOrderTwo);
        myTestCart.add(myTestOrderThree);
        myTestCart.add(myTestOrderNoBulk);
        myTestCart.add(myTestOrderFour);
        final BigDecimal expectedNum = new BigDecimal("1065.00");
        
        assertEquals(expectedNum, myTestCart.calculateTotal());
    }
    
    /**
     * Test Method for {@link ShoppingCart#clear()}.
     */
    @Test
    public void testClear() {
        myTestCart.add(myTestOrder);
        myTestCart.add(myTestOrderTwo);
        myTestCart.add(myTestOrderThree);
        myTestCart.add(myTestOrderNoBulk);
        myTestCart.clear();
        assertEquals("", myTestCart.toString());
    }
}
