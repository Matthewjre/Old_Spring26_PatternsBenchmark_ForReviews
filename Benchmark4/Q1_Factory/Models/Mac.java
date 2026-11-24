package Q1_Factory.Models;

public class Mac implements IComputer
{
    private String modelNumber;

    public Mac(String aModelNumber)
    {
        this.modelNumber = aModelNumber;
        System.out.println("Mac computer created with model number: " + modelNumber);
    }
}
