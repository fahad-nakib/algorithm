import java.util.Scanner;
import java.util.Stack;
public class LCS {
    static  int[][] list;
    static  int[][] prev;
    static Stack print_sequence(int l1,int l2, String txt1,String txt2){
        Stack<Character> sk = new Stack<>();
        int i = l1; int j = l2;
        while(i !=0 && j != 0)
        {
            if (txt1.charAt(i-1) == txt2.charAt(j-1)){
                sk.add(txt1.charAt(i-1));
                i--; j--;
            }else if(list[i][j-1]>list[i-1][j]){
                j--;
            }else {
                i--;
            }
        }
        return sk;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> sk;
        String txt1 = "ABCDEFGH";
//        System.out.println("Enter First String :");
//        String txt1 = sc.nextLine();
        String txt2 = "ABCDEIJK";
//        System.out.println("Enter Second String :");
//        String txt2 = sc.nextLine();

        int l1 = txt1.length();
        int l2 = txt2.length();
        list = new int[l1+1][l2+1];
        prev = new int[l1+1][l2+1];
        for (int i=0; i<list.length; i++)
        {
            list[0][i] = 0;  prev[0][i] = -1;
            list[i][0] = 0;  prev[i][0] = -1;
        }
        for (int i=1; i<list.length; i++)
        {
            for(int j=1;j<list.length; j++)
            {
                if (txt1.charAt(i-1) == txt2.charAt(j-1)){
                    list[i][j] = list[i-1][j-1]+1;
                }else{
                    if(list[i][j-1]>list[i-1][j]){
                        list[i][j] = list[i][j-1];
                    }else {
                        list[i][j] = list[i-1][j];
                    }
                }
            }
        }

        int i = l1; int j = l2;
        while(i !=0 && j != 0)
        {
            if (txt1.charAt(i-1) == txt2.charAt(j-1)){
                i--; j--;
                sk = print_sequence(i,j,txt1,txt2);
                while (!sk.isEmpty())
                {
                    System.out.print(sk.pop()+" ");
                }
                System.out.println();
                sk.clear();
            }else if(list[i][j-1]>list[i-1][j]){
                j--;
            }else {
                i--;
            }
        }
        System.out.println("LCS Length : "+ list[l1][l2]);
        sk = print_sequence(l1,l2,txt1,txt2);
        while (!sk.isEmpty())
        {
            System.out.print(sk.pop()+" ");
        }
        sk.clear();
    }
}
