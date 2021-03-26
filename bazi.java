import java.util.Scanner;
public class bazi {
    static bazikon []players =new bazikon[1000];
     static int n;
    public static void create(String [] a ,int n){
       for (int i=0;i<n;i++){
         players[i].name=a[i];
        }
    }
    public static void assign(String a){
        int s1=a.indexOf(" ");
        a=a.substring(s1+1);
        int s2=a.indexOf(" ");
        String b=a.substring(0,s2);
        String c=a.substring(s2+1);
        int x=0;
        for (int i=0;i<n;i++){
            if(players[i].name.equals(b)){
                players[i].teeen_naghsh(c);
                break;
            }
            else {
                x++;
            }
        }
        if(x==n){
            System.out.println("user not found");
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
                if(a.contains("assign")){
                  assign(a);
                }


            }

        }
    }
}
