package practice.account;

//import java.lang.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
//import java.io.Console;
import java.time.LocalDateTime;

public class account {
    
    public static final char[] getAccBal = null;
	//Members
    private final String name;
    private final String accID = UUID.randomUUID().toString();
    private float accBal = 0f;
    private float initBal;

    private List<String> transaction = new LinkedList<>();
    private boolean accClose = false;
    //private LocalDateTime dateAndTime = LocalDateTime.now();
    private LocalDateTime accCreationTime;
    private LocalDateTime accCloseTime;

    //Methods
        //Overload 
    public account(String name){
        this.name = name;
    }

    public account(String name, float initBal){
        this.name = name;
        this.initBal = initBal;
        this.accBal = initBal;
    }    
    
    public String getName() {
        return name;
    }
    
    public String getAccID() {
        return accID;
    }

    public float getAccBal() {
        return accBal;
    }
    
    public void setAccBal(float accBal) {
        this.accBal = accBal;
    }
    
    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }
    
    public boolean isAccClose() {
        return accClose;
    }
    
    public LocalDateTime getAccCreationTime() {
        return accCreationTime;
    }
    
    public void setAccCreationTime(LocalDateTime accCreationTime) {
        this.accCreationTime = accCreationTime;
    }
    
    public LocalDateTime getAccCloseTime() {
        return accCloseTime;
    }
    
    public void setAccCloseTime(LocalDateTime accCloseTime) {
        this.accCloseTime = accCloseTime;
    }

    public float getInitBal() {
        return initBal;
    }


    public float withdraw(String withdrawAmt) {
        Float withdrawAmtF = null;
        try{    
            withdrawAmtF = Float.parseFloat(withdrawAmt);
            if(withdrawAmtF.floatValue() <= 0){
                throw new IllegalArgumentException("Withdraw amount cannot be negative or zero");   
            }

            if(this.accClose){
                throw new IllegalArgumentException("You have already closed your account");
            }

            if(withdrawAmtF.floatValue() > accBal){
                throw new IllegalArgumentException("Too poor for that amount");
            }

            this.accBal = this.accBal - withdrawAmtF.floatValue();
            
            //creating string builder 
            StringBuilder withdrawStatment = new StringBuilder();
            withdrawStatment.append("Withdraw $");
            withdrawStatment.append(withdrawAmt);
            withdrawStatment.append(" at");
            withdrawStatment.append(LocalDateTime.now());
            //printing string builer
            System.out.println(withdrawStatment.toString());
            
            //storing in the transaction 
            transaction.add(withdrawStatment.toString());
        }catch(NumberFormatException e){
        System.err.print(e);
        throw new IllegalArgumentException("Invalid input format");
    }
        //return new balance
        return this.accBal;
    }

    public float deposit(String depositAmt){
        
        Float depositAmtF = null;
        depositAmtF = Float.parseFloat(depositAmt);
        

        
        if(depositAmtF <= 0){
            throw new IllegalArgumentException("Deposit amount cannot be negative or zero");   
        }

        if(this.accClose){
            throw new IllegalArgumentException("You have already closed your account");
        }

        /*if(depositAmtF > accBal){
            throw new IllegalAccessException("Too poor for that amount");
        }*/

        this.accBal = this.accBal + depositAmtF;
        
        //creating string builder 
        StringBuilder depositStatment = new StringBuilder();
        depositStatment.append("Deposit $");
        depositStatment.append(depositAmt);
        depositStatment.append(" at");
        depositStatment.append(LocalDateTime.now());
        //printing string builer
        System.out.println(depositStatment);
        
        //storing in the transaction 
        transaction.add(depositStatment.toString());
        
        //return new balance
        return this.accBal;
    }
        
}
  

