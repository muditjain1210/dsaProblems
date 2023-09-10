package org.mudit.arrayNString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeSet;

public class ArrayNStringProblems {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    static void patterned2DArray(int m) {

        int[][] a = new int[2 * m - 1][2 * m - 1];
        int n = a.length;
        int la = n / 2;

        for (int l = 0; l <= la; l++) {
            for (int i = l; i <= n - l - 1; i++) {
                for (int k = l; k <= n - l - 1; k++) {
                    if (i == l || k == l || i == n - 1 - l || k == n - l - 1) {
                        a[i][k] = m - l;
                    }
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < a.length; k++) {
                System.out.print(a[i][k] + " ");
            }
            System.out.println();
        }
    }

    public static void findLongestSeqOptimized(int num) {
        // String s = Integer.toBinaryString(num);
        String s = "1111";
        char[] ch = s.toCharArray();
        int[] lengtharr = new int[ch.length];

        for (int i = 0, k = 0; i < ch.length; i++) {

            if (ch[i] == '1') {
                // IF zero was previously added we need to increase k
                if (lengtharr[k] <= -1) {
                    k++;
                    lengtharr[k] = 1;
                } else {
                    // Sequence of 1
                    lengtharr[k] = ++lengtharr[k];
                }

            } else if (ch[i] == '0') {
                // IF 1 was previously added we need to increase k

                if (lengtharr[k] >= 1) {
                    k++;
                    lengtharr[k] = -1;
                } else {
                    // Sequence of 0
                    lengtharr[k] = --lengtharr[k];
                }
            }
        }

        int maxLength = 0;
        for (int k = 0; k < lengtharr.length; k++) {

            if (lengtharr[k] == 0) {
                break; // we have reached end of array(default values)
            }

            if (lengtharr[k] <= -1) {
                continue;// No need to consider negatives..i.e zeros
            }

            int tempMax = lengtharr[k];

            if (lengtharr[k + 1] == -1) {
                // only 1 zero next to this 1's sequence,so we can flip this zero
                // and merge two sequence..
                tempMax = tempMax + lengtharr[k + 2];
            }
            maxLength = Math.max(maxLength, tempMax);
        }
        System.out.println(maxLength + 1);
    }

    public static int findLongestSequence(int i) {
        // String s = Integer.toBinaryString(i);
        String s = "11011101111";
        char[] ch = s.toCharArray();
        int maxLength = 0;
        for (int k = 0; k < ch.length; k++) {

            if (ch[k] == '0') {
                int temp = replaceWithZeroGetLength(k, ch.clone());
                if (temp > maxLength) {
                    maxLength = temp;
                }
            }

        }
        System.out.println(maxLength);
        return maxLength;
    }

    static boolean binarySearch(int[] arr, int l, int r, int num) {
        if (l >= r && arr[l] != num) {
            return false;
        }
        int middle = (l + r) / 2;

        if (arr[middle] == num) {
            return true;
        }

        if (arr[middle] < num) {
            return binarySearch(arr, middle + 1, r, num);
        }

        if (arr[middle] > num) {
            return binarySearch(arr, l, middle - 1, num);
        }
        return false;
    }

    static boolean isStringPalindrome(String s) {
        boolean isPal = true;
        char[] ar = s.toCharArray();

        for (int i = 0, j = ar.length - 1; i < j; i++, j--) {
            if (ar[i] != ar[j]) {
                isPal = false;
                break;
            } else {
                continue;
            }
        }
        return isPal;
    }

