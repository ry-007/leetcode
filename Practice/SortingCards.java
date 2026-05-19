/**
 * 
 * https://leetcode.com/discuss/post/6977167/idfc-first-bank-f2f-interview-question-b-nq03/ 
 * 
 * You are given a list of playing cards represented as strings in the format: "Rank-Suit"

Where:

Rank is one of the following: "2", "3", ..., "10", "J", "Q", "K", "A"

Suit is a single character: 'H' (Hearts), 'D' (Diamonds), 'C' (Clubs), 'S' (Spades)

Your task is to determine the highest card from the list based on the following rules:

Rank Precedence: Higher ranks win:

"2" < "3" < ... < "10" < "J" < "Q" < "K" < "A"

Suit Precedence (only when ranks are equal):

'H' < 'D' < 'C' < 'S' (i.e., Spades is the highest suit)

First Occurrence Rule:

If multiple cards have the same rank and suit, return the one that appears first in the list.

Input : A list of strings cards[] (1 ≤ length ≤ 10⁵), each representing a card in the format "Rank-Suit".

Example :
Input:
["5-H", "A-S", "K-D", "10-C", "J-H"]

**Output:
**A-S
 */

import java.util.*;

class SortingCards {
    public static void main(String args[]) {
        Map<String,Integer> rankWt = new HashMap<>();
        Map<String, Integer> suiteWt = new HashMap<>();
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suites = {"H", "D", "C", "S"};
        int r = 0;
        for(String s : ranks) {
            rankWt.put(s, ++r);
        }

        r = 0;
        for(String s : suites) {
            suiteWt.put(s, ++r);
        } 

        List<String> cards = Arrays.asList(
            "5-H",
                "A-S",
                "K-D",
                "10-C",
                "J-H"
        );

        cards.sort((card1, card2) -> {
            String[] c1 = card1.split("-");
            String[] c2 = card2.split("-");

            int rankCompare = Integer.compare(rankWt.get(c1[0]),rankWt.get(c2[0]));

            if(rankCompare != 0) {
                return rankCompare;
            } else {
                return  Integer.compare(suiteWt.get(c1[2]),suiteWt.get(c2[2]));
            }
        });

        System.out.println(cards.get(cards.size()-1));
       
    }
}