package org.learning.Machine;

import org.learning.Machine.MachineActions.VendingMachineStateActions;
import org.learning.Money.Coin;
import org.learning.Money.Note;

public class PaymentState implements VendingMachineStateActions {

    @Override
    public void initialiseState(VendingMachine vendingMachine) {
        System.out.println("Please complete the payment");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int id) {
        System.out.println("Please complete the payment");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        vendingMachine.addCoin(coin);
        vendingMachine.checkPaymentStatus();
    }

    @Override
    public void insertNote(VendingMachine vendingMachine, Note note) {
        vendingMachine.addNote(note);
        vendingMachine.checkPaymentStatus();
    }

    @Override
    public void placeOrder(VendingMachine vendingMachine) {
        System.out.println("Please complete the payment");
    }

    @Override
    public void dispenseProducts(VendingMachine vendingMachine) {
        System.out.println("Please complete the payment");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        System.out.println("No change to return, Please complete the payment");
    }

}
