package day04;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 arklı obj'den List create ediniz.
     */
    public static void main(String[] args) {

        Universite bogazici = new Universite("bogazici", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yıldız teknik", "gemi", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));

        System.out.println(notOrt74BykUnv(unv));
        System.out.println("\n   ***");
        System.out.println(ogrenciSayisi110AzMi(unv));
        System.out.println("\n   ***");
        System.out.println(matBolumVarmi(unv));
        System.out.println("\n   ***");
        System.out.println(ogrSayiBkSirala(unv));
        System.out.println("\n   ***");
        System.out.println(ogrSayiBkSirala(unv));
        System.out.println("\n   ***");
        System.out.println(enAzOgrcSaysi2Unv(unv));
        System.out.println("\n   ***");
        System.out.println(notOrt63BykUnvOgrcSayisiTopla(unv));
        System.out.println("\n   ***");
        System.out.println("to int ile "+notOrt63BykUnvOgrcSayisiToplaToInt(unv));
        System.out.println("\n   ***");
        System.out.println("task 08- "+ogrcSayisi333BykNotOrtOrtalamaAl(unv));
        System.out.println("\n   ***");
        System.out.println("task 09- "+matBolumSayisi(unv));
        System.out.println("\n   ***");
        System.out.println("task 10- "+ogrncSayisi571BykMaxNotOrt(unv));
        System.out.println("\n   ***");
        System.out.println("task 11- "+ogrncSayisi1071AzMinNotOrt(unv));

    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.

    public static boolean  notOrt74BykUnv(List<Universite>unv){

     return  unv.
             stream().
             allMatch(t->t.
                     getNotOrt()>74);
    }


    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.

    public static boolean ogrenciSayisi110AzMi(List<Universite>unv){
       return unv.
                stream().
                allMatch(t->t.getOgrSayisi()>110);
    }


    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matBolumVarmi(List<Universite>unv){

                return  unv.stream().anyMatch(t->t.getBolum().contains("mat"));
    }


    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayiBkSirala(List<Universite> unv){
     return   unv.
                stream().
                sorted(Comparator.comparingInt(Universite::getOgrSayisi).reversed()).
                collect(Collectors.toList());//collect()->akısdaki elamanları istenen sarta gore toplar
        //Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir
    }


    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static List<Universite> notOrtSiralaIlkuc(List<Universite> unv){
        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getNotOrt).reversed()).
                limit(3).
                collect(Collectors.toList());
    }


    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.

    public static List<Universite>  enAzOgrcSaysi2Unv(List<Universite> unv) {
        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi)).
                limit(2).
                skip(1).
                collect(Collectors.toList());

    }


    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
    public static int notOrt63BykUnvOgrcSayisiTopla(List<Universite> unv){
        return   unv.
                stream().
                filter(t->t.getNotOrt()>63).
                map(t->t.getOgrSayisi()).
                // reduce(Integer::sum);
                // reduce(Math::addExact);
                        reduce(0,(t,u)->t+u);

    }

    public static int notOrt63BykUnvOgrcSayisiToplaToInt(List<Universite> unv){
        return   unv.
                stream().
                filter(t->t.getNotOrt()>63).
                mapToInt(t->t.getOgrSayisi()).sum();

    }


    //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.

    public static OptionalDouble ogrcSayisi333BykNotOrtOrtalamaAl(List<Universite> unv){
       return unv.
                stream().
                filter(t->t.getOgrSayisi()>333).
                mapToDouble(t->t.getNotOrt()).
                average();

        // mapToInt() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki() degere göre Int data type update eder

    }


    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matBolumSayisi(List<Universite> unv){
       return (int) unv.stream().filter(t->t.getBolum().contains("mat")).count();
    }


    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    public static OptionalInt ogrncSayisi571BykMaxNotOrt(List<Universite> unv){
      return  unv.
                stream().
                filter(t->t.getOgrSayisi()>571).
                mapToInt(t->t.getNotOrt()).
                max();
    }


    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static OptionalInt ogrncSayisi1071AzMinNotOrt(List<Universite> unv){
      return  unv.
              stream().
              filter(t->t.getOgrSayisi()<1071).
              mapToInt(t->t.getNotOrt()).
              min();
    }



}
