package org.learning.Machine;

import org.learning.Machine.MachineActions.VendingMachineStateActions;
import org.learning.Money.Coin;
import org.learning.Money.Note;

import java.util.Map;

public class DispenseState implements VendingMachineStateActions {

    @Override
    public void initialiseState(VendingMachine vendingMachine) {
        System.out.println("Please collect the dispensed products");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int id) {
        System.out.println("Please collect the dispensed products");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Please collect the dispensed products");
    }

    @Override
    public void insertNote(VendingMachine vendingMachine, Note note) {
        System.out.println("Please collect the dispensed products");
    }

    @Override
    public void placeOrder(VendingMachine vendingMachine) {
        System.out.println("Please collect the dispensed products");
    }

    @Override
    public void dispenseProducts(VendingMachine vendingMachine) {
        Map<Integer, Integer> orders = vendingMachine.getOrders();
        for (Map.Entry<Integer, Integer> entry: orders.entrySet()) {
            System.out.println("Dispensing...");
            vendingMachine.updateInventoryStock(entry.getKey(), entry.getValue());
            System.out.println("Product " + vendingMachine.getProductDetails(
                    entry.getKey()
            ).getName() + " Dispensed, please collect..");
        }
        returnChange(vendingMachine);
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        int change = vendingMachine.getPaymentAmount() - vendingMachine.getOrderAmount();
        if (change > 0) {
            System.out.println("Change Rs. " + change + " returned, please collect");
        } else {
            System.out.println("No change to return");
        }
        vendingMachine.resetStateMachine();
    }
}
