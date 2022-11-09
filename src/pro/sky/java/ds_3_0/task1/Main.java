package pro.sky.java.ds_3_0.task1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Product milk = new Product("Молоко", 70f, 3);
        Product apple = new Product("Яблоко", 80f, 2);
        Product potato = new Product("Картофель", 30f, 5);
        Product tomato = new Product("Помидор", 75f, 1);

        ProductList list1 = new ProductList();

        list1.addProduct(milk);
        list1.addProduct(apple);
        list1.addProduct(potato);
        list1.addProduct(tomato);

        System.out.println(list1);

        Product appleGreen = new Product("Яблоко зеленое", 90f, 4);
        Product apple2 = new Product("Яблоко", 100f, 1);

        list1.addProduct(appleGreen);
//        list1.addProduct(apple2);    //Выбрасывается исключение - продукт уже добавлен
        list1.removeProductName("Яблоко");
        list1.removeProduct(tomato);
        list1.buyProduct("Молоко");
        list1.buyProduct("Картофель");

        System.out.println(list1);

        // Задание 2-1 Множество рецептов
        System.out.println("Задание 2-1 Множество рецептов ///////////////////////////////////////////////");
        System.out.println();

        Recipe recipe1 = new Recipe("Recipe1", Set.of(potato, tomato));
        Recipe recipe2 = new Recipe("Recipe2", Set.of(potato, tomato, apple));
        Recipe recipe3 = new Recipe("Recipe3", Set.of(potato, tomato, apple2));

        //Исключение - IllegalArgumentException - duplicate element:
//        Recipe recipe4 = new Recipe("Recipe3", Set.of(potato, tomato, apple, tomato));

        Recipe recipeDoubleName = new Recipe("Recipe1", Set.of(potato, tomato, milk));
        Recipe recipeDoubleList = new Recipe("Recipe4", Set.of(potato, tomato));

        System.out.println(recipe1);
        System.out.println(recipe2);
        System.out.println(recipe3);
        System.out.println(recipeDoubleName);
        System.out.println(recipeDoubleList);
        System.out.println();

        RecipeList recipeList = new RecipeList();

        recipeList.addRecipe(recipe1);
        recipeList.addRecipe(recipe2);
        recipeList.addRecipe(recipe3);
//        recipeList.addRecipe(recipeDoubleName); //Исключение - Рецепт 'Recipe1' уже существует
        recipeList.addRecipe(recipeDoubleList); //Нет исключения - список одинаковый, имена разные

        System.out.println(recipeList);

        // Задание 2-2 Множество целых чисел
        System.out.println("\nЗадание 2-2 Множество целых чисел ///////////////////////////////////////////////");

        numberSet();
    }

    private static void numberSet() {

        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();
//        while (numbers.size() < 20) { //так можно и так точно будет 20 элементов
        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(1000));
        }
        System.out.println(numbers);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) { //пока не переберем весь HashSet - пока следующего элемента не будет
            Integer next = iterator.next();
            if (next % 2 != 0) {
                iterator.remove();
            }
        }
        System.out.println(numbers);
    }
}
