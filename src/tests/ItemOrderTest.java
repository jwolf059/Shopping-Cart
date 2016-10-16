/*
 * Assignment - 2
 * 
 * TCSS 305 Autumn 2015
 */
package tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import model.Item;
import model.ItemOrder;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test for the ItemOrder Class.
 * 
 * @author Jeremy Wolf email: jwolf059@uw.edu
 * @version 15 October 2015
 */

public class ItemOrderTest {


    /** 
     * The test fixture. The Item test Object used in the test. 
     */
    private Item myInvisiblePen;
    
    /** 
     * The test fixture. The Item test Object used in the test. 
     */
    private Item myShirts;
    
    /** 
     * The test fixture. The ItemOrder test Object used in the test. 
     */
    private ItemOrder myTestOrder;
    
    /** 
     * The test fixture. The ItemOrder test Object used in the test.
     */
    private ItemOrder mySecondTest;
    
    /** 
     * The test fixture. The ItemOrder test Object used in the test. 
     */
    private ItemOrder myThirdOrder;
  
    /** 
     * A method to initialize the test fixtures before each test.
     */
    @Before
    public void setUp() {
        final BigDecimal price = new BigDecimal("25.00");
        final BigDecimal bulkPrice = new BigDecimal("100.00");
        myShirts = new Item("UWT T-Shirt", price, 5, bulkPrice);
        myInvisiblePen = new Item("Pen-that-writes-nothing", price, 5, bulkPrice);
        myTestOrder = new ItemOrder(myShirts, 5);
        mySecondTest = new ItemOrder(myInvisiblePen, 6);
        myThirdOrder = new ItemOrder(myShirts, 2);

    }
    
    /**
     * Test method for {@link ItemOrder#ItemOrder(Item, int)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testIllegalQuanityItemOrder() {
        new ItemOrder(myInvisiblePen, -1);
    }
    
    /**
     * Test method for {@link ItemOrder#calculateOrderTotal()}.
     */
    @Test
    public void testCalculateOrderTotal() {
        
        final BigDecimal lessThanBulkTotal = new BigDecimal("50.00");
        assertEquals("Failed less than Bulk Order total", lessThanBulkTotal, 
                     myThirdOrder.calculateOrderTotal());
        
        final BigDecimal expectedTotal = new BigDecimal("100.00");
        assertEquals("Failed exactly bulk order total", expectedTotal, 
                     myTestOrder.calculateOrderTotal());
        
        final BigDecimal overBulkTotal = new BigDecimal("125.00");
        assertEquals("Failed more then bulk order total", overBulkTotal, 
                     mySecondTest.calculateOrderTotal());
    }
    
    /**
     * Test method for {@link ItemOrder#getItem()}.
     */
    @Test
    public void testGetItem() {
        final Item testGetItem = mySecondTest.getItem();
        assertEquals(myInvisiblePen, testGetItem);
        
    }
    
    /**
     * Test method for {@link ItemOrder#getQuantity()}.
     */
    @Test
    public void testGetQuantity() {
        final int testQuantity = mySecondTest.getQuantity();
        assertEquals(6, testQuantity);
    }
    
    /**
     * Test method for {@link ItemOrder#toString()}.
     */
    @Test
    public void testToString() {
        final String testString = mySecondTest.toString();
        final String expectedString = "Pen-that-writes-nothing, $25.00 (5 for $100.00) "
                                       + "Number of Items ordered: 6 Total = $125.00";
        assertEquals(expectedString, testString);
    }
    /**
     * Test method for {@link ItemOrder#compareTo(ItemOrder)}.
     */
    @Test
    public void testCompareTo() {
        int testVal = myTestOrder.compareTo(mySecondTest);
        assertEquals(5, testVal);
        testVal = mySecondTest.compareTo(myTestOrder);
        assertEquals(-5, testVal);
        testVal = mySecondTest.compareTo(mySecondTest);
        assertEquals(0, testVal);
    }
}
