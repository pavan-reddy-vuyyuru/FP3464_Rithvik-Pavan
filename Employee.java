abstract class Employee {


    String name;
    double rate;
    Contract contract;
    Vehicle vehicle;
    public double monthlyIncome;

    public Employee(String name, int birthYear, double rate, Vehicle vehicle) {
        this.name = name;
        this.birthYear = birthYear;
        this.rate = rate;
        this.vehicle =vehicle;
        System.out.println("We have a new employee: " + name+", a " + employeeType());
    }
    public Employee(String name, int birthYear, Vehicle vehicle) {
        this.name = name;
        this.birthYear = birthYear;
        this.vehicle = vehicle;
        this.rate = 100;
        System.out.println("We have a new employee: " + name +", a " + employeeType());
    }
    public Employee(String name, int birthYear, double rate, Contract contract, Vehicle vehicle){
        this.name = name;
        this.birthYear = birthYear;
        if (rate < 10.0) {
            this.rate = 10.0;
        } else if (rate > 100.0) {
            this.rate = 100.0;
        }
        this.contract = contract;
        this.vehicle = vehicle;
        System.out.println("We have a new employee: " + name +", a "+ employeeType());
    }
    public String getName() {
        return name;
    }
    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    int birthYear;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
    void signContract(Contract contract) {
        this.contract = contract;
        this.monthlyIncome = contract.monthlyIncome();
    }
    int calculateAge() {
        return java.time.Year.now().getValue() - birthYear;
    }
    double getMonthlyIncome() {
        return monthlyIncome;
    }
    abstract String employeeType();
    abstract String additionalInfo();

    @Override
    public String toString() {
        return String.format("Name: %s, a %s%nAge: %d%n%s %n %s",
                name,
                employeeType(),
                calculateAge(),
                vehicle.vehicleInfo(),
                additionalInfo());
    }
    public String contractInfo() {
        return String.format("%n%s is a %s . %s",name,employeeType(),contract.contractInfoFrom());
    }
}

// Manager class
class Manager extends Employee {
    int nbClients, nbTravelDays;
    int Gain_factor_client = 500;
    int Gain_factor_travel = 100;
    Manager(String name, int birthYear, int nbClients, int nbTravelDays) {
        this(name, birthYear, 100, nbClients, nbTravelDays);
    }
    Manager(String name, int birthYear, int nbClients, int nbTravelDays, double rate) {
        super(name, birthYear, rate, null);
        this.nbClients = nbClients;
        this.nbTravelDays = nbTravelDays;
    }
    Manager(String name, int birthYear, int nbClients, int nbTravelDays, Vehicle vehicle) {
        super(name, birthYear, vehicle);
        this.nbClients = nbClients;
        this.nbTravelDays = nbTravelDays;
    }
    Manager(String name, int birthYear, int nbClients, int nbTravelDays, double rate, Vehicle vehicle) {
        super(name, birthYear, rate, vehicle);
        this.nbClients = nbClients;
        this.nbTravelDays = nbTravelDays;
    }
    private double getAnnualIncome() {
        return (((nbClients*Gain_factor_client)+(nbTravelDays*Gain_factor_travel))+(this.rate/100)*getMonthlyIncome()*12);
    }
    @Override
    String employeeType() {
        return "Manager";
    }
    @Override
    String additionalInfo() {
        return String.format("%s has and Occupation rate : %.1f%% and He/She travelled %d days and has brought %d new clients.%n His/Her estimated annual income is %.2f%n",
                this.name,this.rate,nbTravelDays, nbClients, getAnnualIncome());
    }
}

// Programmer class
class Programmer extends Employee {
    int nbProjects;
    int Gain_factor_projects = 200;

    Programmer(String name, int birthYear, int nbProjects) {
        this(name, birthYear, 100, nbProjects);
    }

    Programmer(String name, int birthYear, int nbProjects, double rate) {
        super(name, birthYear, rate, null);
        this.nbProjects = nbProjects;
    }

    Programmer(String name, int birthYear, int nbProjects,double rate, Vehicle vehicle) {
        super(name, birthYear, 100, vehicle);
        this.nbProjects = nbProjects;
    }
    Programmer(String name, int birthYear, int nbProjects, Vehicle vehicle) {
        super(name, birthYear, vehicle);
        this.nbProjects = nbProjects;
    }
    private double getAnnualIncome() {
        return (getMonthlyIncome() * 12 * (this.rate/100))+(nbProjects*Gain_factor_projects);
    }

    @Override
    String employeeType() {
        return "Programmer";
    }

    @Override
    String additionalInfo() {
        return String.format("%s has an Occupation rate : %.1f%% and completed %d projects.%n His/Her estimated annual income is %.2f%n",
                this.name,this.rate,nbProjects, getAnnualIncome());
    }
}

// Tester class
class Tester extends Employee {
    int nbBugs;
    int Gain_factor_error = 10;

    Tester(String name, int birthYear, int nbBugs) {
        this(name, birthYear, 100, nbBugs);
    }

    Tester(String name, int birthYear, int nbBugs, double rate) {
        super(name, birthYear, rate, null);
        this.nbBugs = nbBugs;
    }

    Tester(String name, int birthYear, int nbBugs,double rate, Vehicle vehicle) {
        super(name, birthYear, 100, vehicle);
        this.nbBugs = nbBugs;
    }
    private double getAnnualIncome() {
        return (getMonthlyIncome() * 12 * this.rate)+(nbBugs*Gain_factor_error);
    }
    @Override
    String employeeType() {
        return "Tester";
    }

    @Override
    String additionalInfo() {
        return String.format("%s has an Occupation rate : %.1f%% and corrected %d bugs.%n His/Her estimated annual income is %.2f%n",
                this.name,this.rate,nbBugs, getAnnualIncome());
    }
}
