/*
 * Assignment - 2
 * 
 * TCSS 305 Autumn 2015
 */
package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/**
 * A ShoppingCart object stores information about the total purchase information for 
 * current orders.
 * 
 * @author Jeremy Wolf email: jwolf059@uw.edu
 * @version 15 October 2015
 */
public class ShoppingCart {
    
    /** Constant for the percent given to members.*/
    private static final BigDecimal DISCOUNTPRECENT = new BigDecimal("0.10"); 
    
    /** Field for a Set of ItemOrders. */
    private final Set<ItemOrder> myShoppingCart;
    
    /** Field to store if the customer is a member.*/
    private boolean myMembership;

    /**
     * Constructor for the ShoppingCart Class. The constructor instantiates a TreeSet
     * of ItemOrders and sets the membership to a default value of False.
     */
    public ShoppingCart() {
        
        myShoppingCart = new TreeSet<ItemOrder>();
        myMembership = false;
    }

    /**
     * Adds the ItemOrder to the TreeSet, but ensures that duplication does not happen 
     * by replacing the old ItemOrder with the new one.
     * 
     * @param theOrder the ItemOrder object to be added to the Shopping cart.
     */
    public void add(final ItemOrder theOrder) {
        
        if (myShoppingCart.contains(theOrder)) {
            myShoppingCart.remove(theOrder);
            myShoppingCart.add(theOrder); 
        } else {
            myShoppingCart.add(theOrder); 
        }

    }

    /**
     * Determines if a customer has a membership and if this is true they receive a 
     * discount.
     * 
     * @param theMembership boolean representing customer membership. 
     */
    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
    }

    /**
     * Calculates the total for the entire shopping cart. If myMembership is true, all 
     * ItemOrders that do not have a bulk discount available will receive a discount.
     * 
     * @return the total cost of all ItemOrders.
     */
    public BigDecimal calculateTotal() {
        ItemOrder newItemForTotal;
        final BigDecimal discountPercent = DISCOUNTPRECENT;
        BigDecimal itemTotal = new BigDecimal("0.00");
        final Iterator<ItemOrder> itemITR = myShoppingCart.iterator();
        
        while (itemITR.hasNext()) {
            newItemForTotal = itemITR.next();
            if (myMembership && !(newItemForTotal.getItem()).isBulk()) {
                final BigDecimal total = newItemForTotal.calculateOrderTotal();
                final BigDecimal discount = discountPercent.multiply(total);           
                final BigDecimal dicountedTotal = total.subtract(discount);
                itemTotal = itemTotal.add(dicountedTotal);
            } else {
                itemTotal = itemTotal.add(newItemForTotal.calculateOrderTotal());  
            }
        } 
        return itemTotal.setScale(2, RoundingMode.HALF_EVEN);
    }
    
    /**
     * Clears all ItemOrders from the ShoppingCart.
     */
    public void clear() {
        myShoppingCart.clear();
    }
    /**
     * Generates a String representation of all ItemOrders in the current ShoppingCart.
     * 
     * @return a String contains information about the ShoppingCart.
     */
    @Override
    public String toString() {
        final StringBuilder cartStringSB = new StringBuilder();
        ItemOrder itemForString;
        final Iterator<ItemOrder> itemITR = myShoppingCart.iterator();
        while (itemITR.hasNext()) {
            itemForString = itemITR.next();
            cartStringSB.append(itemForString.toString());
            cartStringSB.append("\n");
        }
        return cartStringSB.toString();
    }
}
