import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOpenerMain {
    //Object ArrayList of class NumberReader
    private ArrayList<NumberReader> nums = new ArrayList<NumberReader>();
    //Loads in file that is downloaded from yahoo and sends it to NumberReader class
    public void loadListFromFile(String filename){
        try {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()) {
                String[] x = input.nextLine().split(",");
                NumberReader num = new NumberReader(x[0],x[1],x[2],x[3],x[4],x[5],x[6]);
                nums.add(num);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found exception");
        }
    }
    //Finds the max in the markets high of the day to help format the output
    public double getMax(){
        double max = 0.0;
        for(NumberReader r : nums){
            double spot = r.getHigh();
            if(spot > max){
                max = spot;
            }
        }
        return max;

    }
    //Calls NumberReader and prints the stock information
    public void printList(){
        NumberReader numClass = new NumberReader();
        double max = getMax();
        numClass.setMax(max);
        System.out.printf(numClass.getSpacing());
        for(NumberReader r : nums){
            r.setMax(max);
            System.out.println(r.getAllInfo());
        }
    }
    //Gets the difference between the first and last stock
    public void printDifference(){
        int i = 0;
        double x = 0, y = 0;
        for(NumberReader r : nums){
            if(i == 0){
                x = r.getNumOne();
            }
            else if (i == nums.size() - 1) {
                y = r.getNumOne();
            }
            i++;
        }
        System.out.println("First price: $"+x+"   |   Last Price: $"+y);
        System.out.println("Difference between the first stock and last stock price: "+(y - x)+"    Percent difference: "+(y/x * 100)+"%");
    }
    //Main method that calls all the other methods to run the program, also comment out different files
    public static void main (String[]args){
        FileOpenerMain fileOpen = new FileOpenerMain();
        //fileOpen.loadListFromFile(".idea/AmozonP3M.txt");
        fileOpen.loadListFromFile(".idea/NASDAQ.txt");
        //fileOpen.loadListFromFile(".idea/F.csv");
        fileOpen.printList();
        fileOpen.printDifference();
        System.out.println("All time high of range: "+fileOpen.getMax());
    }
}