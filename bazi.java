import java.util.Scanner;
public class bazi {
    static bazikon []players =new bazikon[1000];
    public static void create(String [] a ,int n){
       for (int i=0;i<n;i++){
         players[i].name=a[i];
        }
    }
    public static void main(String args){
        Scanner scanner = new Scanner(System.in);
        int i=0;
        while (i>1000) {
            String a = scanner.nextLine();
            if (i == 0&&a.contains("create")){
                int space=a.indexOf(" ");
                 String c1=a.substring(space+1);
                String []c2=new String[1000];
                int n=0;
                 for (int j=0;c1.indexOf(" ")!=0;j++){
                      space=c1.indexOf(" ");
                      String p=c1.substring(0,space);
                      c1=c1.substring(space+1);
                      c2[j]=p;
                      n++;
                 }
                create(c2,n);
                 i++;
                 continue;
            }
            else if(i==0){
                System.out.println("no game created");
                continue;
            }
            else {

            }

        }
    }
}
