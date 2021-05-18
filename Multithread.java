//Nathan and Lucas

public class Multithread{
  public static void main(String[] args){
		       
		int n = 10;
		String maxAccount = "";
		double maxValue = 0.0;
		AccountReader[] accounts = new AccountReader[10];
		long start = System.currentTimeMillis(); 
        for (int i = 0; i < n; i++) {
            accounts[i] = new AccountReader ();
            accounts[i].start();
            String filename = "Accounts/Accounts "+i+".txt";
            String data = accounts[i].checkAccountBalances (filename);
            int cutoff = data.indexOf ("\t");
            String numWord = data.substring (cutoff,data.length());
        	double num = Double.parseDouble (numWord);
        	if (num > maxValue){
              maxValue = num;
              maxAccount = data.substring (0,cutoff-2);
            }
        }
        System.out.println(maxAccount);
        

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        double time = (double )timeElapsed/1000;
        System.out.println (time);

    }
}