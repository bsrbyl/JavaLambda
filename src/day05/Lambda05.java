package day05;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println("\n   ***");
        System.out.println("task 1-amele topla "+toplaAmele(10));
        System.out.println("task 1-cincix topla "+toplaCincix(10));
        System.out.println("\n   ***");

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming
public  static  int toplaAmele(int x){
        int toplam=0;
    for (int i = 0; i < x; i++) {
        toplam +=i;
    }
    return toplam;
}

    //Functional(cincix )Programming
    public  static  int toplaCincix(int x) {
        return  IntStream.
                range(1,x+1).
                sum();



    }
    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.


    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.


    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.


    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.


    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.


    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.


    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.


}
