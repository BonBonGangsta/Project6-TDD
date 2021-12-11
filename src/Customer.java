public class Customer {
    /*
        Constants
     */
    public static final int CUST_NOT_PROCESSED = 0; // means that the customer has not been processed yet.
    public static final int CUST_ENTERED = 1; // means customer entered the train.
    public static final int CUST_EXITED = 2; // means the customer exited the train and is done processing.

    /*
        Attributes
        id - customer's ID
        arrival - customer's arrival time at the train
        enter - stop in which the customer will enter the train
        exit - stop in which the customer will exit the train
        status - track customer's status using the constants above
     */
    private int id, arrival, enter, exit, status;

    public Customer(int custId, int arrivalTime, int enterStop, int exitStop){
        if(custId < 1){ throw new IllegalArgumentException();}else{this.id = custId;}
        if(arrivalTime <= 1){throw new IllegalArgumentException();}else {this.arrival = arrivalTime;}
        if(enterStop <= 0){throw new IllegalArgumentException();}else{this.enter = enterStop;}
        if(exitStop <= 0){throw new IllegalArgumentException();}else{this.exit = exitStop;}
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
        if(newStat <CUST_NOT_PROCESSED || newStat > CUST_EXITED ){
            throw new IllegalArgumentException();
        }
        this.status = newStat;
    }

}
