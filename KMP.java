public class KMP {
	
	//主串S
	private String S; 
	
	//字串T
	private String T; 
	
	//建立对象，获得主串和字串
	public KMP(String S,String T) {
		this.S=S;
		this.T=T;
	}
	
	//KMP匹配算法
	public int compare() {
		
		//字串T的next数组，
		int[] next = new int[T.length()];
		
		//得到字串T的next数组
		next=get_next(T);
		
		//开始匹配
		int i=0,j=0;
		while(i<S.length()&&j<T.length()) {
			if(j==-1) {
				i++;
				j=0;
			}
			if(i==S.length()) {
				return -1;
			}
			while(S.charAt(i)==T.charAt(j)) {
				if(j==T.length()-1) {
					return i-j;
				}
				i++;
				j++;
			}
			j=next[j];		
		}
		
		return -1;
	}
	
	//得到字串T的next数组的函数
	private int[] get_next(String T) {
		int[] pmt = new int[T.length()];
		int[] next = new int[T.length()];
		pmt[0]=0;
		for (int n = 1; n < pmt.length; n++) {
			pmt[n]=get_value(T.substring(0, n+1));
		}	
		
		for (int i = 1; i < next.length; i++) {
			next[i]=pmt[i-1];
		}
		next[0]=-1;
		
		return next;
	}
	
	//得到子字符串next值
	private int get_value(String str) {
		
		for (int i = str.length()-1; i >0; i--) {
			if(str.substring(0, i).equals(str.substring(str.length()-i)))
				return i;
		}
		return 0;
	}
	
	
}
