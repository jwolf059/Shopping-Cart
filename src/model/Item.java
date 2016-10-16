/*
 * Assignment - 2
 * 
 * TCSS 305 Autumn 2015
 */

package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
/**
 * Class for the Item Object, this object stores information 
 * about an individual item.
 * 
 * @author Jeremy Wolf email jwolf059@uw.edu
 * @version 14 October 2015
 */
public final class Item implements Comparable<Item> {
    
    /**
     *  Constant for to test to determine if the BigDecmial is greater then or equal to 0.
     */
    private static final BigDecimal COMPAREVALUE = new BigDecimal("0.00");
    
    /** 
     * Field to store the name of the Item.
     */
    private String myName;
    
    /** 
     * Field to store the price of the Item.
     */
    private BigDecimal myPrice;
    
    /** 
     * Field to store the bulk quantity of the Item.
     */
    private int myBulkQuantity;
    
    /** 
     * Field to store the bulk price of the Item.
     */
    private BigDecimal myBulkPrice;

    /**
     * Constructor for the Item Class takes a String for the name and a 
     * BigDecmial for the price.
     * 
     * @param theName String input for item name.
     * @param thePrice BigDecimal input for the item price.
     */
    public Item(final String theName, final BigDecimal thePrice) {
            
        if (theName.isEmpty() || thePrice.compareTo(COMPAREVALUE) <= 0) {
            
            throw new IllegalArgumentException(); 
            
        } else {
            myName = theName; 
            myPrice = thePrice;
        }
    }

    /**
     * Constructor for an item that will have a bulk discount associated with it. 
     * the Bulk discount is received when an order is place for at least the bulk
     * quantity, but all items over the bulk amount will be at the standard price.
     * 
     * @param theName String input for item name.
     * @param thePrice BigDecimal input for the item price.
     * @param theBulkQuantity integer number for BulkQuantity.
     * @param theBulkPrice BigDecimal input for price of Bulk Order.
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        
        if (thePrice.compareTo(COMPAREVALUE) <= 0 || theBulkQuantity <= 0 
            || theBulkPrice.compareTo(COMPAREVALUE) <= 0) {
            
            throw new IllegalArgumentException(); 
            
        } else {
            myName = theName; 
            myPrice = thePrice;
            myBulkQuantity = theBulkQuantity;
            myBulkPrice = theBulkPrice;
        }
    }
    /**
     * Calculates the total for the quantity of items requested. This method
     * gives the bulk discount on multiples of the bulk quantity, and then calculates
     * anything over that number at the standard rate.
     * 
     * @param theQuantity an Integer value for number of Items ordered
     * @return BigDecimal value for total price for items.
     */
    public BigDecimal calculateItemTotal(final int theQuantity) {
        
        final BigDecimal itemTotal;
        final BigDecimal quantity = new BigDecimal(theQuantity);
        final BigDecimal bulkQuantity = new BigDecimal(myBulkQuantity);

        if (isBulk() && theQuantity >= myBulkQuantity) {
            
            final BigDecimal bulkOrder = quantity.divide(bulkQuantity, RoundingMode.HALF_EVEN);
            final BigDecimal bulkOrderTotal = myBulkPrice.multiply(bulkOrder);
            final BigDecimal remainingQuantity = quantity.remainder(bulkQuantity);
            itemTotal = bulkOrderTotal.add(myPrice.multiply(remainingQuantity));
                                     
        } else {
            itemTotal = myPrice.multiply(quantity);
        }
        return itemTotal;
    }
    /**
     * Determines if the item has a bulk discount. Will return true if a bulk
     * discount can be applied.
     * 
     * @return boolean value for if Item has bulk discount.
     */
    public boolean isBulk() {
        boolean bulk = false;
        final BigDecimal bulkQuantity = new BigDecimal(myBulkQuantity);
        if (bulkQuantity.compareTo(COMPAREVALUE) > 0) {
            bulk = true;
        }
        
        return bulk;
    }
    /**
     * Provides a String representation of information about the given item
     * to include: Item name, price, bulk quantity, and bulk price.
     * 
     * @return a String representation of data contained in the Item.
     */
    @Override
    public String toString() {
        final StringBuilder itemInfoSB = new StringBuilder();
        itemInfoSB.append(myName);
        itemInfoSB.append(", $");
        itemInfoSB.append(myPrice);
        itemInfoSB.append(" ");
        if (isBulk()) {
            itemInfoSB.append("(");
            itemInfoSB.append(myBulkQuantity);
            itemInfoSB.append(" for $");
            itemInfoSB.append(myBulkPrice);
            itemInfoSB.append(") ");
        }
        final String itemInfo = itemInfoSB.toString();
        
        return itemInfo;
    }

    /**
     * Determines if two Items are the exactly the same.
     * 
     * @return a boolean value of true if the items are equal.
     */
    @Override
    public boolean equals(final Object theOther) {
        if (this == theOther) {
            return true;
        }
        if (!(theOther instanceof Item)) {
            return false;
        }
        final Item other = (Item) theOther; 
 
        return Objects.equals(myName, other.myName) 
               && Objects.equals(myPrice, other.myPrice) 
               && myBulkQuantity == other.myBulkQuantity 
               && Objects.equals(myBulkPrice, other.myBulkPrice);
    }

    /**
     * Produces a unique hashCode for this Item.
     * 
     * @return an integer hashCode. 
     */
    @Override
    public int hashCode() {
        
        return Objects.hash(myName, myPrice, myBulkQuantity, myBulkPrice);
    }
    
    /**
     * Determines that Item objects will be compared by the myName field 
     * when sorting is required.
     * 
     * @return an integer value for comparison of Items.
     */
    @Override
    public int compareTo(final Item theOther) {

        return myName.compareTo(theOther.myName);
    }

}
