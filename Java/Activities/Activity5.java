package activities;

public class Activity5 {
    public static void main(String[] args) {
        MyBook newNovel = new MyBook();

        //Set title
        newNovel.setTitle("Two States");

        //Print result
        System.out.println("The title is: " + newNovel.getTitle());
    }
}
