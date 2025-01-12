package org.learning.Machine;

import org.learning.Machine.MachineActions.VendingMachineStateActions;

public enum VendingMachineState {

    IDLE_STATE(new IdleState()),
    READY_STATE(new ReadyState()),
    PAYMENT_STATE(new PaymentState()),
    DISPENSE_STATE(new DispenseState());

    private final VendingMachineStateActions vendingMachineStateActions;

    VendingMachineState(VendingMachineStateActions vendingMachineStateActions) {
        this.vendingMachineStateActions = vendingMachineStateActions;
    }

    public VendingMachineStateActions getVendingMachineStateActions() {
        return vendingMachineStateActions;
    }
}
