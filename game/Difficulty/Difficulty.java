/** Represents difficulty levels for the game **/
public enum Difficulty {
    NORMAL(1000, 100, 50, 0.3),  // Standard settings
    HARD(500, 80, 60, 0.4);      // Limited resources, higher requirements
    
    private final int startingMoney;
    private final int startingEnergy;
    private final int minPassingGrade;
    private final double eventProbability;
    
    Difficulty(int money, int energy, int minGrade, double eventProb) {
        this.startingMoney = money;
        this.startingEnergy = energy;
        this.minPassingGrade = minGrade;
        this.eventProbability = eventProb;
    }
    
    public int getStartingMoney() { return startingMoney; }
    public int getStartingEnergy() { return startingEnergy; }
    public int getMinPassingGrade() { return minPassingGrade; }
    public double getEventProbability() { return eventProbability; }
}