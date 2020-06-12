package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {


        MyList myList = new MyList(new Gems(10, 15, 197,3));
        myList.add(new Gems(12, 12, 12,2));
        myList.add(new Gems(14, 1, 2,1));

        ArrayList  myArList = new ArrayList();
        myArList.add(new Gems(2, 3,4,7));
        myArList.add(new Gems(5, 6,7,4));

        MyList myList1 = new MyList(myArList);

      /*  Iterator iterator = myList1.iterator();
        while ( iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
       /* System.out.println(myList.contains(new Gems(12, 12, 12,2)));
        System.out.println(myList.lastIndexOf(new Gems(16, 1, 2, 1)));
*/
        System.out.println(myList.get(3));
    }




}
