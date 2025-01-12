package org.example.algomonster.Trie;

public class TrieDS {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    static class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for(int i=0; i<word.length(); i++) {
                if (node.children[word.charAt(i)-'a'] == null) {
                    node.children[word.charAt(i)-'a'] = new TrieNode();
                }
                node = node.children[word.charAt(i)-'a'];
            }
            node.isEnd=true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for(int i=0; i<word.length(); i++) {
                if (node.children[word.charAt(i)-'a'] == null) {
                    return false;
                }
                node = node.children[word.charAt(i)-'a'];
            }
            return node.isEnd;
        }

        public boolean startsWith(String word) {
            TrieNode node = root;
            for(int i=0; i<word.length(); i++) {
                if (node.children[word.charAt(i)-'a'] == null) {
                    return false;
                }
                node = node.children[word.charAt(i)-'a'];
            }
            return true;
        }

        public void delete(String word) {
            TrieNode node = root;
            for(int i=0; i<word.length(); i++) {
                if (node.children[word.charAt(i)-'a'] == null) {
                    return;
                }
                node = node.children[word.charAt(i)-'a'];
            }
            node.isEnd=false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("new");
        trie.insert("news");
        System.out.println(trie.search("new"));
        System.out.println(trie.search("newt"));
        System.out.println(trie.startsWith("ne"));
        System.out.println(trie.startsWith("new"));
    }
}
