class KMP_string{
    void KMPforSearch(String path,String text)
    {
        int N=text.length();
        int M=path.length();
        int lps[]=new int[M];
        computeLpsArray( path, M,lps);

        int i=0;
        int j=0;
        boolean isPossible=false;
        while (i<N)
        {
//System.out.println("The pattern is Founded in"+ i+" "+j+"th index");
            if(path.charAt(j)==text.charAt(i))
            {
                j++;
                i++;
            }
            if(j==M)
            {
                System.out.println("The pattern is Founded in "+ (i-j)+" th index");
                isPossible=true;
                j=lps[j-1];

            } else if (i<N && path.charAt(j)!=text.charAt(i)) {
                if(j!=0)
                {
                    j=lps[j-1];
                }
                else
                    i=i+1;
            }
        }

        if(isPossible==false){
            System.out.println("Not Found");
        }
    }
    void computeLpsArray(String path, int M, int lps[])
    {
        int len=0;
        int i=1;
        lps[0]=0;
        while(i<M) {
            if (path.charAt(i) == path.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len -1];

                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    public static void main(String args[])
    {
        String text = "ABABDABACDABABCABAB";
        String path = "ABAB";
        new KMP_string().KMPforSearch(path, text);
    }
}
