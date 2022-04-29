package day03;

import day01.Lambda01;

import java.util.*;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("küşleme", "adana", "trileçe", "havucDilim", "buryan",
                "yaglama", "kokorec", "arabAşi", "waffle", "güveç", "trileçe"));

        System.out.println("\n   ***   ");
        alfBykTekrrsz(menu);
        System.out.println("\n   ***   ");
        chrSayisiTersSirali(menu);
        System.out.println("\n   ***   ");
        chrSayisiBkSirala(menu);
        System.out.println("\n   ***   ");
        sonHrfBkSirala(menu);
        System.out.println("\n   ***   ");
        charKaresiCiftElSirala(menu);
        System.out.println("\n   ***   ");
        harfSayisi7denAzKontrol(menu);
        System.out.println("\n   ***   ");
        wILeBaslayanElKontrol(menu);
        System.out.println("\n   ***   ");
        xILeBitenElKontrol(menu);
        System.out.println("\n   ***   ");
        charSayisiBykElPrint(menu);


    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrrsz(List<String> yemek){
        yemek.//akıs kaynagı
                stream().//akısa girdi
                //map(t->t.toUpperCase()).//Jamb.Ex  elemanlar buyuk harf update edildi
                        map(String::toUpperCase).//Meth.Ref elemanlar buyuk harf update edildi
                sorted().//alafabetik(natural dogal) sıra yapıldı
                distinct().// benzersiz: tekrarsız hale getirildi
                forEach(t->System.out.print(t+" "));//print

        //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersSirali(List<String> menu){
        menu.
                stream().//akısa alındı
                // map(t->t.length()).
                        map(String::length).//elemanlar karakter sayısına update edildi
                sorted(Comparator.reverseOrder()).//ter sıra yapıldı
                distinct().//benzersiz yapıldı
                //forEach(t->System.out.print(t+" "));
                        forEach(Lambda01::yazdir);//print edildi


    }
    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiBkSirala(List<String> menu){
        menu.
                stream().
                sorted(Comparator.
                        comparing(String::length)).
                forEach(t->System.out.print(t+" "));
    }
    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHrfBkSirala(List<String> menu){
        menu.
                stream().
                sorted(Comparator.
                        comparing(t->t.toString().
                                charAt(t.toString().length()-1)).
                        reversed()).
                forEach(t->System.out.print(t+" "));
    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..

    public static void charKaresiCiftElSirala(List<String>menu){
        menu.
                stream().//akısa alndı
                map(t->t.length()*t.length()).//akısdaki string elemanları boyutlarının karesine update edildi
                filter(Lambda01::CiftBul).//cift elelmalar filtrelendi
                distinct().//tekrarsız yapıldı
                sorted(Comparator.reverseOrder()).//ters b->k sıra yapıldı
                forEach(Lambda01::yazdir);// print edildi


    }
    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisi7denAzKontrol(List<String>menu){
        //amele kod
        System.out.println("amele code");
        boolean kontrol = menu.stream().allMatch(t->t.length()<=7);
       if (kontrol){
           System.out.println("List elemanlari 7 ve daha az harften olusuyor");
       }else {
           System.out.println("list elemanlari  7 harften buyuk ");

           //System.out.println(kontrol);
       }
       // cincix code
        System.out.println(" cincix code");

        System.out.println(menu.stream().allMatch(t -> t.length() <= 7) ? "List elemanlari 7 ve daha az harften olusuyor" : "list elemanlari  7 harften buyuk ");
    }
//anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
//allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
//noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wILeBaslayanElKontrol(List<String> menu){
        System.out.println(menu.
                stream().

                noneMatch(t -> t.startsWith("w")) ? " w ile baslaya yemegin menude isi ne" : "w ile baslayan yemek yok tatli vr");
    }



    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.

    public static void xILeBitenElKontrol(List<String> menu){
        System.out.println(menu.
                stream().
                anyMatch((t -> t.endsWith("x"))) ? "x ile biten yemegin menude isi ne" : "x ile biten yemek  vr");
    }


    // Task : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void charSayisiBykElPrint(List<String>menu){
        System.out.println(menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                findFirst());

        // akıs cıktısını bir veriable assaign edilebilir

        Optional<String > enBykel=menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                findFirst();
    }

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
}

