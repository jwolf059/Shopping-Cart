/*
 * Assignment - 2
 * 
 * TCSS 305 Autumn 2015
 */
package model;

import java.math.BigDecimal;

/**
 * An ItemOrder object stores information about the purchase information for a particular Item.
 * 
 * @author Jeremy Wolf email: jwolf059@uw.edu
 * @version 15 October 2015
 */
public final class ItemOrder implements Comparable<ItemOrder> {
    
    /** 
     * Field used to store a Item.
     */
    private Item myItem;
    
    /** 
     * Field used to store a integer for the order quantity.
     */
    private int myQuantity;

    
    /**
     * Constructor that creates an Item order for the assigned 
     * Item and quantity.
     * 
     * @param theItem the ordered Item.
     * @param theQuantity the integer for number of items. 
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        
        if (theQuantity < 0) {
            throw new IllegalArgumentException();
            
        } else {
            myItem = theItem;
            myQuantity = theQuantity;

        }
    }

    /**
     * Calculates the total amount for the Item order.
     * 
     * @return BigDecmial representation of the orders total.
     */
    public BigDecimal calculateOrderTotal() {
        
        return myItem.calculateItemTotal(myQuantity);
    }

    /**
     * Getter method for the Item field.
     * 
     * @return a copy of the item.
     */
    public Item getItem() {
       
        return myItem;
    }
    /**
     * Getter method for the quantity to field. 
     * 
     * @return a integer representation of the quantity.
     */
    public int getQuantity() {
        
        return myQuantity;
    }
    /**
     * Provides a String representation of information about the given ItemOrder
     * to include: Information from the Item class, quantity, and total price.
     * 
     * @return a string contains information about the ItemOrder.
     */
    @Override
    public String toString() {
        final StringBuilder orderInfoSB = new StringBuilder();
        orderInfoSB.append(myItem.toString());
        orderInfoSB.append("Number of Items ordered: ");
        orderInfoSB.append(myQuantity);
        orderInfoSB.append(" Total = $");
        orderInfoSB.append(calculateOrderTotal());
        final String orderInfo = orderInfoSB.toString();
        
        return orderInfo;
    }
    /**
     * Determines that ItemOrder objects will be compared by the Item field 
     * when sorting is required.
     * 
     * returns an integer value for comparison of ItemOrders.
     */
    @Override
    public int compareTo(final ItemOrder theOther) {
 
        return this.getItem().compareTo(theOther.getItem());
    }

}
