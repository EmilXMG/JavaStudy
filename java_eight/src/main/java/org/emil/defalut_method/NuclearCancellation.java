package org.emil.defalut_method;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NuclearCancellation {

    public static void main(String[] args) {
        // Test cases
        testReconciliation(List.of(new BigDecimal("10"), new BigDecimal("10"), new BigDecimal("10")), List.of(new BigDecimal("5"), new BigDecimal("3"), new BigDecimal("33")));
        testReconciliation(List.of(new BigDecimal("10"), new BigDecimal("10"), new BigDecimal("10")), List.of(new BigDecimal("5"), new BigDecimal("3"), new BigDecimal("1")));
        testReconciliation(List.of(new BigDecimal("10"), new BigDecimal("10"), new BigDecimal("10")), List.of(new BigDecimal("12"), new BigDecimal("3"), new BigDecimal("1")));
        testReconciliation(List.of(new BigDecimal("10"), new BigDecimal("10"), new BigDecimal("10")), List.of(new BigDecimal("12"), new BigDecimal("7"), new BigDecimal("3"), new BigDecimal("4")));
        testReconciliation(List.of(new BigDecimal("10"), new BigDecimal("10"), new BigDecimal("10")), List.of(new BigDecimal("5"), new BigDecimal("5"), new BigDecimal("5")));
    }

    public static void testReconciliation(List<BigDecimal> left, List<BigDecimal> right) {
        System.out.println("Left: " + left);
        System.out.println("Right: " + right);

        List<BigDecimal> reconciledLeft = new ArrayList<>();
        List<BigDecimal> reconciledRight = new ArrayList<>();
        BigDecimal leftSum = left.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal rightSum = BigDecimal.ZERO;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            BigDecimal leftValue = left.get(leftIndex);
            BigDecimal nextRightSum = rightSum.add(right.get(rightIndex));

            if (nextRightSum.compareTo(leftSum) <= 0) {
                reconciledLeft.add(leftValue);
                reconciledRight.add(right.get(rightIndex));
                rightSum = nextRightSum;
                leftIndex++;
                rightIndex++;
            }
            else {
                //reconciledLeft.add(leftValue);
                break; //Exit loop after finding a partial match
            }
        }

        System.out.println("Reconciled Left: " + reconciledLeft);
        System.out.println("Reconciled Right: " + reconciledRight);
        System.out.println("Remaining Left: " + left.subList(leftIndex, left.size()));
        System.out.println("Remaining Right: " + right.subList(rightIndex, right.size()));
        System.out.println("--------------------");
    }
}