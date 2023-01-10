package builder_joushua_bloch;


import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

abstract class Pizza {
    public enum Topping {
        HAM,
        MUSHROOM,
        ONION,
        PAPER,
        SAUSAGE,
    }

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

}


class NyPizza extends Pizza {
    public enum Size {
        SMALL, MEDIUM, LARGE
    }
    private final Size size;
    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;
        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }


    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
public class PizzaTest {

    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.LARGE).addTopping(Pizza.Topping.MUSHROOM).build();
//        System.out.println(pizza);
        System.out.println(pizza.toppings);

    }
}
