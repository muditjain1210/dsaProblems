package org.mudit.interviews_qstns;

public class Oracle {

    public static void main(String[] args) {
        int[] barHeights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        findWaterCollectedUnderBars(barHeights);
        findWaterCollectedUnderBarsOptimized(barHeights);
    }

    static int findMaxSum(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > secondlargest) {
                secondlargest = i;
            }
            if (secondlargest > largest) {
                int temp = largest;
                largest = secondlargest;
                secondlargest = temp;
            }
        }
        System.out.println(largest + secondlargest);
        return largest + secondlargest;
    }

    static void findWaterCollectedUnderBars(int[] barHeights) {
        // N2 complexity
        int vol = 0;
        // We will not consider first and last bar, since their left or right is null
        for (int i = 1; i < barHeights.length - 1; i++) {
            Integer maxLeft = findMaxleft(barHeights, i);
            Integer maxRight = null;
            if (maxLeft != null) {
                maxRight = findMaxRight(barHeights, i);
            }

            if (maxLeft != null && maxRight != null) {
                /**
                 * current bar has both left and right bars which are higher than this bar,
                 * so current bar can hold water on it..
                 */
                vol = vol + Math.min(maxLeft, maxRight) - barHeights[i];
            }
        }
        System.out.println(vol);
    }

    static void findWaterCollectedUnderBarsOptimized(int[] barHeights) {
        // O(N) complexity
        int vol = 0;

        // LeftMax[i] has maximum value to its left
        int[] leftMax = new int[barHeights.length];
        leftMax[0] = barHeights[0]; // first left element doesn't have any left
        for (int i = 1; i < barHeights.length; i++) {
            leftMax[i] = Math.max(barHeights[i], leftMax[i - 1]);
        }

        // Right[i] has maximum value to its right
        int[] rightMax = new int[barHeights.length];
        rightMax[barHeights.length - 1] = barHeights[barHeights.length - 1]; // last element doesn't have any right..
        for (int i = barHeights.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(barHeights[i], rightMax[i + 1]);
        }

        for (int i = 0; i < barHeights.length; i++) {
            vol += Math.min(leftMax[i], rightMax[i]) - barHeights[i];
        }

        System.out.println(vol);
    }

    static Integer findMaxleft(int[] barheights, int barIndex) {
        int max = barheights[barIndex]; // making current bar as max
        for (int i = 0; i < barIndex; i++) {
            if (barheights[i] > max) {
                max = barheights[i];
            }
        }
        return max == barheights[barIndex] ? null : max;
    }

    static Integer findMaxRight(int[] barheights, int barIndex) {
        int max = barheights[barIndex]; // making current bar as max
        for (int i = barIndex + 1; i < barheights.length; i++) {
            if (barheights[i] > max) {
                max = barheights[i];
            }
        }
        return max == barheights[barIndex] ? null : max;
    }
}
