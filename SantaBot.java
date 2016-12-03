/**
 * SantaBot takes in the user's String input and returns a logical (or at least mostly logical) answer, 
 * with the persona of Santa Claus.
 * 
 * @author Ethan Alcantara and Pranav Konduru
 * @version December 2, 2016
 */

import java.util.*;
public class SantaBot
{
    /**
     * getGreeting() is a method that returns SantaBot's greeting. Used in place of 
     * processor1() since SantaBot initiates the conversation.
     * 
     * @return SantaBot's greeting as a String
     */
    public String getGreeting()
    {
        return "Ho ho ho, I'm Santa Claus! How are you doing today?";
    }
    /**
     * context() checks both SantaBot's last reply and the user's input and returns a
     * reply based on both of them (e.g. if the user replies to SantaBot's question).
     * 
     * @param String[] statementArray; the user's input in the form of an array
     * @param Object lastReply; SantaBot's last reply
     * 
     * @return SantaBot's response as a String, or an empty string to indicate to 
     * processor1() that it couldn't get a special response
     */
    public String context(String[] statementArray, Object lastReply){
        //Lines 33-43 fulfill requirements 4aii and 4aiv 
        if(lastReply == "I am Santa Claus, the fat old guy who wears red."){
            if(has(statementArray, "no")){
                return "Do I hear sass?";
            }
        }
        else if(lastReply == "Do I hear sass?"){
            if(has(statementArray, "yes")){
                return "Well, I know who's on my naughty list.";
            }
        }
        else if(lastReply == "I go by many names, but you can call me Santa Claus."){
            if(has(statementArray,"like") &&
               arrIndexOf(statementArray,"what") == arrIndexOf(statementArray,"like") + 1){
                return "Saint Nicholas, Father Christmas, and some others.";
            }
        }
        else if(lastReply == "Nobody hates Santa Claus."){
            if(has(statementArray,"i") &&
               arrIndexOf(statementArray,"do") == arrIndexOf(statementArray,"i") + 1){
                return "Well, I know who's on my naughty list.";
            }
        }
        else if(lastReply == "Are you ready for Christmas?"){
            if(has(statementArray,"yes")){
                return "You better be ready for Christmas.";
            }
            if(has(statementArray,"no")){
                return "You better get ready for Christmas.";
            }
        }
        else if(lastReply == "Have you had a nice day so far?"){
            if(has(statementArray,"yes")){
                return "Good for you.";
            }
            if(has(statementArray,"no")){
                return "I hope your day gets better.";
            }
        }
        else if(lastReply == "How's the weather for you? Still snowing here."){
            if(has(statementArray,"good")){
                return "Good for you.";
            }
            if(has(statementArray,"bad")){
                return "I'm sure you can deal with it. I have to deal with snow every day.";
            }
        }
        else if(lastReply == "Oh, are you sure?"){
            if(has(statementArray,"yes")){
                return "I'm not sure if I can agree.";
            }
            if(has(statementArray,"no")){
                return "Ah, ok.";
            }
        }
        return "";
    }
    /**
     * processor1() is the main method that runs SantaBot. It puts the user's input through
     * cleanup() so that it's an array that can be dealt with more easily first, then
     * checks if context() or transform() have any replies. It returns their output if they
     * do, otherwise it'll just look through statementArray and makes SantaBot reply based on 
     * keywords or strings of keywords. If it can't find a keyword, then it returns 
     * getRandomResponse()'s output (i.e. it returns a random reply).
     * 
     * @param String statement; the user's input in its raw form
     * @param Object lastReply; SantaBot's last reply to the user, used to put it into context()
     * 
     * @return SantaBot's response as a String, based on all of the criteria
     */
    public String processor1(String statement, Object lastReply){
        String response = "";
        String[] statementArray = cleanup(statement);
        System.out.println("thing1: " + stringConverter(statementArray));
        System.out.println("thing2: " + statement);
        if(!(context(statementArray, lastReply) == "")){
            return context(statementArray, lastReply);
        }
        
        if(!(transform1(statementArray) == "")){
            return transform1(statementArray);
        }
        
        //Lines 117-125 and 353-372 fulfill requirement 4ai
        if(statement == ""){
            final int NUMBER_OF_RESPONSES = 2;
            double r = Math.random();
            int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
            if (whichResponse == 0){response = "I couldn't hear you properly, can you say that again?";}
            else if (whichResponse == 1){response = "Did you mean to say something?";}
            return response;
        }
        
        //Lines 128-305 fulfill requirement 2a
        if(has(statementArray,"hi")||has(statementArray,"hello")){
            return "Hello there.";  
        }
        
        if(has(statementArray,"bye")||has(statementArray,"goodbye")){ 
            return "Good-bye.";  
        }
        
        if(has(statementArray,"who")){
            if(arrIndexOf(statementArray,"are") == arrIndexOf(statementArray,"who") + 1){
                if(arrIndexOf(statementArray,"you") == arrIndexOf(statementArray,"who") + 2){
                    return "I am Santa Claus, the fat old guy who wears red.";
                }
            }
        }
        
        if(has(statementArray,"what")){
            if(arrIndexOf(statementArray,"is") == arrIndexOf(statementArray,"what") + 1){
                if(arrIndexOf(statementArray,"your") == arrIndexOf(statementArray,"what") + 2){
                    if(arrIndexOf(statementArray,"name") == arrIndexOf(statementArray,"what") + 3){
                        return "I go by many names, but you can call me Santa Claus.";
                    }
                }
            }
        }
        
        if(has(statementArray,"whats")){
            if(arrIndexOf(statementArray,"your") == arrIndexOf(statementArray,"what") + 1){
                if(arrIndexOf(statementArray,"name") == arrIndexOf(statementArray,"what") + 2){
                    return "I go by many names, but you can call me Santa Claus.";
                }
            }
        }
        
        if(has(statementArray,"are")){
            if(arrIndexOf(statementArray,"you") == arrIndexOf(statementArray,"are") + 1){
                if(arrIndexOf(statementArray,"real") == arrIndexOf(statementArray,"are") + 2){
                    return "If you believe in me, then yes.";
                }
            }
        }
        
        if(has(statementArray, "do")){
            if(arrIndexOf(statementArray,"you") == arrIndexOf(statementArray,"do") + 1){
                if(arrIndexOf(statementArray,"like") == arrIndexOf(statementArray,"do") + 2 ||
                arrIndexOf(statementArray,"love") == arrIndexOf(statementArray,"do") + 2){
                    if(arrIndexOf(statementArray,"children") == arrIndexOf(statementArray,"do") + 3){
                        return "Yes, of course I love children.";
                    }
                    else if(arrIndexOf(statementArray,"cookies") == arrIndexOf(statementArray,"do") + 3){
                        return "Yes, cookies are delicious.";
                    }
                    else if(has(statementArray,"milk")){
                        return "Yes, milk is wonderful with cookies.";
                    }
                    else if(has(statementArray,"red")){
                        return "Yes, of course I like the color red, it's my favorite color.";
                    }
                    else if(has(statementArray,"sports")){
                        return "I watch sports, but I don't play them. If I did, I would win every time.";
                    }
                    else if(has(statementArray,"memes")){
                        return "Maybe...";
                    }
                    return "I like a lot of things.";   
                }
                else if(arrIndexOf(statementArray,"even") == arrIndexOf(statementArray,"do") + 2 &&
                    arrIndexOf(statementArray,"lift") == arrIndexOf(statementArray,"do") + 3 &&
                    arrIndexOf(statementArray,"bro") == arrIndexOf(statementArray,"do") + 4){
                        return "More than you do, I'm sure.";
                }
                if(has(statementArray,"language") || has(statementArray,"languages")){
                    return "Si, yo hablo espanol y otra idiomas.";
                }
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
            else if(has(statementArray,"heavy")){
                return "I'm very heavy.";
            }
            else if(has(statementArray,"tall")){
                return "I'm pretty tall.";
            }
            else if(arrIndexOf(statementArray,"fast") == arrIndexOf(statementArray,"how") + 1){
                return "Very fast.";
            }
            else if(has(statementArray,"old")){
                return "I am as old as Christmas itself.";
            }
            else if(arrIndexOf(statementArray,"are") == arrIndexOf(statementArray,"how") + 1 &&
            arrIndexOf(statementArray,"you") == arrIndexOf(statementArray,"how") + 2 &&
            arrIndexOf(statementArray,"doing") == arrIndexOf(statementArray,"how") + 3){
                return "I am doing well, thank you.";    
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
            if(arrIndexOf(statementArray,"love") == arrIndexOf(statementArray,"i") + 1 &&
            arrIndexOf(statementArray,"you") == arrIndexOf(statementArray,"i") + 2){
                return "I'm already married, but thank you.";
            }
        }
        
        if(has(statementArray, "what") || has(statementArray, "whats")){
            if(has(statementArray,"favorite")){
                if(arrIndexOf(statementArray,"reindeer") == arrIndexOf(statementArray,"favorite") + 1){
                    return "My favorite reindeer is Rudolph.";
                }
                else if(arrIndexOf(statementArray,"color") == arrIndexOf(statementArray,"favorite") + 1){
                    return "My favorite color is red, of course.";
                }
                else if(arrIndexOf(statementArray,"day") == arrIndexOf(statementArray,"favorite") + 1){
                    return "My favorite day is Christmas, of course.";
                }
                else if(arrIndexOf(statementArray,"food") == arrIndexOf(statementArray,"favorite") + 1){
                    return "Snow.";
                }
            }
        }
        
        if(has(statementArray, "hate")){
            if(arrIndexOf(statementArray,"you") == arrIndexOf(statementArray,"hate") + 1){
                return "Nobody hates Santa Claus.";
            }            
            return "Hate is a strong word.";
        }      
        
        if(has(statementArray,"no")){
            return "Oh, are you sure?";
        }
        
        if(has(statementArray,"exercise")){
            return "Exercise? What's that?";
        }
        
        if(has(statementArray,"where")){
            return "The North Pole.";
        }
        
        if(has(statementArray,"when")){
            if(has(statementArray,"christmas")){
                return "December 24th.";
            }
            return "Christmas day.";
        }
        
        if(has(statementArray,"good")){
            return "Yes, good.";
        }
        
        if(has(statementArray,"yes")){
            return "Sounds good.";
        }
        
        if(has(statementArray,"yeah") && 
          arrIndexOf(statementArray,"right") == arrIndexOf(statementArray,"yeah") + 1){
            return "Do I hear sass?";
        }

        return getRandomResponse();
    }
    
    /**
     * cleanup() makes the user's input lowercased, takes out the punctuation, and 
     * converts it into an array. This is to make the user input easier to deal with 
     * (erratic capitalisation can make it a lot harder for a chatbot to detect without
     * lowercasing everything, accounting for punctuation in if statements will be 
     * tedious without removing it, and having it as an array means avoiding the problem
     * of words with other words in them, like "no" in "know").
     * 
     * @param String str; the string that will be modified
     * 
     * @return strarray, a String array which is the cleaned-up version of str
     */
    public static String[] cleanup(String str){
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
    /**
     * getRandomResponse() uses an RNG to choose a random generic response/question if
     * SantaBot fails to find a proper response to the user's input.
     * 
     * @return a random response as a String
     */
    //Line 353-372 fulfill requirement 2b
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 10;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0){response = "I was spacing out, did you say something?";}
        else if (whichResponse == 1){response = "I was distracted for a second, can you repeat what you said?";}
        else if (whichResponse == 2){response = "Ah.";}
        else if (whichResponse == 3){response = "Oh.";}
        else if (whichResponse == 4){response = "Can you rephrase that?";}
        else if (whichResponse == 5){response = "Mm, ok.";}
        else if (whichResponse == 6){response = "Sounds good.";}
        else if (whichResponse == 7){response = "Are you ready for Christmas?";}
        else if (whichResponse == 8){response = "Have you had a nice day so far?";}
        else if (whichResponse == 9){response = "How's the weather for you? Still snowing here.";}

        return response;
    }
    /**
     * stringConverter() gets a String array and turns it into a String with spaces 
     * between all of the items. Made for changing sentences that are arrays into 
     * sentences that are Strings.
     * 
     * @param String[] thing; a String array
     * 
     * @return total, a String version of thing
     */
    public static String stringConverter(String[] thing){
        String total = new String("");
        for(String item: thing){
            total = total + item + " ";
        }
        return total;
    }
    /**
     * has() checks if an array has a certain item. Can technically be done with one line
     * of code but this way it's a lot cleaner and easier to understand.
     * 
     * @param String[] arraything; the given array that has() will search through
     * @param String thing; the String that has() will look for
     * 
     * @return true or false, depending on whether or not the array has the item
     */
    public static boolean has(String[] arraything, String thing){
        return Arrays.asList(arraything).contains(thing);
    }
    /**
     * arrIndexOf() checks the index of a certain item. Can technically be done with one 
     * line of code but this way it's a lot cleaner and easier to understand.
     * 
     * @param String[] arraything; the array that arrIndexOf() will search through
     * @param String thing; the String that arrIndexOf() will look for
     * 
     * @return the index of thing in arraything, or -1 if it isn't there.
     */
    public static int arrIndexOf(String[] arraything, String thing){
        return Arrays.asList(arraything).indexOf(thing);
    }
    /**
     * transformStatement() transforms statements so that they address the speaker properly.
     * 
     * @param afterCleanup; 
     */
    public static String transformStatement(String[] afterCleanup){
        
        //String [] afterCleanup = cleanup (Arrays.toString (inputStringArray));
        
        String [] transformStatement = new String[afterCleanup.length + 5];
        
        int i = 0;
        int j = 7;
        
        String str1 = afterCleanup[0];
        if (afterCleanup[0].equals( "can")  && afterCleanup[1].equals( "i")){           
           
            transformStatement[0] = "what";
            transformStatement[1] = "will"; 
            transformStatement[2] = "happen";
            transformStatement[3] = "if";
            transformStatement[4] = "you";
            transformStatement[5] = "do";
            transformStatement[6] = "not";

            for (i = 2; i < afterCleanup.length; i++) {
                transformStatement[j] = afterCleanup[i];
                j++;
                
            }
            
            System.out.println ("transformStatement:"+ Arrays.toString (transformStatement));
            return stringConverter(transformStatement);
        }
        else 
            return "";
    }
    /**
     * transform1() changes the user's input into a suitable output from SantaBot's
     * perspective rather than the user's.
     * 
     * @param String[] theArray; the array that transform1() transforms
     * 
     * @return finalString, a String containing Santabot's answer, or just "" if there's
     * nothing to transform
     */
    //Lines 160-end fulfill requirement for 4aiii
    public static String transform1(String[] theArray){
        //System.out.println("way before carnage: "+stringConverter(theArray));
        String finalString = new String();
        if(has(theArray, "can")){
            //System.out.println("found can");
            if(arrIndexOf(theArray,"i") == arrIndexOf(theArray,"can") + 1){
                //System.out.println("detected 'i'");
                //System.out.println("before carnage: " + stringConverter(theArray));
                //System.out.println("index of can thing: " + (arrIndexOf(theArray,"can") + 1));
                for(int i = arrIndexOf(theArray,"can") + 1; i >= 0; i--){
                    //System.out.println("sA: " + stringConverter(theArray));
                    theArray[i] = "";
                }
                String[] transformedArray = transform2(theArray);
                finalString = "What will happen if you don't ";
                for(String word: transformedArray){
                    if(word != ""){
                        finalString = finalString + word + " ";
                    }
                }
                finalString = finalString.substring(0,finalString.length()-1) + "?";
                return finalString;
            }
        }
        return "";
    }
    /**
     * transform2() works alongside transform1(), turning all first-person words to
     * second-person.
     * 
     * @param String[] statementArray; the array that transform2() looks at
     * 
     * @return statementArray, the modified version of the input
     * 
     */
    public static String[] transform2(String[] statementArray){
        for(int i=0; i < statementArray.length; i++){
            if(statementArray[i] == "are"){
                statementArray[i] = "am";
            }
            else if(statementArray[i] == "am"){
                statementArray[i] = "are";
            }
            else if(statementArray[i] == "were"){
                statementArray[i] = "was";
            }
            else if(statementArray[i] == "was"){
                statementArray[i] = "were";
            }
            else if(statementArray[i] == "you"){
                statementArray[i] = "me";
            }
            else if(statementArray[i] == "me"){
                statementArray[i] = "you";
            }
            else if(statementArray[i] == "your"){
                statementArray[i] = "my";
            }
            else if(statementArray[i] == "my"){
                statementArray[i] = "your";
            }
            else if(statementArray[i] == "ive"){
                statementArray[i] = "you've";
            }
            else if(statementArray[i] == "youve"){
                statementArray[i] = "I've";
            }
            else if(statementArray[i] == "im"){
                statementArray[i] = "you're";
            }
            else if(statementArray[i] == "you're"){
                statementArray[i] = "I'm";
            }
        }
        return statementArray;
    }
        
        
    }


