class Player {
    private String name;
    private int money;
    private int energy;
    private int stress;
    private int grades;
    private int day;
    private Action[] activities;
    private int activityCount;
    
    // NEW; Track the last action performed

    private String lastActionName;

    public Player(String name) {
        this.name = name;
        this.money = 200;
        this.energy = 60;
        this.stress = 20;
        this.grades = 50;
        this.day = 1;
        this.activities = new Action[10];
        this.activityCount = 0;
        
        // Initialize activities
        initializeActivities();
    }
    
    private void initializeActivities() {
        addActivity(new Study());
        addActivity(new Work());
        addActivity(new Rest());
        addActivity(new HangOut());
    }
    
    private void addActivity(Action activity) {
        if (activityCount < activities.length) {
            activities[activityCount++] = activity;
        }
    }
    
    // Getters and Setters
    
    
    public String getName() { return name; }
    
    public int getMoney() { return money; }
    public void setMoney(int money) { this.money = money; }
    
    public int getEnergy() { return energy; }
    public void setEnergy(int energy) { this.energy = energy; }
    
    public int getStress() { return stress; }
    public void setStress(int stress) { this.stress = stress; }

    public int getGrades() { return grades; }
    public void setGrades(int grades) { this.grades = grades; }

    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }

    public Action[] getActivities() { return activities; }
    public int getActivityCount() { return activityCount; }
    
    //NEW: Getter for last action
    public String getLastActionName(){
        return lastActionName;
    }

    public void performActivity(int index) {
        if (index >= 0 && index < activityCount) {
            activities[index].perform(this);
        }
    }
}