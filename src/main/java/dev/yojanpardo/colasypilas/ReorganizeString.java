package dev.yojanpardo.colasypilas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ReorganizeString {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("insert the value to reorganize");
        final String str = scanner.nextLine();

        System.out.printf("the reorganized string [%s] is: [%s]", str, reorganizeString(str));

    }

    private static String reorganizeString(String str) {
        final Map<Character, Integer> characterOccurrenceCount = new HashMap<>();

        for(char c : str.toCharArray()){
            characterOccurrenceCount.put(c, characterOccurrenceCount.getOrDefault(c, 0) + 1);
        }

        final PriorityQueue<Map.Entry<Character, Integer>> maxPriorityQueue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxPriorityQueue.addAll(characterOccurrenceCount.entrySet());

        assert maxPriorityQueue.peek() != null;
        if(maxPriorityQueue.peek().getValue() > (str.length() + 1)/2)
            return "the string %s cannot be reordered".formatted(str);

        StringBuilder reorganizedString = new StringBuilder();
        Map.Entry<Character, Integer> prevValue = null;

        while (!maxPriorityQueue.isEmpty()){
            Map.Entry<Character, Integer> currentEntry = maxPriorityQueue.poll();

            if(Objects.nonNull(prevValue) && prevValue.getValue() > 0){
                maxPriorityQueue.add(prevValue);
            }

            reorganizedString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            prevValue=currentEntry;

        }

        return reorganizedString.toString();
    }
}
