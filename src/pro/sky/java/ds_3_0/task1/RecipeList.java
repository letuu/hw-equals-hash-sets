package pro.sky.java.ds_3_0.task1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RecipeList {

    private final Set<Recipe> recipes = new HashSet<>();

    public void addRecipe(Recipe recipe) {
        if (recipe == null) {
            return;
        }
        if (recipes.contains(recipe)) {
            throw new ProductException("Рецепт '" + recipe.getName() + "' уже существует");
        } else {
            recipes.add(recipe);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeList that = (RecipeList) o;
        return Objects.equals(recipes, that.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipes);
    }

    @Override
    public String toString() {
        return "RecipeList{" +
                "recipes=" + recipes +
                '}';
    }
}
