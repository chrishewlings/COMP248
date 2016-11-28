/**
 * Created by chrishewlings on 11/27/2016.
 */
public class Main {
    public static void main(String[] args)
    {
        String[] params = {"Hello","Its","Me","Again"};
        Menu thing = new Menu(params);
        Menu emptyThing = new Menu();
        thing.setBottomMessage("Hot bottom buddies");
        thing.setTopMessage("Power bottom or top");
        int num = thing.readOptionNumber();
        System.out.println(num);

    }
}
