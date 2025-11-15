public abstract class Action
{   protected String name;

    public Action(String name)
        {   
            this.name = name;
        }

    public abstract void perform(Player player); //add player class

}