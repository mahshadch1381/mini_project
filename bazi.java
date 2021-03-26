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
    public static void start(){
        for (int i=0;i<n;i++){
            if(players[i].naghsh==0){
                System.out.println("one or more player do not have a role");
                 return;}
        }
        for (int i=0;i<n;i++){
            String result=players[i].name+":"+" "+players[i].naghsh1;
            System.out.println(result);
        }
        System.out.println("Ready? Set! Go");
    }
    public static void day(String vote,String si){
        int tedad=0;
        String voter=vote.substring(0,vote.indexOf(" "));
        String vote_to=vote.substring(vote.indexOf(" ")+1);
        for (int y=0;y<n;y++){
            if(players[y].name.equals(voter)){
            }
            else
                tedad++;
        }
        if(tedad==n){
            System.out.println("user not found");
            return;
        }
        if(voter.equals(si)){
            System.out.println("voter is silenced");
           return;}
        for (int y=0;y<n;y++){
            int k=-1;
            if(players[y].name.equals(vote_to))
                k=y;
            if(k>=0&&players[k].dead==1){
                System.out.println("votee already dead");
                return;}
        }
        for (int y=0;y<n;y++){
            if(players[y].name.equals(vote_to)){
                players[y].dayvote++;
                return; }
        }
    }
    public static String day_result() {
        int max = -1, dead = -1;
        String day_dead = " ";
        for (int z = 0; z < n; z++) {
            if (players[z].dayvote > max) {
                max = players[z].dayvote;
                dead = z;
                day_dead = players[z].name;
                continue;
            }
            if (players[z].dayvote == max) {
                max = -1;
                break;
            }
        }
        if (max == -1) {
            return "nobody died";
        }
        if (max > -1&&players[dead].naghsh == 4) {
                return "Joker won!"; }
        else {
            String result = day_dead + " " + " died";
            return result; }
    }
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int i=0;
        int dor=0;
        int day=0,night=0;
       out: while (true) {
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
                  i++;
                  continue;}
                if(a.contains("start")){
                    if(dor>0){
                        System.out.println("game has already started");
                        continue; }
                    else {
                   start();
                   dor++;
                   i++;}
                }
                    String si=" ";
                   for (int z=0;z<n;z++){
                       if(players[z].silent){
                           si=players[z].name;}
                   }
                   String vote=" ";
                  in : while (true){
                       vote=scanner.nextLine();
                       if(vote.contains("end_vote")){
                           System.out.println(day_result());
                           if(day_result().contains("Joker won!")) {
                               break out; }
                           else
                               break in;
                       }
                       else {
                         day(vote,si);
                       }
                  }

               }
            }


    }
}
