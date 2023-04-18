package activities;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Ardra");
        myList.add("Madhuri");
        myList.add("Arun");
        myList.add("Ashika");
        myList.add(3,"Deepu");
        System.out.println("Names in Arraylist: ");
        for (String name : myList) {
            System.out.print(name+" ");
        }
        System.out.println();
        System.out.println("Third name in ArrayList is: "+myList.get(3));
        System.out.println("Verifying Deepu exists in ArrayList: "+myList.contains("Deepu"));
        System.out.println("Total number of names in ArrayList before removing element: "+myList.size());
        myList.remove("Ashika");
        System.out.println("Total number of names in ArrayList after removing an element: "+myList.size());
    }
}
