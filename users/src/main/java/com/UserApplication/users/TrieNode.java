package com.UserApplication.users;

import java.util.HashMap;
import java.util.Map;

public class TrieNode{
	public Map<Character, TrieNode> child = new HashMap<>();
	public boolean endOfWord;
	public int countPrefix=0;
}