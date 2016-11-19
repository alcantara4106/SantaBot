import java.util.*;
public class SantaBot
{
    public String getGreeting()
    {
        return "Ho ho ho, I'm Santa Claus! How are you doing today?";
    }
    public String processor1(String statement){
        String response = "";
        String[] statementArray = cleanup1(statement);

        if(statement == ""){
            final int NUMBER_OF_RESPONSES = 2;
            double r = Math.random();
            int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
            if (whichResponse == 0){response = "I couldn't hear you properly, can you say that again?";}
            else if (whichResponse == 1){response = "Did you mean to say something?";}
            return response;
        }
        
        if(has(statementArray,"hi")||has(statementArray,"hello")){
            return "Hello there.";  
        }
        
        if(has(statementArray,"bye")||has(statementArray,"goodbye")){ 
            return "Good-bye.";  
        }
        
        if(has(statementArray, "do")){
            if(arrIndexOf(statementArray,"you") == arrIndexOf(statementArray,"do") + 1 &&
            (arrIndexOf(statementArray,"like") == arrIndexOf(statementArray,"do") + 2 ||
            arrIndexOf(statementArray,"love") == arrIndexOf(statementArray,"do") + 2)){
                if(arrIndexOf(statementArray,"children") == arrIndexOf(statementArray,"do") + 3){
                    return "Yes, of course I love children.";
                }
                if(arrIndexOf(statementArray,"cookies") == arrIndexOf(statementArray,"do") + 3){
                    return "Yes, cookies are delicious.";
                }
                if(has(statementArray,"red")){
                    return "Yes, red is my favorite color.";
                }
                return "I like a lot of things.";   
            }
        }
        
        if(has(statementArray, "how")){
            if(arrIndexOf(statementArray,"do") == arrIndexOf(statementArray,"how") + 1 &&
            arrIndexOf(statementArray,"you") == arrIndexOf(statementArray,"how") + 2){
                return "I do everything with magic.";   
            }
            else if(arrIndexOf(statementArray,"much") == arrIndexOf(statementArray,"how") + 1 &&
            arrIndexOf(statementArray,"do") == arrIndexOf(statementArray,"how") + 2 &&
            arrIndexOf(statementArray,"you") == arrIndexOf(statementArray,"how") + 3 &&
            arrIndexOf(statementArray,"weigh") == arrIndexOf(statementArray,"how") + 4){
                return "I weigh a lot.";    
            }
            else if(arrIndexOf(statementArray,"fast") == arrIndexOf(statementArray,"how") + 1){
                return "Very fast.";
            }
        }
        
        if(has(statementArray, "i")){
            if(arrIndexOf(statementArray,"am") == arrIndexOf(statementArray,"i") + 1 &&
            arrIndexOf(statementArray,"doing") == arrIndexOf(statementArray,"i") + 2){
                if(arrIndexOf(statementArray,"well") == arrIndexOf(statementArray,"i") + 3 ||
                arrIndexOf(statementArray,"fine") == arrIndexOf(statementArray,"i") + 3 ||
                arrIndexOf(statementArray,"good") == arrIndexOf(statementArray,"i") + 3 ||
                arrIndexOf(statementArray,"ok") == arrIndexOf(statementArray,"i") + 3){
                    return "That is good to hear.";
                }
            }
        }
        
        if(has(statementArray, "hate")){
            if(arrIndexOf(statementArray,"you") == arrIndexOf(statementArray,"hate") + 1){
                return "Nobody hates Santa Claus.";
            }            
            return "Hate is a strong word.";
        }      
        
        
        if(has(statementArray,"where")){
            return "The North Pole.";
        }

        return getRandomResponse();
    }
    public static String[] cleanup1(String str){
        str = str.trim().toLowerCase(); //Lowercases entire string
        String[] punctuation = {"!","?",",",".","'","\"","[","]","{","}",":",";","/","\\",
                                "@","#","$","%","^","&","*","(",")","<",">","`","~","|"};
        for(String x: punctuation){
            str = str.replace(x,""); //Removes punctuation
        }
        
        for(int i=0;i<5;i++){
            str = str.replace("  "," "); //Replaces double spaces with a single space
            //Does it several times just to make sure...
        }

        //System.out.println("str: " + str); //Prints str, remove in final version
        String[] strarray = str.split(" "); //Makes str into a list, split on the spaces

        //System.out.println("strarray: ");
        //for(String item: strarray){
        //    System.out.print("\"" + item + "\"" + " "); //Prints strarray, remove in final version
        //  }
        System.out.println();
        
        return strarray; //Returns strarray, the array version of the string
    }
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 5;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0){response = "I was spacing out, did you say something?";}
        else if (whichResponse == 1){response = "I was distracted for a second, can you repeat what you said?";}
        else if (whichResponse == 2){response = "Ah.";}
        else if (whichResponse == 3){response = "Oh.";}
        else if (whichResponse == 4){response = "Can you rephrase that?";}

        return response;
    }
    public static String stringConverter(String[] thing){
        String total = new String("");
        for(String item: thing){
            total.concat(item + " ");
        }
        return total;
    }
    public static boolean has(String[] arraything, String thing){
        return Arrays.asList(arraything).contains(thing);
    }
    public static int arrIndexOf(String[] arraything, String thing){
        return Arrays.asList(arraything).indexOf(thing);
    }
}
