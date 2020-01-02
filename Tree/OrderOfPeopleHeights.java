/*
You are given the following :

A positive number N
Heights : A list of heights of N persons standing in a queue
Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
You need to return list of actual order of persons’s height

Consider that heights will be unique

Example

Input : 
Heights: 5 3 2 6 1 4
InFronts: 0 1 2 0 3 2
Output : 
actual order is: 5 3 2 1 6 4 
So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.

For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.

You can do similar inference for other people in the list.
*/

public class Solution {
    class Person{
        int height;
        int peopleInFront;
        public Person(int height,int peopleInFront){
            this.height = height;
            this.peopleInFront = peopleInFront;
        }
    }
    public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        if(A ==null || A.size()==0 || B ==null || B.size()==0 || A.size()!=B.size()) return result;
        List<Person> list = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            list.add(new Person(A.get(i),B.get(i)));
        }
        Collections.sort(list,(p1,p2)->{
            if(p1.height==p2.height) return p1.peopleInFront-p2.peopleInFront;
            return p2.height-p1.height;
        });
        int i=0;
        for(Person p:list){
            result.add(p.peopleInFront,p.height);
        }
        return result;
    }
}
