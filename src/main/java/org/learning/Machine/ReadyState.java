package org.learning.Machine;

import org.learning.Machine.MachineActions.VendingMachineStateActions;
import org.learning.Money.Coin;
import org.learning.Money.Note;

public class ReadyState implements VendingMachineStateActions {


    @Override
    public void initialiseState(VendingMachine vendingMachine) {
        System.out.println("Please select a product");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int id) {
        if (vendingMachine.isProductAvailable(id)) {
            vendingMachine.addProductToOrder(id);
        }
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Please place the order to make payments");
    }

    @Override
    public void insertNote(VendingMachine vendingMachine, Note note) {
        System.out.println("Please place the order to make payments");
    }

    @Override
    public void placeOrder(VendingMachine vendingMachine) {
        vendingMachine.setMachineState(VendingMachineState.PAYMENT_STATE);
        System.out.println("Order Placed, please make payments");
    }

    @Override
    public void dispenseProducts(VendingMachine vendingMachine) {
        System.out.println("Please place order and complete payment");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        System.out.println("No change to return, Please place a order and complete payment.");
    }
}
