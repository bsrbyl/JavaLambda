package day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> menü = new ArrayList<>(Arrays.asList("küşleme", "adana", "trileçe", "havucDilim", "buryan",
                "yaglama", "kokoreç", "arabAşı", "güveç"));

            System.out.println("\n   ***   ");
            alfBykTekrrsz(menü);
}

        // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
public static void alfBykTekrrsz( List<String> yemek ){
        yemek.//akisa girdi
                stream().//akisa girdi
               // map(t->t.toUpperCase()).//elemanlar buyuk harf update edildi
               map(String::toUpperCase).
                sorted().//alfabetik(natoral dogal ) sira yapidi
                distinct().
                forEach(t-> System.out.print(t+" "));
}
// Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

// Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
// Task : list elemanlarinin son harfine gore ters sirali print ediniz.
// Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
// Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
// Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
// Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
// Task : Karakter sayisi en buyuk elemani yazdiriniz.
// Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    }

