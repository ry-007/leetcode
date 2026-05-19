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

class SortingCards {
    public static void main(String args[]) {

    }

    String getHighestRankedCard(List<String> cards) {
        
    } 
}