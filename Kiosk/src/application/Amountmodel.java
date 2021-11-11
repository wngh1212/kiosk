package application;

public class Amountmodel {
	public int asum(int[] ctm) {
		int sumt=0;
		int m=0;
	
for(int i=0; i<4; i++) {
	if(i==0) m = 1500;
	if(i==1) m = 2000;
	if(i==2) m = 5000;
	if(i==3) m = 10000;
	sumt=sumt+ctm[i] * m;
}

	return sumt;
}
}
