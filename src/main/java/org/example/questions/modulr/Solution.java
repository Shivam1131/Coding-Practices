package org.example.questions.modulr;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    // Converts "MM-YYYY" into a continuous month index
    // Example:
    // Dec 2021 -> 24263
    // Jan 2022 -> 24264
    private int parseMonth(String dateStr) {
        int month = Integer.parseInt(dateStr.substring(0, 2));
        int year = Integer.parseInt(dateStr.substring(3, 7));
        return year * 12 + (month - 1);
    }

    public int solution(String[] A, String[] B, int[] C) {
        int n = A.length;
        // Stores changes in monthly expenses.
        // start month   -> +cost
        // end month + 1 -> -cost
        TreeMap<Integer, Integer> diffMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int start = parseMonth(A[i]);
            int end = parseMonth(B[i]);
            int cost = C[i];
            // Expense starts from this month
            diffMap.put(start,diffMap.getOrDefault(start, 0) + cost);
            // Expense stops after the end month
            diffMap.put(end + 1,diffMap.getOrDefault(end + 1, 0) - cost);
        }
        // Binary search for minimum monthly income
        int low = 0;
        int high = 100;
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(mid, diffMap)) {
                // This income works
                ans = mid;
                // Try to find a smaller valid income
                high = mid - 1;
            } else {
                // Income is insufficient
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isValid(int income,TreeMap<Integer, Integer> diffMap) {
        long balance = 0;
        // Current expense per month
        int currentExpense = 0;
        // First month where an expense change occurs
        int prevMonth = diffMap.firstKey();
        for (Map.Entry<Integer, Integer> entry : diffMap.entrySet()) {
            int currentMonth = entry.getKey();
            int change = entry.getValue();
            // Number of months for which the previous
            // monthly expense remained unchanged
            int monthsPassed = currentMonth - prevMonth;
            if (monthsPassed > 0) {
                // Net amount gained/lost during these months
                balance += (long) monthsPassed * (income - currentExpense);
                // Account balance must never become negative
                if (balance < 0) {
                    return false;
                }
            }
            // Apply expense change starting from currentMonth
            currentExpense += change;
            prevMonth = currentMonth;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] A = {"03-2021","04-2021","05-2021"};
        String[] B = {"03-2021","05-2021","05-2021"};
        int[] C = {20,10,15};
        int result = solution.solution(A, B, C);
        System.out.println("Minimum monthly income: " + result);
    }
}