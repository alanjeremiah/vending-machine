package org.learning.Machine.MachineActions;

import org.learning.Machine.VendingMachine;
import org.learning.Money.Coin;
import org.learning.Money.Note;

public interface VendingMachineStateActions {

    void initialiseState(VendingMachine vendingMachine);
    void selectProduct(VendingMachine vendingMachine, int id);
    void insertCoin(VendingMachine vendingMachine, Coin coin);
    void insertNote(VendingMachine vendingMachine, Note note);
    void placeOrder(VendingMachine vendingMachine);
    void dispenseProducts(VendingMachine vendingMachine);
    void returnChange(VendingMachine vendingMachine);
}
