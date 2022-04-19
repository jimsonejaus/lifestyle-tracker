import java.util.*;

public class LifestyleTracker extends java.lang.Object {
    
    private ArrayList<Activity> activityList;
    private ArrayList<Food> foodList;
    private ArrayList<java.lang.String> activityReport;
    private ArrayList<java.lang.String> foodReport;
    private ArrayList<Double> foodC;
    private ArrayList<Double> activityC;
    private double totalFoodC;
    private double totalActivityC;
    private double kcal;
        
    //This constructor initializs the LifestyleTracker object.
    public LifestyleTracker(){
        activityList = new ArrayList<Activity>();
        foodList = new ArrayList<Food>();
        activityReport = new ArrayList<java.lang.String>();
        foodReport = new ArrayList<java.lang.String>();
        foodC = new ArrayList<Double>();
        activityC = new ArrayList<Double>();
        totalActivityC = 0.0;
        totalFoodC = 0.0;
        kcal = 0.00012959782;
    }

    /* addActivivty method takes a name and calorie value and creates an Activity object inside an ArrayList.
    If the name already exists, it only updates the calorie value. */
    public java.lang.String addActivity(java.lang.String n, double c){
        java.lang.String s = "";
        int exist = 0;
        int location = 0;
        for (int i = 0; i < activityList.size(); i++){
            if (n.equals(activityList.get(i).getActivityName())){
                exist+=1;
                location = i;
            }
        }
        
        if (exist != 0){
            activityList.get(location).updateCalories(c);
        } else {
            activityList.add(new Activity(n, c));
            s+= String.format("Added Activity %s with %.2f kcal.",n,c);
        }
        
        return (s);
    }

    /* addFood method takes a name and calorie value and creates an Food object inside an ArrayList.
    If the name already exists, it only updates the calorie value. */
    public java.lang.String addFood(java.lang.String n, double c){
        java.lang.String s = "";
        int exist = 0;
        int location = 0;
        for (int i = 0; i < foodList.size(); i++){
            if (n.equals(foodList.get(i).getFoodName())){
                exist += 1;
                location = i;
            }
        }
        
    
        if (exist != 0){
            foodList.get(location).updateCalories(c);
            s+= String.format("Updated Food %s with %.2f kcal.",n,c);
        } else {
            foodList.add(new Food(n, c));
            s+= String.format("Added Food %s with %.2f kcal.",n,c);
        }
        
        return (s);
        }

    /* eat method takes a name and value of servings, checks if the food exists in the Food objects'
    ArrayList, if it does, it creates a string view record and report, and adds it to the report
    ArrayList with its corresponding calorie value, if the food doesn't exist, it asks the user if they 
    want to add a new Food object.*/
    public java.lang.String eat(java.lang.String fn, double servings){
        java.lang.String r = "";
        java.lang.String s = "";
        double cal = 0;

        r = "";
        s = "";
        cal = 0;

        if (servings<0.00){
            return("Number of servings cannot be negative.");
        } else {
        int exist = 0;
        int location = 0;
        for (int i = 0; i < foodList.size(); i++){
            if (fn.equals(foodList.get(i).getFoodName())){
                exist+=1;
                location = i;
                break;
            }
        }
        if (exist != 0){

            r += String.format("%.2f serving(s) of %s, %.2f kcal.\n", servings, fn,foodList.get(location).getFoodCalories()*servings);
            foodReport.add(r);
            s += String.format("Ate %.2f serving(s) of %s, %.2f kcal.", servings, fn,foodList.get(location).getFoodCalories()*servings);
            cal = foodList.get(location).getFoodCalories()*servings;
            foodC.add(cal);
            
        } else {
            s += "Option";
        }
        }
        return (s);
    }

    /* perform method takes a name and value of hours, checks if the activity exists in the Activity objects'
    ArrayList, if it does, it creates a string view record and report, and adds it to the report
    ArrayList with its corresponding calorie value, if the activity doesn't exist, it asks the user if they 
    want to add a new Activity object.*/
    public java.lang.String perform(java.lang.String act,double hours){
        java.lang.String r = "";
        java.lang.String s = "";
        double cal = 0;

        r = "";
        s = "";
        cal = 0;

        if (hours<0.00){
            return("Number of hours cannot be negative.");
        } else {
        int exist = 0;
        int location = 0;
        for (int i = 0; i < activityList.size(); i++){
            if (act.equals(activityList.get(i).getActivityName())){
                exist+=1;
                location = i;
                break;
            }
        }
        if (exist != 0){

            r += String.format("%.2f hour(s) of %s, %.2f kcal\n", hours,act,activityList.get(location).getActivityCalories()*hours);
            activityReport.add(r);
            s += String.format("Performed %.2f hour(s) of %s, %.2f kcal", hours,act,activityList.get(location).getActivityCalories()*hours);
            cal = activityList.get(location).getActivityCalories()*hours;
            activityC.add(cal);

        } else {
            s += "Option";
        }
        }
        return (s);
    }

