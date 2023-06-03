package danilofreitas.bank;

public class Account {

    private static final int MAX_LENGTH = 14;

    private String ag;
    private String  cc;
    private String name;
    private double balance;
    private Log logger = new Log();

    public Account(String ag, String cc, String name) {
        this.ag = ag;
        this.cc = cc;
        setName(name);
    }

    public void setName(String name) {
        if (name.length() > MAX_LENGTH){
            this.name = name.substring(0, MAX_LENGTH);
        } else {
            this.name = name;
        }
    }

    public void deposit(double value){
        balance += value;
        logger.out("DEPOSIT - $ " + value + " The current balance in your account is $ " + balance);
    }
    public boolean withDraw(double value){
        if (balance < value){
            logger.out("WITHDRAW - $ " + value + " Your current balance is $ " + balance);
            return false;
        }
            balance -= value;
            logger.out("WITHDRAW - $ " + value + " The current balance in your account is $ " + balance);
            return true;
        }

    @Override
    public String toString() {
        String result = "The bank account of " + this.name + " \n ag: " + this.ag + " \n cc: " + this.cc + "\n have $ " + balance;
        return result;

        // também poderia ser assim
        // return "The bank account of " + this.name + " \n ag: " + this.ag + " \n cc: " + this.cc + "\n have $ " + balance;
    }
}



