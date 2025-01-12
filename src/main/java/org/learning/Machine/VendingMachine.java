package org.learning.Machine;

import org.learning.Money.Coin;
import org.learning.Money.Note;
import org.learning.Machine.MachineActions.UserActions;

import java.util.Map;

public class VendingMachine implements UserActions {

    private Inventory inventory;
    private Order order;
    private VendingMachineState currentState;
    private int paymentAmount;
    private VendingMachine() {
        this.inventory = new Inventory();
        this.currentState = VendingMachineState.IDLE_STATE;
        this.paymentAmount = 0;
        currentState.getVendingMachineStateActions().initialiseState(this);
    }
    private static class VendingMachineHelper {
        private static final VendingMachine instance = new VendingMachine();
    }

    @Override
    public void selectProduct(int productId) {
        if (currentState == VendingMachineState.READY_STATE) {
            currentState.getVendingMachineStateActions().selectProduct(this, productId);
        } else {
            System.out.println("Action not supported from current state " + currentState.name());
        }
    }

    @Override
    public void placeOrder() {
        if (currentState == VendingMachineState.READY_STATE) {
            currentState.getVendingMachineStateActions().placeOrder(this);
        } else {
            System.out.println("Action not supported from current state " + currentState.name());
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        if (currentState == VendingMachineState.PAYMENT_STATE) {
            currentState.getVendingMachineStateActions().insertCoin(this, coin);
        } else {
            System.out.println("Action not supported from current state " + currentState.name());
        }
    }

    @Override
    public void insertNote(Note note) {
        if (currentState == VendingMachineState.PAYMENT_STATE) {
            currentState.getVendingMachineStateActions().insertNote(this, note);
        } else {
            System.out.println("Action not supported from current state " + currentState.name());
        }
    }

    public static VendingMachine getInstance() {
        return VendingMachineHelper.instance;
    }

    public void displayProducts() {
        inventory.displayAvailableProducts();
    }

    boolean isProductAvailable(int id) {
        return inventory.isProductAvailable(id);
    }

    protected void initialiseMachine() {
        if (currentState == VendingMachineState.IDLE_STATE) {
            order = new Order();
        }
    }

    protected void setMachineState(VendingMachineState state) {
        currentState = state;
    }

    protected void addProductToOrder(int id) {
        if (currentState == VendingMachineState.READY_STATE) {
            order.addToOrder(id, inventory.getProductDetails(id));
        } else {
            System.out.println("Action not supported from current state " + currentState.name());
        }
    }

    protected void checkPaymentStatus() {
        if (currentState == VendingMachineState.PAYMENT_STATE) {
            if (paymentAmount >= order.getTotalAmount()) {
                currentState = VendingMachineState.DISPENSE_STATE;
                currentState.getVendingMachineStateActions().dispenseProducts(this);
            }
        } else {
            System.out.println("Action not supported from current state " + currentState.name());
        }
    }

    protected void addCoin(Coin coin) {
        if (currentState == VendingMachineState.PAYMENT_STATE) {
            paymentAmount += coin.getValue();
        } else {
            System.out.println("Action not supported from current state " + currentState.name());
        }
    }

    protected void addNote(Note note) {
        if (currentState == VendingMachineState.PAYMENT_STATE) {
            paymentAmount += note.getValue();
        } else {
            System.out.println("Action not supported from current state " + currentState.name());
        }
    }

    protected void updateInventoryStock(int id, int quantity) {
        if (currentState == VendingMachineState.DISPENSE_STATE) {
            inventory.updateStock(id, quantity);
        } else {
            System.out.println("Action not supported from current state " + currentState.name());
        }
    }

    protected Map<Integer, Integer> getOrders() {
        return order.getOrderMap();
    }

    protected Product getProductDetails(int productId) {
        return inventory.getProductDetails(productId);
    }

    protected int getPaymentAmount() {
        return paymentAmount;
    }

    protected int getOrderAmount() {
        return order.getTotalAmount();
    }

    protected void resetStateMachine() {
        currentState = VendingMachineState.IDLE_STATE;
        paymentAmount = 0;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
