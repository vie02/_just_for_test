package net.tklearn.trie;

import org.junit.jupiter.api.Test;

public class TrieTest {

    @Test
    void insert() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("appl");
        trie.insert("applle");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("appl");
        trie.insert("applle");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("appl");
        trie.insert("applle");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("appl");
        trie.insert("applle");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("appl");
        trie.insert("applle");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("appl");
        trie.insert("applle");
    }

    @Test
    void search() {
    }

    @Test
    void startsWith() {
    }
}