package net.tklearn.trie;

import java.util.Map;

public class TrieNode {
    Character val;
    boolean isEndWord;
    Map<Character, TrieNode> children;

    public TrieNode() {};
    public TrieNode(Character val) {
        this.val = val;
    };
}
