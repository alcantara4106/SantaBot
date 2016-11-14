public class SantaBot
{
    public static String[] cleanup1(String str){
        str = str.trim().toLowerCase(); //Lowercases entire string
        String[] punctuation = {"!","?",",",".","'","\"","[","]","{","}",":",";","/","\\",
								"@","#","$","%","^","&","*","(",")","<",">","`","~","|"};
        for(String x: punctuation){
            str = str.replace(x,""); //Removes punctuation
        }
		
		for(int i=0;i<7;i++){
			str = str.replace("  "," "); //Replaces double spaces with a single space
			//Does it several times just to make sure... 5 works until theres 33 spaces in a row
			//2^x, x = i's limit is the limit of spaces. 2^7 is 128 so that should be good
		}

		System.out.println("str: " + str); //Prints str, remove in final version
		String[] strarray = str.split(" "); //Makes str into a list, split on the spaces

		System.out.println("strarray: ");
		for(String item: strarray){
			System.out.print("\"" + item + "\"" + " "); //Prints strarray, remove in final version
		  }
		System.out.println();
		
		return strarray; //Returns strarray, the array version of the string
    }
}
