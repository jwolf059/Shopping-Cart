/*
 * Assignment - 2
 * 
 * TCSS 305 Autumn 2015
 */
package tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Objects;
import model.Item;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test for the Item Class.
 * 
 * @author Jeremy Wolf email jwolf059@uw.edu
 * @version 14 October 2015
 */
public class ItemTest {
    
    /** 
     * A test fixture. 
     */
    private BigDecimal myBulkPrice;
    
    /** 
     * A test fixture. 
     */
    private BigDecimal myPrice;
    
    /** 
     * The test fixture. The Item test Object used in the test 
     */
    private Item myShirts;
    
    /** 
     * The test fixture. The Item test Object used in the test 
     */
    private Item myIpad;
    
    /** 
     * A method to initialize the test fixtures before each test.
     */
    @Before
    public void setUp() {
        myPrice = new BigDecimal("25.00");
        myBulkPrice = new BigDecimal("100.00");
        myIpad = new Item("Ipad 9", myPrice);
        myShirts = new Item("UWT T-Shirt", myPrice, 5, myBulkPrice);
    }
    
    /**
     * Test method for {@link Item#hashCode()}.
     */
    @Test
    public void testHashCode() {
        final String testName = "UWT T-Shirt";
        final int testBulkQuantity = 5;     
        final int testHash = Objects.hash(testName, myPrice, testBulkQuantity, myBulkPrice);
        assertEquals(testHash, myShirts.hashCode());   
    }
    
    /**
     * Test method for illegalArgumentException in
     * {@link Item#Item(String, BigDecimal)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testIllegalPriceValueForConstructor() {
        final BigDecimal testPrice = new BigDecimal("-1.00");
        new Item("Test Item", testPrice);
    }
    
    /**
     * Test method for illegalArgumentException for price parameter in
     * {@link Item#Item(String, BigDecimal, int, BigDecimal)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testIllegalPriceValueForFourParameterConstructor() {
        final BigDecimal testPrice = new BigDecimal("-1.00");
        new Item("Test Item", testPrice, 10, myBulkPrice);
    }
    
    /**
     * Test method for illegalArgumentException for Bulk Quantity parameter 
     * in {@link Item#Item(String, BigDecimal, int, BigDecimal)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testIllegalBulkQuantityValueForFourParameterConstructor() {
        new Item("Test Item", myPrice, -1, myBulkPrice);
    }
    
    /**
     * Test method for illegalArgumentException for Bulk price parameter in
     * {@link Item#Item(String, BigDecimal, int, BigDecimal)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testIllegalBulkPriceValueForFourParameterConstructor() {
        final BigDecimal testPrice = new BigDecimal("-1.00");
        new Item("Test Item", myPrice, 10, testPrice);
    }
    
    /**
     * Test method for {@link Item#calculateItemTotal(int)}.
     */
    @Test
    public void testCalculateItemTotal() {
        final BigDecimal testTotal = new BigDecimal("50.00");
        assertEquals("Failed testTotal for order less then bulk amount", 
                     testTotal, myShirts.calculateItemTotal(2));
        
        final BigDecimal bulkTestTotal = new BigDecimal("100.00");
        assertEquals("Failed testTotal for order equal to bulk amount", 
                     bulkTestTotal, myShirts.calculateItemTotal(5));
        
        final BigDecimal bulkTestTotal2 = new BigDecimal("150.00");
        assertEquals("Failed testTotal for order over the bulk amount", 
                     bulkTestTotal2, myShirts.calculateItemTotal(7));
        
        assertEquals("Failed testTotal for item with no bulk amount", 
                     testTotal, myIpad.calculateItemTotal(2));
    }
    
    /**
     * Test method for {@link Item#isBulk()}.
     */
    @Test
    public void testIsBulk() {
        assertEquals(true, myShirts.isBulk());
        assertEquals(false, myIpad.isBulk());
    }
    
    /**
     * Test method for {@link Item#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("UWT T-Shirt, $25.00 (5 for $100.00) ", myShirts.toString());
        assertEquals("Ipad 9, $25.00 ", myIpad.toString());
    }
    
    /**
     *Test method for {@link Item#equals(Object)}. 
     */
    @Test
    public void testEqualsObject() {
        final BigDecimal testBulkPrice = new BigDecimal("65.00");
        final Item testItemSameName = new Item("Ipad 9", myBulkPrice);
        final Item testItem = new Item("Ipad 9", myPrice, 4, myBulkPrice);
        final Item testItemMyShirt = new Item("UWT T-Shirt", myPrice, 5, testBulkPrice);
        final Item testItemMyShirt2 = new Item("UWT T-Shirt", myPrice, 5, testBulkPrice);
        assertEquals("Failed completely different item test", false, myIpad.equals(myShirts));
        assertEquals("Failed same refrence point test", true, myIpad.equals(myIpad));
        assertEquals("Failed Item with same name but different price", false, 
                     testItemSameName.equals(myIpad));
        assertEquals("Failed Item with same name and price with different bulk quantity", 
                     false, testItem.equals(myIpad));
        assertEquals("Failed different object test", false, myIpad.equals(testBulkPrice));
        assertEquals("Failed Item with same name, price, and bulk quantity but with "
                        + "different bulk price", false, testItemMyShirt.equals(myShirts));
        assertEquals("Failed Item with same name, price, bulk quantity, and bulk price",
                     true, testItemMyShirt2.equals(testItemMyShirt));
    }
    
    /**
     * Test method for {@link Item#compareTo(Item)}.
     */
    @Test
    public void testcompareTo() {
        
        int testVal = myIpad.compareTo(myShirts);
        assertEquals(-12, testVal);
        testVal = myShirts.compareTo(myIpad);
        assertEquals(12, testVal);
        testVal = myShirts.compareTo(myShirts);
        assertEquals(0, testVal);
    }
}