    static int replaceWithZeroGetLength(int index, char[] ch) {
        ch[index] = '1';

        int length = 0;
        int max = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '1') {
                length++;
            } else {
                if (length > max) {
                    max = length;
                    length = 0;
                }
            }
        }
        return Integer.max(max, length);
    }

    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervalsList) {
        ArrayList<Interval> result = new ArrayList<>();
        Collections.sort(result, new RangeComparator());
        // Sort the interval by comparing their start Number
        Interval prev = intervalsList.get(0);
        for (int i = 0; i < intervalsList.size(); i++) {
            Interval cur = intervalsList.get(i);
            if (cur.start <= prev.end) {
                prev = new Interval(prev.start, Math.max(prev.end, cur.end));
                result.add(prev);
            } else {
                result.add(prev);
                prev = cur;
            }
        }
        return result;

    }

    public ArrayList<String> printPaths(char[][] board) {
        ArrayList<String> out = new ArrayList<>();
        StringBuilder b = new StringBuilder();
        search(0, 0, board, b, out);
        return out;
    }

    public void search(int i, int j, char[][] board, StringBuilder sb, ArrayList<String> out) {
        if (i > board.length - 1 || j > board[0].length - 1) {
            return;
        }
        sb.append(board[i][j]);

        if (i == board.length - 1 && j == board[0].length - 1) {
            out.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        search(i + 1, j, board, sb, out);
        search(i, j + 1, board, sb, out);
        sb.deleteCharAt(sb.length() - 1);

    }

    public static String isPossible(int a, int b, int c, int d) {
        while (c > 0 && d > 0) {
            if (c > d) {
                c = c - d;
            } else {
                d = d - c;
            }

            if (a == c && b == d) {
                return "Yes";
            }
        }
        return "No";
    }

    public static ArrayList<String> removeDuplicates(List<String> input) {

        TreeSet<String> set = new TreeSet<>();

        for (String s : input) {
            set.add(s);
        }
        return new ArrayList<String>(set);
    }

    public static int[][] zeroMatrix(int[][] mat) {
        return null;
    }

    public static String compressString(String text) {

        char[] ch = text.toCharArray();
        int count = 1;
        StringBuilder b = new StringBuilder();
        b.append(ch[0]);// append the first character..
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == ch[i - 1]) {
                count++; // if this char is same as previous one..
            } else {
                if (count > 1) { // this char is not same and count is also >1
                    b.append(count); // append count
                    count = 1; // reset count
                }
                b.append(ch[i]); // append this character
            }
        }
        if (count > 1) { // corner case when we reach end of string before appending count..
            b.append(count);
        }
        return b.toString();
    }

    public static int[] coupleSum(int[] numbers, int target) {
        int[] index = new int[2];
        HashMap<Integer, St> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], new St(i + 1, (target - numbers[i])));
        }
        for (Integer i : map.keySet()) {
            St val = map.get(i);
            int diffKey = val.diff;
            if (map.get(diffKey) != null && map.get(diffKey).diff == i) {
                index[0] = val.index;
                index[1] = map.get(diffKey).index;
                break;
            }

        }
        return index;
    }

    public static String insertPairStar(String s) {

        return insertPairStringAtIndex(s, 0);

    }

    public static String insertPairStringAtIndex(String s, int i) {
        if (i == s.length() - 1) {
            return (new StringBuilder().append(s.charAt(i))).toString();
        }
        StringBuilder b = new StringBuilder();

        if (s.charAt(i) == s.charAt(i + 1)) {
            b.append(s.charAt(i));
            b.append("*");
        } else {
            b.append(s.charAt(i));

        }
        b.append(insertPairStringAtIndex(s, i + 1));

        return b.toString();

    }

    public static boolean isIsomorphic(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }

        char[] ch1 = input1.toCharArray();
        char[] ch2 = input2.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < ch1.length; i++) {
            Character c = map.get(ch1[i]);
            if (c != null) {
                ch1[i] = c;
            } else {
                map.put(ch1[i], ch2[i]);
                ch1[i] = ch2[i];
            }
        }
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] merge(int[] arrLeft, int[] arrRight) {
        int[] mer = new int[arrLeft.length + arrRight.length];
        int i = 0, j = 0, k = 0;
        while (i < arrLeft.length && j < arrRight.length) {
            if (arrLeft[i] <= arrRight[j]) {
                mer[k] = arrLeft[i];
                i++;
            } else {
                mer[k] = arrRight[j];
                j++;
            }
            k++;
        }

        if (i == arrLeft.length) {
            while (j < arrRight.length) {
                mer[k] = arrRight[j];
                k++;
                j++;
            }
        } else if (j == arrRight.length) {
            while (i < arrLeft.length) {
                mer[k] = arrLeft[i];
                k++;
                i++;
            }
        }
        return mer;
    }

    public static void transposeMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        // print
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Character firstNonRepeatedCharacter(String str) {
        LinkedHashMap<Character, Integer> s = new LinkedHashMap<>();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            Integer count = s.get(ch[i]);
            if (count == null) {
                s.put(ch[i], 1);
            } else {
                s.put(ch[i], ++count);
            }
        }
        for (Character i : s.keySet()) {
            Integer count = s.get(i);
            if (count == 1) {
                System.out.println(i);
                return i;
            }
        }
        return null;
    }

    public static void getNonRepeatingElemenet(int[] A) {
        HashMap<Integer, Integer> s = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            Integer count = s.get(A[i]);
            if (count == null) {
                s.put(A[i], 1);
            } else {
                s.put(A[i], ++count);
            }
        }
        for (Integer i : s.keySet()) {
            Integer count = s.get(i);
            if (count == 1) {
                // return i;
                System.out.println(i);
            }
        }

    }

    public static int[] bubbleSortArray(int[] arr) {
        int size = arr.length;

        for (int k = 1; k <= size - 1; k++) {
            // flag to use if no swap happens that means array is sorted now
            // 1,2,3,4,5 there will be no swap in this array
            int flag = 0;
            for (int i = 0; i <= size - k - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = 1; // swap happened
                }
            }

            if (flag == 0) {
                break; // NO swap happened i.e array is sorted now..
            }
        }
        return arr;
    }
}

class St {
    int index;
    int diff;

    public St(int index, int diff) {
        this.index = index;
        this.diff = diff;
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class RangeComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
        return Integer.compare(o1.start, o2.start);
    }

}