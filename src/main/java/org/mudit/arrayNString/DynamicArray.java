package org.mudit.arrayNString;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        ArrayList<Integer>[] seqList = new ArrayList[n];

        int lastAnswer = 0;

        for (List<Integer> list : queries) {
            int x = list.get(1);
            int y = list.get(2);
            int seq = (x ^ lastAnswer) % n;

            if (seqList[seq] == null) {
                seqList[seq] = new ArrayList<Integer>();
            }

            List<Integer> tempList = seqList[seq];

            if (list.get(0) == 1) {
                tempList.add(y);
            } else {
                lastAnswer = tempList.get(y % tempList.size());
                result.add(lastAnswer);

            }
        }
        return result;
    }
}
