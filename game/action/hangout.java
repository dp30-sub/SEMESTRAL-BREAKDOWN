public class HangOut extends Action {
    public HangOut() {
        super("Hang Out");
    }

    @Override
    public void perform(Player player) {
        player.setMoney(player.getMoney() - 200);   
        player.setEnergy(player.getEnergy() + 10);  
        player.setStress(player.getStress() - 8); 
        System.out.println("You hung out with friends, spent some money but had fun and feel relaxed.");
    }
}
