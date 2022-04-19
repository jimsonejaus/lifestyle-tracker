public class Food extends java.lang.Object {

    private double calories;
    private String name;
    
    //This constructor initializes the object with the parameters of the food name and calories from input.
    public Food(java.lang.String f, double c){
        calories = c;
        name = f;
    }

    //This returns the Food calorie value/serving.
    public double getFoodCalories(){
        return calories;
    }

    //This returns the Food name.
    public java.lang.String getFoodName(){
        return name;
    }

    //This updates the calorie value/serving of the Food.
    public void	updateCalories(double c){
        calories = c;
    }
}