package pro.sky.java.ds_3_0.task3_1;

import java.util.ArrayDeque;
import java.util.Queue;

public class ServiceStation {

    private final Queue<Transport> serviceQueue = new ArrayDeque<>();

    private void addAutoQueue(Transport transport) {
        serviceQueue.offer(transport);
    }

    public void addCarQueue(Car car) {
        addAutoQueue(car);
    }

    public void addTruckQueue(Truck truck) {
        addAutoQueue(truck);
    }

    public void doAutoService() {
        if (!serviceQueue.isEmpty()) {
            Transport transport = serviceQueue.poll();
            if (!transport.passDiagnostics()) {
                transport.repair();
            }
        }
    }
}
