public class Customer {
    /*
        Constants
     */
    static final int CUST_NOT_PROCESSED = 0; // means that the customer has not been processed yet.
    static final int CUST_ENTERED = 1; // means customer entered the train.
    static final int CUST_EXITED = 2; // means the customer exited the train and is done processing.

    /*
        Attributes
        id - customer's ID
        arrival - customer's arrival time at the train
        enter - stop in which the customer will enter the train
        exit - stop in which the customer will exit the train
        status - track customer's status using the constants above
     */
    int id, arrival, enter, exit, status;

    Customer(int custId, int arrivalTime, int enterStop, int exitStop){
        this.id = custId;
        this.arrival = arrivalTime;
        this.enter = enterStop;
        this.exit = exitStop;
        this.status = 0;
    }

    public int getId(){
        return this.id;
    }

    public int getArrival(){
        return this.arrival;
    }

    public int getEnter(){
        return this.enter;
    }

    public int getExit(){
        return this.exit;
    }

    public int getStatus(){
        return this.status;
    }

    public void setStatus(int newStat){
        this.status = newStat;
    }

}
