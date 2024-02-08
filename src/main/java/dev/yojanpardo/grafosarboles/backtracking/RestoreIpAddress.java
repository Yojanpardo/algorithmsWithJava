package dev.yojanpardo.grafosarboles.backtracking;


import java.util.ArrayList;
import java.util.List;

import static dev.yojanpardo.Helper.scanner;

public class RestoreIpAddress {
    public static void main(String[] args) {
        System.out.println("insert the ip address number");
        final String ipAddress = scanner.nextLine();
        List<String> possibleIpAddresses = new ArrayList<>();
        findPossibleIpAddresses(0, ipAddress,"", 0, possibleIpAddresses);
        System.out.println("valid ip addresses are:");
        possibleIpAddresses.forEach(System.out::println);
    }

    private static void findPossibleIpAddresses(int index, String ipAddress,String actualIpAddress, int chunkNumbers, List<String> possibleIpAddresses) {
        if(chunkNumbers > 4) return;
        if(chunkNumbers == 4 && index == ipAddress.length()) {
            possibleIpAddresses.add(actualIpAddress.substring(0,actualIpAddress.length()-1));
            return;
        }

        for(int i = 1; i <= 3; i++){
            if(index + i > ipAddress.length()) break;

            String number = ipAddress.substring(index, index + i);
            if(!isChunkValid(number)) continue;

            findPossibleIpAddresses(index+i, ipAddress, actualIpAddress + number + ".", chunkNumbers+1, possibleIpAddresses);
        }
    }

    private static boolean isChunkValid(String actualChunk) {
        if(actualChunk.length() == 0
                || (actualChunk.length() > 1 && actualChunk.startsWith("0"))
        ){
            return false;
        }

        return 0 <= Integer.parseInt(actualChunk) && Integer.parseInt(actualChunk) <= 255;
    }
}
