
public class OccuranceOfCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String str="banana";
      int i;
      int counter[]=new int[265];
      for(i=0;i<str.length();i++)
	{
		counter[(int)str.charAt(i)]++;
	}

      for( i=0;i<256;i++)
      {
    	  if(counter[i]!=0)
    			  {
    		  System.out.println((char)i+"-->"+counter[i]);
    			  }
      }
}
}
