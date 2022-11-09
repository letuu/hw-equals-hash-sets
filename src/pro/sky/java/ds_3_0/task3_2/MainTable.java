package pro.sky.java.ds_3_0.task3_2;

import java.util.HashSet;
import java.util.Set;

public class MainTable {
    public static void main(String[] args) {

        MultiplicationTable multiplicationTable = new MultiplicationTable();

        System.out.println(multiplicationTable);

        Task task1 = new Task(1, 2);
        Task task2 = new Task(1, 1);
        Task task3 = new Task(2, 1);
        System.out.println(task1.equals(task3));
        //элементы равны, но хешкод у них разный, так как разная последовательность value1 и value2

        Set<Task> tasks = new HashSet<>();
        tasks.add(task1);
        tasks.add(task3);
        System.out.println(tasks);
    }
}
