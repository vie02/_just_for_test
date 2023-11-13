package net.tklearn.trie;

import java.util.HashMap;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children != null && curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                if (curr.children == null) {
                    curr.children = new HashMap<>();
                }
                TrieNode node = new TrieNode(c);
                curr.children.put(c, node);
                curr = node;
            }
        }
        curr.isEndWord = true;
    }

    public boolean search(String word) {
        TrieNode start = root;
        return startsWith(word, start) && start.isEndWord;
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    private boolean startsWith(String prefix, TrieNode startNode) {
        TrieNode curr = startNode;

        for (char c : prefix.toCharArray()) {
            if (curr == null || curr.children == null || !curr.children.containsKey(c)) return false;
            else {
                curr = curr.children.get(c);
            }
        }
        return true;
    }

}
