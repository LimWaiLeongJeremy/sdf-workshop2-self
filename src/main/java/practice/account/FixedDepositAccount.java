package practice.account;

public class FixedDepositAccount extends account {

    private float interest = 3;
    private int duration = 6;
    private int editCounter = 0;

    public FixedDepositAccount(String name){
        super (name);
    }

    public FixedDepositAccount(String name, float initBal){
        super (name, initBal);
        
    }    

    public FixedDepositAccount(String name, float initBal, float interest){
        super (name, initBal);
        this.interest = interest;
        editCounter = 0;
    }



    public FixedDepositAccount(String name, float initBal, float interest, int month){
        super (name, initBal);
        this.interest = interest;
        this.duration = month;
        editCounter = 0;
    }


    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getMonth() {
        return duration;
    }

    public void setMonth(int month) {
        this.duration = month;
    }

    public int getEditCounter() {
        return editCounter;
    }

    public void setEditCounter(int editCounter) {
        this.editCounter = editCounter;
    }

    public void durationAndInterestChange (float interest, int month){
        if(editCounter == 0 ){
            this.interest = interest;
            this.duration = month;
            editCounter++;
        } else {throw new IllegalArgumentException("you have change before.");}
        return;
    }

    @Override
    public float withdraw(String withdrawAmt) {
        return 0;
    }
    @Override
    public float deposit(String depositAmt) { 
        return 0;
    }
    @Override
    public float getInitBal() {
        return super.getInitBal() + interest;   
    }
    /*@Override 
    public float getInitBal(){
        return super.getInitBal() + interest;
    }*/
    
    //@Override float getInitBal(float fixedBal) {
        //return super.getInitBal() +interest;
    //}

}

