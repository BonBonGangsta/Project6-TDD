import java.util.ArrayList;

public class Train {
    /*
        stops - USed to store the number of stops train has on its route.
        madeStops - used to store number of stops the train made to process all customers.
        currTime - Used to store the time for the train made to process all customers.
     */
    private int stops, madeStops, currTime = 0;
    private ArrayList<Customer> custList; // used to store list of customers to process in the simulation.

    /**
     * Constructor to pass values of stops and customer list from Simulator and to initialize Train's attributes
     * @param numberOfStops Number of total stops
     * @param customers array list of Customers
     */
    public Train(int numberOfStops, ArrayList<Customer> customers){
        this.stops = numberOfStops;
        this.madeStops = this.currTime = 0;
        this.custList = customers;
    }

    public void simulate(){
        int currStop = 1;   // current stop starts at 1
        int time = 1;  // current time
        boolean loopAgain = true;

        while (loopAgain)
        {
            loopAgain = false;   // assume all customers are done
            boolean printed = false;  // controls printing headings

            for (int i=0; i < custList.size(); i++)  // process every customer
            {
                Customer cust = custList.get(i);  // get current customer
                if (cust.getStatus() != Customer.CUST_EXITED)  // at least one more customer to process
                {
                    loopAgain = true;
                }

                // check if current customer already arrived at train and wants to enter at current stop
                if (cust.getStatus() == Customer.CUST_NOT_PROCESSED
                        && cust.getArrival() <= time && cust.getEnter() == currStop)
                {
                    if (!printed)
                        System.out.println("Current Time=" + time + " Current Stop=" + currStop);
                    System.out.println("       Customer enters train: id="+cust.getId());
                    cust.setStatus(Customer.CUST_ENTERED);
                    custList.set(i, cust);  // update customer list with changed status
                    printed = true;
                }

                // check if the current customer is in train and wants to exit at current stop
                if (cust.getStatus() == Customer.CUST_ENTERED && cust.getExit() == currStop)
                {
                    if (!printed)
                        System.out.println("Current Time=" + time + " Current Stop=" + currStop);
                    System.out.println("       Customer exits train: id="+cust.getId());
                    cust.setStatus(Customer.CUST_EXITED);
                    custList.set(i, cust);  // update customer list with changed status
                    printed = true;
                }

            }  // loop on customers

            if (currStop == stops)
                currStop = 1;  // if reached last stop, reset to first stop
            else
                currStop++;    // go to next stop

            if (printed)  // if there was something printed, we made a stop
            {
                madeStops++;  // update the number of stops made
                currTime = time;  // update time to process all customers
            }

            time++;  // increment current time

        }  // while more to process
    }

    public void displayStops(){
        System.out.printf("Train made %d stops and it took %d time units to process all customers\n",this.madeStops, this.currTime);
    }
}
