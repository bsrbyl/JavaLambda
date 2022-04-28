package day02;

import day01.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKarePrint(sayi);//1156 484 256 400 64 1444
        System.out.println("\n   ***");
        tekKupBirFazlaPrint(sayi);
        System.out.println("\n   ***");
        ciftKareKokPrint(sayi);
        System.out.println("\n   ***");
        maxElBul(sayi);
        System.out.println("\n   ***");
        ciftKareMaxBul(sayi);
        System.out.println("\n   ***");
        elTopla(sayi);
        System.out.println("\n   ***");
        ciftCarp(sayi);
        System.out.println("\n   ***");
        minBul(sayi);
        System.out.println("\n   ***");
        bestenBykEnKck(sayi);
        System.out.println("\n   ***");
    }
    // Task : Functional Programming ile listin cift elemanlarinin
    // karelerini ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(  List<Integer> sayi ){
        sayi.
                stream().
                filter(Lambda01::CiftBul).
                map(t-> t*t). //map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.
                forEach(Lambda01::yazdir);

    }
// Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edin

    public static void tekKupBirFazlaPrint( List<Integer> sayi){
        sayi.
             stream().//sayilar akısa  alındı
             filter(t->t%2!=0).//tek elemnalr fitrelendi
             map(t->(t*t*t)+1).//tek elemanları küplerinin 1 fazlasına udate edildi
             forEach(Lambda01::yazdir);//print edildi

    }
// Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
public static void ciftKareKokPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::CiftBul).
                map(Math::sqrt).//meth ref--> double deger return eder
                //forEach(Lambda01::yazdir)--> yazdir() method int.  çalıştığı için map den çıkan dataları çalıştırmaz
                forEach(t-> System.out.print(t+" "));
}
// Task : list'in en buyuk elemanini yazdiriniz
    public static void maxElBul(List<Integer> sayi){
        Optional<Integer> maxSayi= sayi.
                stream().
                reduce(Math::max);//akısa giren elemnalrın action sonrası tek eleman haline getirir
        System.out.println(maxSayi);//Optional[15]
        System.out.println("halukca :"+ sayi.stream().reduce(Math::max));//halukca :Optional[15]


        /*
 reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
 kullanımı yaygındır pratiktir.
 Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
 bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
 reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
 reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
 İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

 */
    }

// Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareMaxBul(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::CiftBul).
                map(t -> t * t).
                reduce(Math::max));//36

        System.out.println("daha hızlı specific ınteger class : " + sayi.
                stream().
                filter(Lambda01::CiftBul).
                map(t -> t * t).
                reduce(Integer::max));//36 specific class daha hızlı run olur


    }
    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
//Lambda Expression...

    public static void elTopla(List<Integer> sayi){
        //sayi.stream().reduce(Integer::sum);//method referans
      int toplam=  sayi.stream().reduce(0,(a,b)->a+b);//Lambda Expression...
    /*
        a ilk degerini her zaman atanan degerden (identity) alır
        b degerini her zamana  stream()'dan akısdan alır
        a ilk degerinden sonraki her değeri action(işlem)'dan alır

       */
        System.out.println("Lambda exp : "+ toplam);
        //Method Ref...
        Optional<Integer> topla=sayi.stream().reduce(Integer::sum);
        System.out.println("met ref : "+sayi.stream().reduce(Integer::sum)); //Method Ref...
    }
// Task : List'teki cift elemanlarin carpimini  yazdiriniz.


    public static void ciftCarp(List<Integer> sayi){
        //method ref...
        System.out.println("Lambda exp : "+sayi.
                stream().
                filter(Lambda01::CiftBul).
                reduce(Math::multiplyExact));
        //Lambda Expression...
        System.out.println("met ref : "+sayi.
                stream().
                filter(Lambda01::CiftBul).
                reduce(1, (a, b) -> (a * b)));
    }
    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.

    public static void minBul(List<Integer> sayi){
        //1. yontem Method Reference --> Integer class
        Optional<Integer> minSayiInteger=sayi.stream().reduce(Integer::min);
        System.out.println("minSayiInteger = " + minSayiInteger);

    //2. yontem Method Reference --> Math class
        Optional<Integer> minSayiMath=sayi.stream().reduce(Math::min);
        System.out.println("minSayiMath = " + minSayiMath);
    //3. yontem Lambda Expression
       Optional<Integer> minSayiJambda= Optional.of(sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
        System.out.println("minSayiJambda = " + minSayiJambda);

    //4. yontem Method Reference --> Haluk class
        Optional<Integer> minSayiHaluk = sayi.stream().reduce(Lambda02::byHalukMin);
        System.out.println("minSayiHaluk = " + minSayiHaluk);
}
    public static int byHalukMin(int a, int b) {//bu method kendisine verilen iki int degerin en kücügunu return eder
        return a < b ? a : b;
    }

    // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.

    public static void bestenBykEnKck(List<Integer> sayi){
        sayi.stream().filter(t-> t>5 && t%2==1).reduce(Lambda02::byHalukMin);

    }
    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.

}
