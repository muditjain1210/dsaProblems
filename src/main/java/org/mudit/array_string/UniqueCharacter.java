package org.mudit.array_string;

public class UniqueCharacter {
    public static void main(String[] args) {
        String str = "abcdefghijlmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZZ!@#$%^&*()_+=-~-,./;'[]{}:<>?";
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            isUnique(str.toCharArray());
        }
        System.out.println(System.currentTimeMillis() - time);

        // Optimized version:
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            isUniqueOptimized(str.toCharArray());
        }
        System.out.println(System.currentTimeMillis() - time2);
    }

    public static boolean isUnique(char[] arr) {
        boolean isUnique = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (!isUnique) {
                break;
            }
        }
        return isUnique;
    }

    public static boolean isUniqueOptimized(char[] arr) {
        boolean[] bol = new boolean[128];
        boolean isUnique = true;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];
            if (bol[index]) {
                isUnique = false;
                break;
            } else {
                bol[index] = true;
            }
        }
        return isUnique;
    }
}