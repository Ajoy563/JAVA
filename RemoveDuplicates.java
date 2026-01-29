public class RemoveDuplicates {
    //Remove duplicate characters in a strings
    public static void remove(String str, int idx, StringBuilder newStr, boolean map[]) {
        if(idx == str.length()) {   //Traverse the whole string
            System.out.println(newStr);
            return;
        }
        char currchar = str.charAt(idx);
        if(map[currchar - 'a'] == true) {
            //Duplicates
            remove(str, idx+1, newStr, map);  //Go to the next character
        }
        else {
            map[currchar - 'a'] = true; //for unique char, store "true" in map
            remove(str, idx+1, newStr.append(currchar), map);  //store the unique
        }                                                       // char in newString
        
    }
    public static void main(String args[]) {
        String str = "appnnacollege";
        remove(str, 0, new StringBuilder(""), new boolean[26]);
    }           //Directly write the RHS part in the function call
}
