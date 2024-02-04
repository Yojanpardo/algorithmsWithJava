package dev.yojanpardo;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] list1 = {1,2,3,4,7,9};
        int[] list2 = {2,5,6,8,10,11,12};
        int[] mergedList = mergeTwoSortedLists(list1, list2);
        for (int j : mergedList) {
            System.out.println(j);
        }
    }

    private static int[] mergeTwoSortedLists(int[] list1, int[] list2) {
        int[] mergedList = new int[list1.length + list2.length];
        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i < mergedList.length; i++) {
            int insertValue;
            if(index1 == list1.length) {
                insertValue = list2[index2];
                index2++;
                mergedList[i] = insertValue;
                continue;
            }
            if(index2 == list2.length) {
                insertValue = list1[index1];
                index1++;
                mergedList[i] = insertValue;
                continue;
            }
            if(list1[index1] <= list2[index2]){
                insertValue = list1[index1];
                index1++;
            } else {
                insertValue = list2[index2];
                index2++;
            }
            mergedList[i] = insertValue;
        }
        return mergedList;
    }
}
