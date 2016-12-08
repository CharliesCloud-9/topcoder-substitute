
import java.util.*;

/** NOTES: HashMap- DOES NOT MAINTAIN ORDER of insertion of keys. LinkedHashMap- should be used as it provides predictable... 
 * ...iteration order which is normally the order in which keys were inserted into the map (insertion-order). Cons: LinkedHashMap requires more memory than HashMap because it maintains insertion order of keys!
 * THINK OF THIS AS THE Target shopper price scanner, we are scanning the "product/item 'code'", Our code will then use the 'key' in the system to give us our "product/item price" or 'decodedValue'!!!!
 *
 * Problem:
 * A simple, easy to remember system for encoding integer amounts can be very useful. For example, dealers at flea markets put the information about an item on a card that they let potential buyers see. They find it advantageous to "encode the amount" they originally paid for the item on the card.
 * A good system is to use a substitution code, in which each digit (of the price amount)is encoded by a letter on the item/card of item. An easy to remember 10-letter word or phrase, the key, is chosen. Every '1' in the value is replaced by the first letter of the key, every '2' is replaced by the second letter of the key, and so on. 
 * Every '0' is replaced by the last letter of the key. Letters that do not appear in the key can be inserted anywhere without affecting the value (price of the item) represented by the code.. This helps to make the resulting code much harder to break (without knowing the key).
 * Create a class Substitute that contains the method getValue that is given the s key and code as input and that returns the decoded value.
 * Class: Substitute
 * Method: getValue
 * Parameters: String, String
 * Returns: int
 * Method signature: int getValue(String key, String code)
 * (be sure your method is public)
 * Constraints:
 * - code contains between 1 and 9 characters inclusive, all uppercase letters 'A'-'Z'
 * - code contains at least one letter that is found in key
 * - key contains exactly 10 uppercase letters 'A'-'Z', all distinct from each other
 * 
 */

public class Substitute {
	
	private static String arrowheadWater = "TRADINGFEW"; 						//just trying another way to print answer. :) static variable gets/needs memory only once in class area at the time of class loading. Also static is used when there is common property of all objects, like name of school of college students. 

	
    private int getValue(String key, String code) {
    	//Using characters inside key, we are Creating HashMap where, look at line 36 notes, and loop through each assigning Key,Value.
        LinkedHashMap<Character, Integer> key_map = new LinkedHashMap<Character, Integer>(); 	//HashMap object Maps key to values. A Map Cannot contain duplicate keys. Key is an object that you use to retrieve a value at a later date. Each Key-Value Pair Value known as Entry. 
        for(int i=0; i<key.length(); i++) {        											 //loop - increment through key String, for each.........
            key_map.put(key.charAt(i), (i+1)%10);										//(i+1)%10) is called hashing:https://www.tutorialspoint.com/data_structures_algorithms/hash_data_structure.htm
            //Notes for above line: type of HashMap is: HashMap<Character, Integer>.....put(first part is we are separating each letter of TRADINGFEW into map key. Imagine each char of the String, but going/listed downward like in map, 
            System.out.println(key_map); 										// Line 35 notes: also realize inside put() that key.charAt(i) //are individual letters/characters from key string// are the Keys in the HashMap. Where (i+1)%10 //which is 1,2,3,4,5,6,7,8,9,10 or numbers/Integers// are the Values!
        }

        //Looping through 'code'
        int decodedValue = 0; 								//this will be eventually returned and printed to screen once it has gone the if statement changes.
        for(int i=0; i<code.length(); i++) { 			//traverse code.length()
            char C = code.charAt(i); 				//each time...putting 'code' individual character into char C
            if(!key_map.containsKey(C)) {				//checking/testing to see if key_map aka HashMap does not have any char C characters, if this is true then......
                continue;							//...True->-..then "continue" aka exit the if statement & also exit out the for loop and forget about remaining if statement code like the line of code below and just return decodedValue;
            }
                decodedValue = decodedValue*10 + key_map.get(C);	//...False->..//remember for each letter being traversed//.....else if key_map does contain character from char C then
                											//key_map.get(C); will list 1, 0, 0, 6 downwards each separated and not combined number, so next part does some math to come up with the answer 1006 all together by adding decodedValue*10 to the entire equation of decodedValue*10 + key_map.get(C);...just remember that each time decodedValue will change, for example 1 then 10 then 100 and final answer 1006.
                										//System.out.println(key_map.get(C));//prints out each individually decodedValue vertically 
                System.out.println(decodedValue);  //this is just to show you how decodedValue changes in the above equation each time.      
        }
        return decodedValue;

    }

	public static void main(String[] args) {
		Substitute sObj = new Substitute();
		// getValue(key, code)
		System.out.println("Final/real price/decodedValue for each item/product code, after being comapred with the key:  decodedValue = " + sObj.getValue(arrowheadWater, "LGXWEV")); //this is case sensitive.
		
		System.out.println("Final/real price/decodedValue for each item/product code, after being comapred with the key:  decodedValue = " + sObj.getValue("ABCDEFGHIJ", "XJ")); //this is case sensitive.
		
		System.out.println("Final/real price/decodedValue for each item/product code, after being comapred with the key:  decodedValue = " + sObj.getValue("CRYSTALBUM", "CMMA")); //this is case sensitive.

	}
	
	/*
	 * Original Code Without Notes:
	 * 
	 * import java.util.*;
public class Substitute {
    public int getValue(String key, String code) {
        HashMap<Character, Integer> key_map = new HashMap<Character, Integer>();
        for(int i=0; i<key.length(); i++) {
            key_map.put(key.charAt(i), (i+1)%10);
        }

        int ret = 0;
        for(int i=0; i<code.length(); i++) {
            char C = code.charAt(i);
            if(!key_map.containsKey(C)) 
                continue;
            ret = ret*10 + key_map.get(C);
        }
        return ret;

  }
    }
	 * 
	 * 
	 */

}
