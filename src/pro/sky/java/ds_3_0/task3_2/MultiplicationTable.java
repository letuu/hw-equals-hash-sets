package pro.sky.java.ds_3_0.task3_2;

import pro.sky.java.ds_3_0.task1.Product;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MultiplicationTable {

    private Set<Task> tasks = new HashSet<>();

    public MultiplicationTable() {
        Random random = new Random();
        while (tasks.size() < 15) {
            tasks.add(new Task((random.nextInt(8) + 2), (random.nextInt(8) + 2)));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Таблица умножения  - задачи для 15 человек:").append('\n');
        for (Task task : this.tasks) {
            stringBuilder.append(task).append("\n");
        }
        return stringBuilder.toString();
    }
}
