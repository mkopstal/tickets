package com.tickets.tickets;

public class TicketCountFormatter {
    public static String formatBagCount(int bagCount, int hundredsCoeficient) {
        if (bagCount > 1000) {
            return "Invalid bag count";
        }
        int hundreds = hundredsCoeficient * 100;

        String[] numberWords = {
                "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };

        String[] tenWords = {
                "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };

        if (bagCount == 1 && hundreds == 0) {
            return "One bag (";
        } else if(bagCount == 1) {
            return "One bag (" + (hundreds+bagCount) + " x ";
        } else if (bagCount < 20) {
            return numberWords[bagCount - 1] + " bags (" + (hundreds+bagCount) + " x ";
        } else if (bagCount < 100) {
            int tensDigit = bagCount / 10;
            int onesDigit = bagCount % 10;
            return tenWords[tensDigit] + " " + (onesDigit > 0 ? numberWords[onesDigit - 1] : "") + " bags (" + (hundreds+bagCount) + " x ";
        } else if (bagCount >= 100) {
            int hundredsDigit = bagCount / 100;
            int remainder = bagCount % 100;
            if (remainder > 0) {
                return String.format("%s hundred %s", numberWords[hundredsDigit - 1], formatBagCount(remainder, hundredsDigit));
            } else {
                return String.format("%s hundred (%s x ", numberWords[hundredsDigit - 1],bagCount);
            }
        }

        return "Invalid bag count";
    }

    public static String formatBagCount(int bagCount) {
        return formatBagCount(bagCount, 0);
    }
}
