public class Activity extends java.lang.Object {

    private double calories;
    private String name;
    
    // This constructor initializes the object with the parameters of the activity name and calories from input.
    public Activity(java.lang.String n, double c){
        calories = c;
        name = n;
    }

    //This method returns the Activity Name.
    public java.lang.String getActivityName(){
        return name;
    }

    //This methid returns the Activity calories.
    public double getActivityCalories() {
        return calories;
    }

    //This method updates the calorie value of the Activity.
    public void updateCalories(double c){
        calories = c;
    }
}