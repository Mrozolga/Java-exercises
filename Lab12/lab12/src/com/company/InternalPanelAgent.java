package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InternalPanelAgent extends Thread {
    static class InternalCall {
        private final int toFloor;

        InternalCall(int toFloor) {
            this.toFloor = toFloor;
        }
    }

    InternalPanelAgent(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
    }

    BlockingQueue<InternalCall> input = new ArrayBlockingQueue<>(100);
    ElevatorCar elevatorCar;

    public void run() {
        for (; ; ) {
            InternalCall ec = null;
            try {
                ec = ec = input.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ec.toFloor == elevatorCar.getFloor()) continue;
            // dodajemy do jednej z tablic zgłoszeń
            if (ec.toFloor > elevatorCar.getFloor()) {
                ElevatorStops.get().hasStopAbove(ec.toFloor);
            }
            if (ec.toFloor < elevatorCar.getFloor()) {
                ElevatorStops.get().hasStopBelow(ec.toFloor);
            }
        }

    }
}