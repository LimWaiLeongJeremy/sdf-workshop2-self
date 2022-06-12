package practice;

import practice.account.account;
import practice.account.FixedDepositAccount;;
public class App 
{
    public static void main( String[] args ){
        
        //greeting
        System.out.println( "Hello, welcome to your account!" );

        //normal acccreation
        account person1 = new account("jeremy", 1000);

        //normal withdraw and deposit
        person1.withdraw("20");
        System.out.println("new balance is $" + person1.getAccBal());
        person1.withdraw("99");
        System.out.println("new balance is $" + person1.getAccBal());
        person1.deposit("2000");
        System.out.println("new balance is $" + person1.getAccBal());

        //fixed acc creation
        FixedDepositAccount person2 = new FixedDepositAccount("jeremy", 1000);

        System.out.println(person2.getInitBal());

        person2.withdraw("1000");
        person2.deposit("1000");

        System.out.println(person2.getInitBal());
        
        person2.durationAndInterestChange(10, 32);
        System.out.println(person2.getInterest() + "," + person2.getMonth());
        System.out.println(person2.getInitBal());
        
        //int and dur chg test
        person2.durationAndInterestChange(2, 3);
        System.out.println(person2.getInterest() + "," + person2.getMonth());
       
        //deposit negative
        //person1.deposit("-100");

        //withdraw negative
        //person1.withdraw("-100");

        //person1.withdraw("100000");
        
        //person1.deposit("100000");
        

    }
}
