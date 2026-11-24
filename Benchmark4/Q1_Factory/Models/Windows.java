package Q1_Factory.Models;

public class Windows implements IComputer
{
    private String modelNumber;

    public Windows(String aModelNumber)
    {
        this.modelNumber = aModelNumber;
        System.out.println("Windows computer created with model number: " + modelNumber);
    }
}
