package org.learning.Machine;

import org.learning.Machine.MachineActions.VendingMachineStateActions;
import org.learning.Money.Coin;
import org.learning.Money.Note;

public class IdleState implements VendingMachineStateActions {

    @Override
    public void initialiseState(VendingMachine vendingMachine) {
        vendingMachine.initialiseMachine();
        vendingMachine.setMachineState(VendingMachineState.READY_STATE);
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int id) {
        System.out.println("Please wait for the machine to load.");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Please place a order to make payments.");
    }

    @Override
    public void insertNote(VendingMachine vendingMachine, Note note) {
        System.out.println("Please place a order to make payments.");
    }

    @Override
    public void placeOrder(VendingMachine vendingMachine) {
        System.out.println("Please select a product to place order.");
    }

    @Override
    public void dispenseProducts(VendingMachine vendingMachine) {
        System.out.println("Please select a product and complete payment.");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        System.out.println("No change to return, Please select a product and complete payment.");
    }
}
