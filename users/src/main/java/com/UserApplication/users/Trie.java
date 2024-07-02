package com.UserApplication.users;



public class Trie{
	
	public TrieNode root = new TrieNode();;
	
	public void insert(String str) { //apple
		TrieNode curr = this.root;
		char[] strInChar = str.toCharArray();
		
		for(char c:strInChar) {
			if(!curr.child.containsKey(c)) {
				
				curr.child.put(c, new TrieNode());
			}
			curr = curr.child.get(c);
			curr.countPrefix++;
		}
		curr.endOfWord = true;
	}
	
	public boolean isPrefix(String str) {
		TrieNode curr = this.root;
		for(int i=0;i<str.length();i++) {
			if(null == curr.child.get(str.charAt(i))) {
				return false;
			}
			curr = curr.child.get(str.charAt(i));
		}
		return true;
	}
}