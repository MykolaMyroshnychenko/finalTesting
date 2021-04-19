package myr.vsem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mykola Myroshnychenko
 * @version 1.0.0
 * @project finalTesting
 * @class HarryPotter
 * @since 19.04.2021 - 18.05
 */
public class HarryPotter {
    public static void main(String[] args) throws IOException {

        //1.1. Download a text about Harry Potter.
        String text = new String(Files.readAllBytes(Paths.get("C:/Users/User/Downloads/harry.txt")));
        String[] words = text.toLowerCase().replaceAll("[^A-Za-z ]", "").split("\\s");

        //1.2. For each distinct word in the text calculate the number of occurrence.
        Map<String, Integer> counterMap = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                Integer count = counterMap.get(word);
                if (count == null) {
                    count = 0;
                }
                counterMap.put(word, ++count);
            }
        }

        for (String word : counterMap.keySet()) {
            System.out.println(word + ": " + counterMap.get(word));
        }


        // 1.3. Use RegEx
        String[] array = text.split(" +");

        List<String> list = Arrays.stream(array).collect(Collectors.toList());

        Map<String, Integer> map = new HashMap<>();

        Integer value = 0;
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                value = map.get(array[i]);
                map.put(array[i], value + 1);
            }
        }
        map.entrySet().stream().limit(20).forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------");


        Map<String, Integer> sorted = new LinkedHashMap<>();
        // 1.4. Sort in the DESC mode by the number of occurrence
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> sorted.put(entry.getKey(), entry.getValue()));
        //1.5 Find  the first 20 pairs

        sorted.entrySet().stream().limit(20).forEach(System.out::println);


        //1.9 Create a fine header for the file

        String sorted20 = "----------------------------" + "\n"
                + " HEAD for the task 1" + "\n"
                + " First 20 pairs and names" + "\n"
                + "-----------------------------------" + "\n";
        int counter = 0;

        //1.8 First 20 pairs and names write into to a file test.txt

        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            counter++;
            sorted20 += entry.getKey() + " " + entry.getValue() + "\n";
            if (counter == 20) break;
        }
        String sortedToString = sorted.toString();
        Files.write(Paths.get("C:/Users/User/Downloads/harry.txt"),
                sorted20.getBytes(StandardCharsets.UTF_8));


        // 1.6. Find all the proper names

        String[] word = text.split(" ");

        String stringOfDistincts = "";

        for (int i = 0; i < words.length; i++) {

            if (!stringOfDistincts.contains(words[i])) {
                stringOfDistincts += words[i] + " ";
            }
        }
        String[] distincts = stringOfDistincts.split(" ");

        int properNames = 0;

        for (int i = 0; i < distincts.length; i++) {
            if ((distincts[i].charAt(0) > 'A') && (distincts[i].charAt(0) < 'Z')) {
                distincts[i] = "\n" + distincts[i];
            }
        }
    }
}
/*
 result:

HarryHarry
PotterPotter
and
the
Sorcerer'sSorcerer's
StoneStone


CHAPTER
ONEONE


THE
BOYBOY
WHOWHO
LIVEDLIVED


Mr.
Mrs.Mrs.
Dursley,Dursley,
of
number
four,
PrivetPrivet
Drive,Drive,

----------------------------
 HEAD for the task 1
 First 20 pairs and names
-----------------------------------

the=3628
and=1919
to=1856
a=1688
he=1528
of=1259
harry=1214
was=1186
it=1026
in=964
his=937
you=863
said=794
had=702
i=652
on=636
at=625
that=601
they=597
as=526
 */