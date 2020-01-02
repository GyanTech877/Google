/*
Find shortest unique prefix to represent each word in the list.

Example:

Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}
where we can see that
zebra = z
dog = dog
duck = du
dove = dov
NOTE : Assume that no word is prefix of another. In other words, the representation is always possible. 
*/

class TrieNode{
    Character c;
    Map<Character,TrieNode> link;
    int count = 0;
    public TrieNode(Character c){
        this.c = c;
        this.count = 0;
        this.link = new HashMap<>();
    }
}
public class Solution {
    private void add(TrieNode root,String input){
        TrieNode currentNode = root;
        for(int i=0;i<input.length();i++){
            Character currentChar=input.charAt(i);
            TrieNode nextNode;
            if(currentNode.link.containsKey(currentChar)){
                nextNode = currentNode.link.get(currentChar);        
                nextNode.count++;
            }
            else{
                nextNode = new TrieNode(currentChar);
            }
            currentNode.link.put(currentChar,nextNode);
            currentNode=nextNode;
        }
    }
    private String search(TrieNode root,String input){
        TrieNode currentNode = root;
        String res="";
        for(int i=0;i<input.length();i++){
            if(currentNode!=root && currentNode.count==0) return res;    
            Character currentChar=input.charAt(i);     
            res+=currentChar;
            currentNode=currentNode.link.get(currentChar);
        }
        return res;
    }
    public ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> result = new ArrayList<>();
        TrieNode root = new TrieNode(' ');
        for(int i=0;i<A.size();i++){
            add(root,A.get(i));
        }
        for(int i=0;i<A.size();i++){
            result.add(search(root,A.get(i)));
        }
        return result;
    }
}
