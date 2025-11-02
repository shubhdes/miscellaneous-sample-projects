package com.datastructures.v2.graphs;

import java.util.*;

public class WordLadder {

    private int solve(String begin, String end, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(end)) {
            return 0;
        }

        Queue<Pair<String, Integer>> queue = new PriorityQueue<>((p1, p2) -> p1.second() - p2.second());
        queue.offer(new Pair<>(begin, 1));

        while (!queue.isEmpty()) {

            Pair<String, Integer> vi = queue.poll();
            String cword = vi.first();
            int step = vi.second();

            if (cword.equals(end)) {
                return step;
            }

            char[] tokens = cword.toCharArray();
            for (int i = 0; i < tokens.length; i++) {
                char ochar = tokens[i];
                for (char j = 'a'; j < 'z'; j++) {
                    tokens[i] = j;
                    String nword = new String(tokens);
                    if (wordSet.contains(nword)) {
                        wordSet.remove(nword);
                        queue.offer(new Pair<>(nword, step + 1));
                    }
                }
                tokens[i] = ochar;
            }
        }

        return 0;
    }
}
