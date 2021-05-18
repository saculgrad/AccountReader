//Nathan and Lucas

public class Multithread{
  public static void main(String[] args){
		long start = System.currentTimeMillis();        
		int n = 10;
		String maxAccount = "";
		double maxValue = 0.0;
        for (int i = 0; i < n; i++) {
            AccountReader object= new AccountReader();
            object.start();
            String filename = "Accounts/Accounts "+i+".txt";
            String data = object.checkAccountBalances (filename);
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