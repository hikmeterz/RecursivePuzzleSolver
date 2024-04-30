import java.util.Scanner;

	public class Puzzle{
	
		public static int length=0;
		public static boolean[] array;

		public static void main(String[] args) {
			int[] puzzle;
			Scanner k = new Scanner(System.in);
			System.out.println("Sayı dizisini giriniz: ");
			String s1= k.nextLine();//Bosluklu hali
			String s2=s1;
			while(s2.length()!=0){
				int indexBosluk= s2.indexOf(" ");
				if(indexBosluk<0) {
					s2="";
				}else {
					s2=s2.substring(indexBosluk+1);
					length++;
				}
			}
			puzzle= new int[length+1];
			String s3="";
			for(int i=0;i<puzzle.length;i++){
				int indexOfBosluk = s1.indexOf(" ");
				if(indexOfBosluk<0){
					s3=s1.substring(0);
				}else {
					s3= s1.substring(0,indexOfBosluk);
				}
				puzzle[i]= stringToInteger(s3);
				s1=s1.substring(indexOfBosluk+1);
			}	
			System.out.println("Baslangıc noktasını giriniz: ");
			int baslangicNoktasi = k.nextInt();
			array= new boolean[length+1];
			for(int i=0;i<array.length;i++)
				array[i]=true;
			if(solve(puzzle,baslangicNoktasi-1))
				System.out.println("Cozum var.");
			else
				System.out.println("Cozum yok.");
		
		}
		private static boolean solve(int [] puzzle, int nokta){		
			int deger;
		
			if(isValid(puzzle,nokta)){
				deger =puzzle[nokta];
				if(array[nokta] == true) {
					array[nokta]=false;
				}else {
					return false;
				}
				if(deger==0)
					return true;
				return solve(puzzle,nokta+deger)||solve(puzzle,nokta-deger);
			
			
			}		
		
			return false;
		}
		public static boolean isValid(int[] puzzle,int nokta){
			boolean valid=true;
			if(nokta>=puzzle.length || nokta<0)
				valid=false;
				
			return valid;
		}
	
		private static int stringToInteger(String s){//Stringi integera ceviren metod.
			
	  		int sonuc = 0, carpim = 1;
	 		for (int i = s.length()-1; i >= 0; i--) {
	    		 	sonuc += (s.charAt(i) - '0') * carpim;
	     			carpim *= 10;
	 		 }			
	 		 return sonuc;
		}	
	
	

	}
