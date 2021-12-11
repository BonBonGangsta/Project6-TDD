import java.io.File;
import java.io.FileReader;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.IllegalFormatConversionException;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class Simulator {

    public static void main(String[] args){
        Simulator sim = new Simulator();
        File data = sim.getInputFile();
        int numStops = sim.getStopsFromUser();
        ArrayList<Customer> passengers = sim.checkFile(numStops, data);
        sim.run(numStops, passengers);
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
                else{
                    throw new Exception();
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
        //String defaultMacPath = "/Users/bydepa/Projects/src/customer-data.txt";
        // prompt the user for the path of the file that will be used as input data for customers
        // set a boolean for the while loop
        boolean validFile = false;
        while(!validFile){
            System.out.println("Enter absolute path for data file or for default (" + defaultPath + ") press Enter:");
            try{
                String path = sc.nextLine();
                if(path == null || path.equalsIgnoreCase("") || path.equalsIgnoreCase("\n")){
                    File data = new File(defaultPath);
                    if (data.exists()){
                        return data;
                    }
                    else{
                        throw new Exception();
                    }

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
                try{
                    String s = fileInput.nextLine();
                    String[] tokens = s.split("[\\s+]");
                    if(!(tokens.length == 4)){
                        throw new InvalidParameterException();
                    }
                    int cust_id = Integer.parseInt(tokens[0]);
                    int arrive_time = Integer.parseInt(tokens[1]);
                    int enter_stop = Integer.parseInt(tokens[2]);
                    int exit_stop = Integer.parseInt(tokens[3]);
                    if(!((cust_id >= 1) && (arrive_time > 0) &&
                            (enter_stop > 0 && enter_stop <= stops) &&
                            (exit_stop > 0 && exit_stop <= stops) &&
                            (!(enter_stop == exit_stop)))){
                        throw new Exception();
                    }
                    else{
                        Customer temp = new Customer(cust_id, arrive_time, enter_stop, exit_stop);
                        if (list.contains(temp)){
                            throw new Exception();
                        }
                        else{
                            list.add(temp);
                        }
                    }

                }catch (InvalidParameterException e){
                    System.out.println("Each line must have four integers. Try again.");
                    return null;
                }catch(NumberFormatException e){
                    System.out.println("Each line must have four integers. Try again.");
                    return null;
                }
                catch (Exception e) {
                    System.out.println("Data in input file is not correct. Try again.");
                    return null;
                }
            }
        } catch (Exception e) {
            System.out.println("Data in input file is not correct. Try again.");
            return null;
        }

        return list;
    }
}
