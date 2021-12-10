import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Simulator {

    public static void main(String[] args){

    }

    public void run(int stops, ArrayList<Customer> customers){
        Train choochoo = new Train(stops, customers);
        choochoo.simulate();
        choochoo.displayStops();
    }

    public int getStopsFromUser(){
        int stops = 0;
        Scanner sc = new Scanner(System.in);
        boolean numbergiven = false;
        while(!numbergiven){
            System.out.print("Enter number of stops the train has on its route (must be greater than 1): ");
            try{
                stops = Integer.parseInt(sc.next());
                if(stops > 1){
                    numbergiven = true;
                }
            } catch(Exception e){
                System.out.println("Invalid input, try again");
            }
        }
        sc.close();
        return stops;
    }

    public File getInputFile(){
        // Create a scanner to intake input
        Scanner sc = new Scanner(System.in);
        // default path for the file
        String defaultPath = "C:/train/customer-data.txt";
        // prompt the user for the path of the file that will be used as input data for customers
        // set a boolean for the while loop
        boolean validFile = false;
        while(!validFile){
            System.out.println("Enter absolute path for data file or for default (" + defaultPath + ") press Enter:");
            try{
                String path = sc.next();
                if( path == null || path.equalsIgnoreCase("")){
                    File data = new File(defaultPath);
                    return data;
                }
                else{
                    File data = new File(path);
                    if(data.exists()){
                        return data;
                    }
                    else{
                        throw new Exception();
                    }
                }
            }catch ( Exception e){
                System.out.println("File not found, try again.");
            }
        }
        return null;
    }

    public ArrayList<Customer> checkFile(int stops, File file){
        // create empty list ArrayList<Customer> list
        ArrayList<Customer>list = new ArrayList<>();
        // while loop
        Scanner fileInput = null;
        try {
            fileInput = new Scanner(new FileReader(file));
            while(fileInput.hasNextLine()){
                Arrays.stream(fileInput.nextLine().trim().split("\\s+")).toArray();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
