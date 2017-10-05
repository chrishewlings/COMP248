/**
 * Created by chrishewlings on 11/27/2016.
 */
public class IceCreamOrder
{
    private String flavorName, vesselName, amount;
                                        //             1       2      3    #number of scoops
    private double[][] priceMatrix = { /* cone */   { 2.99 , 3.99 , 4.99 },
                                       /* cup  */   { 3.49 , 4.49 , 5.49 },
                                       /* sundae */ { 4.25 , 5.25 , 6.25} };
    private double unitPrice;
    private int quantity;

    // constructors

    public IceCreamOrder(String flavor, String vessel, String amount, double unitPrice, int quantity)
    {
        // constructor for when all variables are provided, including quantity.
        this.flavorName = flavor;
        this.vesselName = vessel;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public IceCreamOrder(String flavor, String vessel, String amount, double unitPrice)
    {
        // assumes quantity of order is one, but same as the above constructor otherwise.
        this(flavor,vessel,amount,unitPrice,1);
    }

    public IceCreamOrder() // default constructor with user prompts
    {
        // variables to hold menu contents
        String[] flavorList = {"Avocado","Banana","Chocolate","Coffee","Hazelnut","Lemon","Mango","Mocha","Vanilla"};
        String[] vesselList = {"Cup","Cone","Sundae"};
        String[] amountList = {"Single Scoop", "Double Scoop", "Triple Scoop"};
        String[] quantityList = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten"};

        // asking for flavor
        Menu flavors = new Menu(flavorList);
        flavors.setTopMessage("Placing an order is as easy as ABC, and D.");
        flavors.setTopPrompt("Step A: Select your favorite flavour");
        int i_flavorName = flavors.getOptionNumber();
        this.flavorName = flavorList[i_flavorName - 1];

        // asking for vessel
        Menu vessels = new Menu(vesselList);
        vessels.setTopPrompt("Step B: Select a vessel for your ice cream:");
        int i_vessel = vessels.getOptionNumber();
        this.vesselName = vesselList[i_vessel - 1];

        // asking for amount
        Menu amounts = new Menu(amountList);
        amounts.setTopPrompt("Step C: How much ice cream?");
        int i_amount = amounts.getOptionNumber();
        this.amount = amountList[i_amount - 1];


        // asking for quantity
        Menu quantities = new Menu(quantityList);
        quantities.setTopPrompt("Step D: how many orders of your current selection?");
        //int i_quantity = quantities.getOptionNumber();
        this.quantity = quantities.getOptionNumber();

        // calculate unit price

        this.unitPrice = priceMatrix[i_vessel - 1][i_amount - 1];
    }

    // setter methods

    public void setFlavor(String flavor)
    {
        this.flavorName = flavor;
    }

    public void setVessel(String vessel)
    {
        this.vesselName = vessel;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    // getter methods

    public String getFlavor()
    {
        return this.flavorName;
    }

    public String getVessel()
    {
        return this.vesselName;
    }

    public String getAmount()
    {
        return this.amount;
    }

    public double getUnitPrice()
    {
        return this.unitPrice;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    // overridden methods from parent classes

    public String toString()
    {
        return String.format("%d orders of %s of %s ice cream in a %s for $%.2f = %d x $%.2f", this.quantity, this.amount, this.flavorName, this.vesselName, this.unitPrice, this.quantity, this.unitPrice);
    }

    public double price()
    {
        return this.quantity * this.unitPrice;
    }


}
