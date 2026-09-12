package org.example.designpattern.builder;

public class PizzaOrder {
    private final String size;
    private final String crust;
    private final boolean cheese;
    private final boolean paneer;
    private final boolean olives;
    private final boolean extraSauce;

    private PizzaOrder(Builder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.cheese = builder.cheese;
        this.paneer = builder.paneer;
        this.olives = builder.olives;
        this.extraSauce = builder.extraSauce;
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "size='" + size + '\'' +
                ", crust='" + crust + '\'' +
                ", cheese=" + cheese +
                ", paneer=" + paneer +
                ", olives=" + olives +
                ", extraSauce=" + extraSauce +
                '}';
    }

    public static class Builder {
        private final String size;
        private String crust = "regular";
        private boolean cheese;
        private boolean paneer;
        private boolean olives;
        private boolean extraSauce;

        public Builder(String size) {
            this.size = size;
        }

        public Builder crust(String crust) {
            this.crust = crust;
            return this;
        }

        public Builder cheese() {
            this.cheese = true;
            return this;
        }

        public Builder paneer() {
            this.paneer = true;
            return this;
        }

        public Builder olives() {
            this.olives = true;
            return this;
        }

        public Builder extraSauce() {
            this.extraSauce = true;
            return this;
        }

        public PizzaOrder build() {
            return new PizzaOrder(this);
        }
    }
}
