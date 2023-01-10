package builder_joushua_bloch;


class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int carbs;
    private final int sodium;

    public static class Builder {
        // Required parameters are marked final
        private final int servingSize;
        private final int servings;
        public int calories = 0;
        public int fat = 0;
        public int sodium = 0;
        public int carbs = 0;
        public Builder(int servingSize, int servings) {
            this.servings = servings;
            this.servingSize = servingSize;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = fat;
            return this;
        }

        public Builder carbs(int val) {
            carbs = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }
    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servingSize;
        fat = builder.fat;
        carbs = builder.carbs;
        calories = builder.calories;
        sodium = builder.calories;
    }

    public int getFat() {
        return this.fat;
    }

    public int getCarbs() {
        return this.carbs;
    }
}
public class Nutrition {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).carbs(25).sodium(10).build();
        System.out.println(cocaCola.getFat());
        System.out.println(cocaCola.getCarbs());
    }
}
