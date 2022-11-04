// Time Complexity:O(1)
// Space Complexity: O(1) for user-defined functions but n*l for constructor space
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this:No


// Your code here along with comments explaining your approach
/*
 * We will have a root node that will have the TrieNode structure. It will have boolean and an array of TrieNodes mostly 26
 */

public class Prefix {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length();i++)
        {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
            {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length();i++)
        {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length();i++)
        {
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}
