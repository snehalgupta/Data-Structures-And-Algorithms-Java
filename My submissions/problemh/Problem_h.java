package problemh;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TrieNode 
{
    char content; 
    boolean isEnd; 
    int count;  
    LinkedList<TrieNode> childList; 
 
    public TrieNode(char c)
    {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }  
    public TrieNode subNode(char c)
    {
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}
 
class Trie
{
    private TrieNode root;
 
     
    public Trie()
    {
        root = new TrieNode(' '); 
    }
     
    public void insert(String word)
    {     
        TrieNode current = root; 
        for (char ch : word.toCharArray() )
        {
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else 
            {
                 current.childList.add(new TrieNode(ch));
                 current = current.subNode(ch);
            }
            current.count++;
        }
        current.isEnd = true;
    }
    
    public boolean search(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return false;
            else
                current = current.subNode(ch);
        }      
        if (current.isEnd == true) 
            return true;
        return false;
    }
    
    public void result(String word){
    	TrieNode current=root;
    	char[] ans=new char[32];
    	int p=0;
    	for(char ch:word.toCharArray()){
    		if (ch == '1'){
    			if(current.subNode('0') != null){
    				current=current.subNode('0');
    				ans[p]='1';
    				p++;
    			}
    			else if (current.subNode('1') != null){
    				current=current.subNode('1');
    				ans[p]='0';
    				p++;
    			}	
    		}
    		else if(ch == '0'){
    			if(current.subNode('1') != null){
    				current=current.subNode('1');
    				ans[p]='1';
    				p++;
    			}
    			else if(current.subNode('0') != null){
    				current=current.subNode('0');
    				ans[p]='0';
    				p++;
    			}
    		}
    	}
    	String xu=new String(ans);
    	int fhj=Integer.parseInt(xu,2);
    	System.out.println(fhj);
    }
    
    public void delete(String word)
    {
        if (search(word) == false)
        {
            return;
        }             
        TrieNode current = root;
        for (char ch : word.toCharArray()){
            TrieNode child = current.subNode(ch);
            if (child.count == 1) 
            {
                current.childList.remove(child);
                return;
            } 
            else 
            {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }
}    

public class Problem_h {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
		int q=Reader.nextInt();
		Trie t=new Trie();
		String fk=String.format("%32s", Integer.toBinaryString(0)).replace(" ", "0");
		t.insert(fk);
		for(int i=0;i<q;i++){
			String c=Reader.next();
			int z=Reader.nextInt();
			
			String s1=String.format("%32s", Integer.toBinaryString(z)).replace(" ", "0");
			if(c.equals("+")){
				t.insert(s1);
			}
			else if(c.equals("-")){
				t.delete(s1);
			}
			else if(c.equals("?")){
				t.result(s1);
			}
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}