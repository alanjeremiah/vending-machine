package org.learning.Machine.MachineActions;

import org.learning.Money.Coin;
import org.learning.Money.Note;

public interface UserActions {

    void selectProduct(int productId);
    void placeOrder();
    void insertCoin(Coin coin);
    void insertNote(Note note);
}
