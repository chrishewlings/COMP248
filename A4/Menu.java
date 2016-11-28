import java.util.Scanner;

public class Menu
{
    private String[] options;
    private String topMessage, bottomMessage, topPrompt, bottomPrompt;
    private String literalPromptString = "?->";

    //constructors

    public Menu() // default constructor
    {
        this.options = null;
        this.topMessage = null;
        this.bottomMessage = null;
        this.topPrompt = null;
        this.bottomPrompt = null;
    }

    public Menu(String[] optsList) // default with parameters
    {
        this.options = optsList;
        this.topMessage = null;
        this.bottomMessage = null;
        this.topPrompt = "Choose an option:";
        this.bottomPrompt = "Enter an option number:";
    }

    //mutator methods

    public void setTopPrompt(String newTopPrompt)
    {
        this.topPrompt = newTopPrompt;
    }

    public void setBottomPrompt(String newBottomPrompt)
    {
        this.bottomPrompt = newBottomPrompt;
    }

    public void setTopMessage(String newTopMessage)
    {
        this.topMessage = newTopMessage;
    }

    public void setBottomMessage(String newBottomMessage)
    {
        this.bottomMessage = newBottomMessage;
    }

    // accessor methods

    public String getTopPrompt()
    {
        return this.topPrompt;
    }

    public String getBottomPrompt()
    {
        return this.bottomPrompt;
    }

    public String getTopMessage()
    {
        return this.topMessage;
    }

    public String getBottomMessage()
    {
        return this.bottomMessage;
    }

    // overriden methods from parent classes

    public Boolean isEmpty() // checks if the options list is empty
    {
        if(this.options == null)
            return true;
        else return false;
    }

    public int length() // returns length of options list
    {
        if(this.options == null)
            return 0;
        else return this.options.length;
    }

    public String toString() // returns stringified representation of menu
    {
        String returnString = "";
        String itemString;

        if( this.topMessage != null)
            returnString = returnString.concat(this.topMessage + "\n");

        returnString = returnString.concat(this.topPrompt + "\n");

        for(int i = 0; i < this.options.length; i++) {
            itemString = String.format("(%d) %s\n", (i + 1), this.options[i]);
            returnString = returnString.concat(itemString);
        }

        if( this.bottomMessage != null)
            returnString = returnString.concat(this.bottomMessage + "\n");

        returnString = returnString.concat(literalPromptString + " ");
        returnString = returnString.concat(this.bottomPrompt + "\n");

        return returnString;

    }


    public int readOptionNumber()
    {
        int userInput;
        do {
            System.out.println(this.toString());

            Scanner input = new Scanner(System.in);
            userInput = input.nextInt();

            if (this.options == null)
                return userInput;

        }while(userInput < 1 || userInput > this.options.length );

        return userInput;
    }
}

