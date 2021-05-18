import java.util.*;
import java.io.*;

public class AccountReader extends Thread{
	public static void main (String [] args){
    AccountReader account = new AccountReader();
		account.checkAccountBalances("Accounts/Accounts 0.txt");
    account.checkAccountBalances("Accounts/Accounts 2.txt");
	}

	public String checkAccountBalances (String filename){
		double maxNum = 0;
    String maxAccount = "";
		try{
			File myObj = new File(filename);
      		Scanner myReader = new Scanner(myObj);
      		while (myReader.hasNextLine()) {
        		String data = myReader.nextLine();
        		int cutoff = data.indexOf ("\t");
        		String numWord = data.substring (cutoff,data.length());
        		double num = Double.parseDouble (numWord);
            if (num > maxNum){
              maxNum = num;
              maxAccount = data;
            }
        		

      		}
      		myReader.close();
          
    	}catch (FileNotFoundException e) {
      		System.out.println("An error occurred. Ha nerd.");
      		e.printStackTrace();
      }
      //System.out.println ("done with "+filename);
      //System.out.println (maxAccount);
      return maxAccount;

    }

    public void run (){
      try {
          //System.out.println("Thread " + Thread.currentThread().getId() + " is running");
      }catch (Exception e) {
          System.out.println("Exception is caught");
          e.printStackTrace();
      }
    }

}

