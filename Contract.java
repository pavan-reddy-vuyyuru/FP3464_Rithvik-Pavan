abstract class Contract {
    public int accumulatedDays;
    public double monthlySalary;

    abstract double calculateSalary();
    abstract String contractInfoFrom();
    Employee employee;

    abstract double monthlyIncome();
}

// Permanent contract class
class Permanent extends Contract {
    int numberOfChildren;
    boolean married;
    double monthlySalary, bonusPerChildPerMonth;
    public double getMonthlySalary() {
        return monthlySalary;
    }
    int accumulatedDays;

    Permanent(int numberOfChildren, boolean married, double monthlySalary, double bonusPerChildPerMonth, int accumulatedDays) {
        this.numberOfChildren = numberOfChildren;
        this.married = married;
        this.monthlySalary = monthlySalary;
        this.bonusPerChildPerMonth = bonusPerChildPerMonth;
        this.accumulatedDays = accumulatedDays;
    }
    public String hasMarried(){
        if(married){
            return "Married";
        }
        else{
            return "Not married";
        }
    }
    @Override
    double monthlyIncome() {
        if(hasMarried().equals("Married")){
            return ((this.monthlySalary +(bonusPerChildPerMonth * numberOfChildren))*((double) accumulatedDays)/20 );
        }else{
            return((this.monthlySalary) * (((double) accumulatedDays)/20));
        }
    }
    public double calculateSalary() {
        return monthlySalary + (bonusPerChildPerMonth * numberOfChildren);
    }
    public String contractInfoFrom() {
        return String.format("He is %s and has %s children He/She has worked for %d days and upon contract his/her monthly salary is %.2f.%n",
                hasMarried(),numberOfChildren,accumulatedDays, monthlySalary);
    }
}

// Temporary contract class
class Temporary extends Contract {
    double hourlySalary, accumulatedHours;

    Temporary(double hourlySalary, double accumulatedHours) {
        this.hourlySalary = hourlySalary;
        this.accumulatedHours = accumulatedHours;
    }
    public double calculateSalary() {
        return hourlySalary * accumulatedHours;
    }
    @Override
    double monthlyIncome() {

        return(hourlySalary * accumulatedHours);

    }
    public String contractInfoFrom() {
        return String.format("He/She is a temporary employee with %.1f hourly salary and has worked for %.0f hours%n",
                hourlySalary, accumulatedHours);
    }
}
