import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class arraymethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try {int pos2=0;
			int maxn = Reader.nextInt();
			int n = Reader.nextInt();
			int q = Reader.nextInt();
			int[] array=new int[maxn];
			for(int i=0;i<n;++i){
				array[i]=Reader.nextInt();
			}
			for(int j=0;j<q;j++){
				int query=Reader.nextInt();
				int i,count1=0,count2=0;
				if(query==1){
					int x=Reader.nextInt();
					if(n==maxn){
						System.out.println(n+" "+"0");
						continue;
					}
					else{
						int l;
					
						for( l=0;l<n;l++){
							if(x<=array[l]){
								break;
							}
						}
						int e;
						for(e=n;e>l;e--){
							array[e]=array[e-1];
							count1+=1;
						}
						array[l]=x;
						n+=1;
						System.out.println(n+" "+count1);
				}
				}
				else if(query==2){
					int y=Reader.nextInt();
					for(int t=0;t<n;t++){
					if(array[t]==y){
						pos2=t;
						break;
					}
				}
					for(i=pos2;i<n-1;i++){
						array[i]=array[i+1];
						count2+=1;
					}
					array[n-1]=0;
					n-=1;
					System.out.println(n+" "+count2);
				}
				else if(query==3){
					if(n != 0){
					for(int p=0;p<n;p++){
						System.out.print(array[p]+" ");
					}
					System.out.println();
				}
					else{System.out.println();	
			}
		
				}}
		}catch (IOException e) 
		{
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

