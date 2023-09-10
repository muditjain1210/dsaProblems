package org.mudit.arrayNString;

//Reversing a long String via a String vs. a StringBuffer
public class StringsBenchMark {
    public static void main(String[] args) {
        long beginTime, elapsedTime;

        // Build a long string Using
        String str = "";
        int size = 16536;
        char ch = 'a';
        beginTime = System.nanoTime(); // Reference time in nanoseconds
        for (int count = 0; count < size; ++count) {
            str += ch;
            ++ch;
            if (ch > 'z') {
                ch = 'a';
            }
        }
        elapsedTime = System.nanoTime() - beginTime;
        System.out.println("Elapsed Time is " + elapsedTime / 1000 + " usec (+ to build String)");

        // Create String using StringBuffer
        StringBuffer bf = new StringBuffer();
        size = 16536;
        ch = 'a';
        beginTime = System.nanoTime(); // Reference time in nanoseconds
        for (int count = 0; count < size; ++count) {
            bf.append(ch);
            ++ch;
            if (ch > 'z') {
                ch = 'a';
            }
        }
        elapsedTime = System.nanoTime() - beginTime;
        System.out.println("Elapsed Time is " + elapsedTime / 1000 + " usec (String Buffer to build String)");

        // Create String using StringBuilder
        StringBuilder sb = new StringBuilder();
        size = 16536;
        ch = 'a';
        beginTime = System.nanoTime(); // Reference time in nanoseconds
        for (int count = 0; count < size; ++count) {
            sb.append(ch);
            ++ch;
            if (ch > 'z') {
                ch = 'a';
            }
        }
        elapsedTime = System.nanoTime() - beginTime;
        System.out.println("Elapsed Time is " + elapsedTime / 1000 + " usec (String Builder to build String)");

    }
}
