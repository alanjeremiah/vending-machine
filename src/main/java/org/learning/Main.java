package org.learning;

import org.learning.Machine.Product;
import org.learning.Machine.VendingMachine;
import org.learning.Money.Note;

public class Main {
    public static void main(String[] args) {

        VendingMachine vendingMachine = VendingMachine.getInstance();
        vendingMachine.getInventory().addProduct(new Product(1, "Lays Cream & Onion", 20), 3);
        vendingMachine.getInventory().addProduct(new Product(2, "KitKat Crunch", 40), 3);
        vendingMachine.getInventory().addProduct(new Product(3, "Hershey's Chocolate Milkshake", 30), 2);

        vendingMachine.displayProducts();

        vendingMachine.selectProduct(1);
        vendingMachine.selectProduct(1);
        vendingMachine.selectProduct(3);


        vendingMachine.placeOrder();

        vendingMachine.insertNote(Note.HUNDRED_RUPEE);
        vendingMachine.displayProducts();
    }
}