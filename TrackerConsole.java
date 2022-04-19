import java.util.Scanner;

public class TrackerConsole extends java.lang.Object {

    public TrackerConsole(){}
    public static void main(String[] args) {
        LifestyleTracker Jimson = new LifestyleTracker();

        java.lang.String firstLine = "";
        
        Scanner in = new Scanner (System.in); 
        
        while (true){
            firstLine = in.next();
            if (firstLine.equals("quit")){
                break;
            } if(firstLine.equals("Food")){
                System.out.println(Jimson.addFood(in.next(), in.nextDouble()));
            } else if (firstLine.equals("Activity")){
                System.out.println(Jimson.addActivity(in.next(), in.nextDouble()));
            } else if (firstLine.equals("Eat")){
                java.lang.String food = "";
                double quantity = 0;
                java.lang.String output = "";
                
                food = in.next();
                quantity = in.nextDouble();
                output = Jimson.eat(food, quantity);
                

                if (output.equals("Option")){
                    System.out.printf("Do you want to add %s to the list of foods? Please answer with Yes or No.\n",food);
                    if (in.next().equals("Yes")){
                        System.out.println("Please input the amount of calories per serving.");
                        System.out.println(Jimson.addFood(food, in.nextDouble()));
                        System.out.println(Jimson.eat(food, quantity));
                    } else {
                        System.out.println("The specified food does not exist.");
                    }
                } else {
                    System.out.println(output);
                }
            } else if (firstLine.equals("Do")){
                java.lang.String act = "";
                double time = 0;
                java.lang.String output = "";
                
                act = in.next();
                time = in.nextDouble();
                output = Jimson.perform(act, time);
                

                if (output.equals("Option")){
                    System.out.printf("Do you want to add %s to the list of activities? Please answer with Yes or No.\n",act);
                    if (in.next().equals("Yes")){
                        System.out.println("Please input the amount of burned calories per hour.");
                        System.out.println(Jimson.addActivity(act, in.nextDouble()));
                        System.out.println(Jimson.perform(act, time));
                    } else {
                        System.out.println("The specified activity does not exist.");
                    }
                } else {
                    System.out.println(output);
                }
            } else if (firstLine.equals("Report")){
                System.out.print(Jimson.report());
            } else if (firstLine.equals("View")){
                java.lang.String foodOrActivity = in.next();
                
                if (foodOrActivity.equals("Food")){
                    System.out.print(Jimson.foodView());
                    System.out.println("Edit, Delete, or Cancel?"); 
                } else if (foodOrActivity.equals("Activity")){
                    System.out.print(Jimson.activityView());
                    System.out.println("Edit, Delete, or Cancel?");
                }

                java.lang.String action = in.next();
                if (action.equals("Cancel")){
                    System.out.println("Operation Cancelled.");
                    continue;
                }
                int location = in.nextInt();

                if (foodOrActivity.equals("Food")){
                    if (action.equals("Edit")){
                        java.lang.String s = "";
                        java.lang.String fnOrAct = "";
                        double servingsOrHours = 0.0;
                        
                        System.out.printf("Editing Food Index %d.\n",location);
                        s = in.next();
                        fnOrAct = in.next();
                        servingsOrHours = in.nextDouble();

                        System.out.print(Jimson.edit(location, s, fnOrAct, servingsOrHours));
                    } else if (action.equals("Delete")){
                        System.out.println(Jimson.delete(location,foodOrActivity));
                    }
                    
                    
                } else if (foodOrActivity.equals("Activity")){
                    if (action.equals("Edit")){
                        java.lang.String s = "";
                        java.lang.String fnOrAct = "";
                        double servingsOrHours = 0.0;
                        
                        System.out.printf("Editing Activity Index %d.\n",location);
                        s = in.next();
                        fnOrAct = in.next();
                        servingsOrHours = in.nextDouble();

                        System.out.print(Jimson.edit(location, s, fnOrAct, servingsOrHours));
                    } else if (action.equals("Delete")){
                        System.out.println(Jimson.delete(location,foodOrActivity));
                    }

                }
            }
        }
        in.close();
    }
}