package may1d;

//import java.util.*;

class TrieNode

{

 int freq;

 TrieNode[] child;

  public TrieNode()

 {
freq=1;
child=new TrieNode[26];
for(int i=0;i<26;++i)

{

child[i]=null;

}
 }

 

 public int chartoindex(char c){
		return ((int)c - (int)'a');
	}
 
 public void insert(String str)

 {

int len=str.length();

TrieNode pCrawl=this;

for(int level=0;level<len;++level)

{

int index=chartoindex(str.charAt(level));//here in the given code was written index=str[level] which dont seem right so check it what it meant to do

if(pCrawl.child[index]==null)

{

pCrawl.child[index]=new TrieNode();

}

else

{

(pCrawl.child[index].freq)++;

}

pCrawl=pCrawl.child[index];


}

 }

 public void findPerfixesUtil(char[] prefix,int ind)

 {



if(this.freq==1)

{



//System.out.print(prefix+" ");
for(int i=0;i<ind;i++){
	System.out.print(prefix[i]);
}
System.out.println();
return;

}

for(int i=0;i<26;++i)

{

if(this.child[i]!=null)

{

	prefix[ind]=(char)(i+(int)'a');//here its storing integer in charater as per the code given i added typecast by myself was not present in the

                      //original code
	//System.out.println("bye");
    this.child[i].findPerfixesUtil(prefix,ind+1);	 

}

}

 }

}
public class May1d{
	 
	public static void main(String[] args) throws Exception
	 {
		 try {
			 String arr[] = {"zebra", "dog", "duck", "dove"};
			    int n = 4;
			    TrieNode root = new TrieNode();
			    root.freq = 0;
			    for (int i = 0; i<n; i++)
			        root.insert( arr[i]);
			 
			    // Create an array to store all prefixes
			    char[] prefix = new char[500];
			 
			    // Print all prefixes using Trie Traversal
			    root.findPerfixesUtil( prefix, 0);
				
			   // findPrefixes(arr, n);
			} catch (Exception e) {
				return;
			}
		 
	 }

	
}