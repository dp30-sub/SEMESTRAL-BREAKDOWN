public class Work extends Action
{
    public Work(){
        super("Work");
    }

    @Override
    public void perform(Player player)
    {
        player.setMoney(player.getMoney() + 500); // add getter and setter called setMoney and getMoney
        player.setStress(player.getStress()+ 10); //  add getter and setter called setStress and getStress
        player.setEnergy(player.getEnergy() -8);  // // add getter and setter called setEnergy and getEnergy
        System.out.println("You worked hard and earned 500 pesos but lost energy");

    }
}