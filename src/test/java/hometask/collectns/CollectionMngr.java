package hometask.collectns;

        import java.util.ArrayList;
        import java.util.Collections;

public class CollectionMngr {

    public static void main(String args[]){
        ArrayList<String> arraylist = new ArrayList<String>();
        arraylist.add("Monday");
        arraylist.add("Tuesday");
        arraylist.add("Wednesday");
        arraylist.add("Thursday");
        arraylist.add("Friday");

      /*Unsorted List: ArrayList content before sorting*/
        System.out.println("Before Sorting:");
        for(String str: arraylist){
            System.out.println(str);
        }
        System.out.println("\nRemove 1st element.");
        arraylist.remove(0);
        if ( arraylist.contains("Monday")) {
            System.out.println("Yes, list still contains Monday");
        }
        else
        {
            System.out.println("No more Mondays!");};

      /* Sorting in decreasing order*/
        Collections.sort(arraylist);

      /* Sorted List in reverse order*/
        System.out.println("\nArrayList in ascending order:");
        for(String str: arraylist){
            System.out.println(str);
        }
    }
}