    //This returns a string value of the report.
    public java.lang.String report(){

        totalActivityC = 0;
        totalFoodC = 0;
        java.lang.String loseOrGain = "";

        for (int i = 0; i < foodC.size();i++){
            totalFoodC += foodC.get(i);
        }
        for (int i = 0; i < activityC.size();i++){
            totalActivityC += activityC.get(i);
        }
        java.lang.String reportString = "";
        reportString += "----------------\nLIFESTYLE REPORT\n----------------\nFood Consumed:\n";
        for (int i = 0; i < foodReport.size(); i++){
            reportString += foodReport.get(i);
        }
        reportString += String.format("----------------\nTotal Calories Consumed: %.2f kcal\n----------------\nActivities Performed:\n", totalFoodC);
        for (int i = 0; i < activityReport.size(); i++){
            reportString += activityReport.get(i);
        }
        reportString += String.format("----------------\nTotal Calories Burned: %.2f kcal\n----------------\n", totalActivityC);
        if (totalFoodC-totalActivityC>0){
            loseOrGain = "gain";
            reportString += String.format("Net Calories for the Day: %.2f kcal\nIf you keep up this lifestyle...\n", totalFoodC-totalActivityC);
            reportString += String.format("In a week, you will %s %.2f kilograms.\nIn a month, you will %s %.2f kilograms.\nIn 3 months, you will %s %.2f kilograms.\nIn 6 months, you will %s %.2f kilograms.\n----------------\n", loseOrGain,7*(totalFoodC-totalActivityC)*kcal,loseOrGain,30*(totalFoodC-totalActivityC)*kcal,loseOrGain,90*(totalFoodC-totalActivityC)*kcal,loseOrGain,180*(totalFoodC-totalActivityC)*kcal);
        } else {
            loseOrGain = "lose";
            reportString += String.format("Net Calories for the Day: %.2f kcal\nIf you keep up this lifestyle...\n", totalFoodC-totalActivityC);
            reportString += String.format("In a week, you will %s %.2f kilograms.\nIn a month, you will %s %.2f kilograms.\nIn 3 months, you will %s %.2f kilograms.\nIn 6 months, you will %s %.2f kilograms.\n----------------\n", loseOrGain,7*(totalActivityC-totalFoodC)*kcal,loseOrGain,30*(totalActivityC-totalFoodC)*kcal,loseOrGain,90*(totalActivityC-totalFoodC)*kcal,loseOrGain,180*(totalActivityC-totalFoodC)*kcal);
        }

        return (reportString);
    }
    
    //This returns a string value of the food records.
    public java.lang.String foodView(){
        java.lang.String s =  "";
        s += "----------------\nFOOD RECORD\n----------------\n";
        for (int i = 0; i < foodReport.size(); i++){
            s += String.format("%d ", i);
            s += foodReport.get(i);
        } 
        return (s);
    }

    //This returns a string value of the activity records.
    public java.lang.String activityView(){
        java.lang.String s =  "";
        s += "----------------\nACTIVITY RECORD\n----------------\n";
        for (int i = 0; i < activityReport.size(); i++){
            s += String.format("%d ", i);
            s += activityReport.get(i);
        } 
        return (s);
    }

    //This edits an existing record of a food/activity.
    public java.lang.String edit(int i, java.lang.String s, java.lang.String fnOrAct, double servingsOrHours){
        java.lang.String r = "";
        java.lang.String st = "";
        int location2 = 0;
        
        if (s.equals("Eat")){

            for (int finder = 0; finder < foodList.size(); finder++){
                if (fnOrAct.equals(foodList.get(finder).getFoodName())){
                    location2 = finder;
                }
            }

            r += String.format("%.2f serving(s) of %s, %.2f kcal.\n", servingsOrHours, fnOrAct,foodList.get(location2).getFoodCalories()*servingsOrHours);
            foodReport.set(i,r);
            st += String.format("Ate %.2f serving(s) of %s, %.2f kcal.\n", servingsOrHours, fnOrAct,foodList.get(location2).getFoodCalories()*servingsOrHours);
            foodC.set(i,foodList.get(location2).getFoodCalories()*servingsOrHours);
            
            
            
        } else if (s.equals("Do")){


            for (int finder = 0; finder < activityList.size(); finder++){
                if (fnOrAct.equals(activityList.get(finder).getActivityName())){
                    location2 = finder;
                }
            }

            r += String.format("%.2f hour(s) of %s, %.2f kcal\n", servingsOrHours, fnOrAct,activityList.get(location2).getActivityCalories()*servingsOrHours);
            activityReport.set(i,r);
            st += String.format("Performed %.2f hour(s) of %s, %.2f kcal\n", servingsOrHours, fnOrAct,activityList.get(location2).getActivityCalories()*servingsOrHours);
            activityC.set(i,activityList.get(location2).getActivityCalories()*servingsOrHours);
            

        }
        
        return (st);
    }

    //This deletes an existing record of a food/activity.
    public java.lang.String delete(int i, java.lang.String foodOrAct){
        java.lang.String s = "";
        if (foodOrAct.equals("Food")){
            foodReport.remove(i);
            foodC.remove(i);
            s += String.format("Food Index %d deleted.",i);

        } else if (foodOrAct.equals("Activity")){
            activityReport.remove(i);
            activityC.remove(i);
            s += String.format("Activity Index %d deleted.",i);

        }
        return (s);
    }
}
