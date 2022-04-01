public abstract class Coin {
    /**
     * abstract method
     * @return value of coin
     */
    public abstract double getValue();
    /**
     * abstract method
     * @return name of coin
     */
    public abstract String getName();
    /**
     * creates a plural name for the name of the coin
     */
    public String getPluralName(){
        if(getName().equals("penny"))
            return "pennies";
        else
            return getName() + "s";
    }
}
