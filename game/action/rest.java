public class Rest extends Action {
    public Rest() {
        super("Rest");
    }

    @Override
    public void perform(Player player) {
        player.setEnergy(player.getEnergy() + 25); 
        player.setStress(player.getStress() - 10); 
        System.out.println("You took a good rest and feel refreshed!");
    }
}
