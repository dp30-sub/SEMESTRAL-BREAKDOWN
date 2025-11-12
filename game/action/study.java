public class Study extends Action
{
    public Study(){
        super("Study");
    }

    @Override
    public void perform(Player player)
    {
        player.setGrade(player.getGrade() + 3); // add getter and setter called setGrade and getGrade
        player.setStress(player.getStress()+ 6 ); //  add getter and setter called setStress and getStress
        player.setEnergy(player.getEnergy() -12);  // // add getter and setter called setEnergy and getEnergy
        System.out.println("Congratulations, your grades improved but you feel tired");
    }
}