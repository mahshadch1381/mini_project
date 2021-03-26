import java.util.Scanner;
public class bazi {
    static bazikon []players =new bazikon[1000];
     static int n;
     public static void chek(){

     }
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
        for(int y=0;y<n;y++){
            players[y].dayvote=0;
        }
        if (max == -1) {
            return "nobody died";
        }
        if (max > -1&&players[dead].naghsh == 4) {
                return "Joker won!"; }
        else {
            String result = day_dead + " " + " died";
            players[dead].dead=1;
            return result; }
    }
    public static void night_part1(String shab){
        int f1 = 0, f2 = 0;
        String fael = shab.substring(0, shab.indexOf(" "));
        String mafuol = shab.substring(shab.indexOf(" ") + 1);
        for (int y = 0; y < n; y++) {
            if (fael.equals(players[y].name)) {
                f1 = y;
            }
            if (mafuol.equals(players[y].name)) {
                f2 = y;
            }
        }
        if (players[f1].dead == 1 || players[f2].dead == 1) {
            System.out.println("user is dead");
            return;
        }
        else if (players[f1].naghsh != 1 || players[f1].naghsh != 2 || players[f1].naghsh != 3 || players[f1].naghsh != -2 || players[f1].naghsh != -3) {
            System.out.println("user can not wake up during night");
           return;
        }
       else if (players[f1].naghsh == -2) {
            if (players[f2].naghsh == 1 || players[f2].naghsh == 2) {
                System.out.println("YES");
            } else
                System.out.println("NO");
            return;
        }
       else if (players[f1].naghsh == -3) {
            players[f2].nejat_pezeshk = 1;
            return;
        }
       else if (players[f1].naghsh == 3) {
            players[f2].silent = true;
            return;
        }
       else if (players[f1].naghsh == 1 || players[f1].naghsh == 2) {
            return;
        }
    }
    public static void night_part2(int [] nazar){
        for (int m = 0;m < 100; m++) {
            if (nazar[m] > 0) {
                players[nazar[m]].nightvote++;
                continue; }
            else
                continue;
        }
        int max=-1;
        int max_1=-1;
        int max_2=-1,tedad_mosavi=0;
        for (int v=0;v<n;v++){
            if(players[v].nightvote>max){
                max=players[v].nightvote;
                max_1=v;}
        }
        for (int b=0;b<n;b++){
            if(players[b].nightvote==max){
                tedad_mosavi++;
                max_2=b; }
        }
        if (tedad_mosavi==0){
            if(players[max_1].nejat_pezeshk==1){
                System.out.println("nobody died");
                return;}
            if(players[max_1].nejat_pezeshk==0){
            players[max_1].dead=1;
            System.out.println(players[max_1].name+" was killed");
            return;}
            if (players[max_1].bulletproof==1){
                System.out.println("nobody died");
                players[max_1].bulletproof=0;
                return;
            }
        }
        if(tedad_mosavi==1){
            if(players[max_1].nejat_pezeshk==1&&players[max_2].nejat_pezeshk==0){
                players[max_2].dead=1;
                System.out.println(players[max_2].name+" was killed");
                 return;}
            if(players[max_1].nejat_pezeshk==0&&players[max_2].nejat_pezeshk==1){
                players[max_1].dead=1;
                System.out.println(players[max_1].name+" was killed");
                 return;}
            if(players[max_1].nejat_pezeshk==0&&players[max_2].nejat_pezeshk==0){
                System.out.println("nobody died");
                return;}
        }
        if (tedad_mosavi>1){
            System.out.println("nobody died");
            return;}
    }
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int i=0;
        int dor=0;
        int day=0,night=0;
       out: while (true) {
           String a = scanner.nextLine();
           if (i == 0 && a.contains("create")) {
               int space = a.indexOf(" ");
               String c1 = a.substring(space + 1);
               String[] c2 = new String[1000];
               for (int j = 0; c1.indexOf(" ") != 0; j++) {
                   space = c1.indexOf(" ");
                   String p = c1.substring(0, space);
                   c1 = c1.substring(space + 1);
                   c2[j] = p;
                   n++;
               }
               create(c2, n);
               i++;
               continue;
           } else if (i == 0) {
               System.out.println("no game created");
               continue;
           } else {
               if (a.contains("assign")) {
                   assign(a);
                   i++;
                   continue;
               }
               if (a.contains("start")) {
                   if (dor > 0) {
                       System.out.println("game has already started");
                       continue;
                   } else {
                       start();
                       dor++;
                       i++;
                   }
               }
               mid:while (true) {
                   day++;
                   String si = " ";
                   for (int z = 0; z < n; z++) {
                       if (players[z].silent) {
                           si = players[z].name; }
                   }
                   String vote = " ";
                   System.out.println("Day" + day);
                   in:while (true) {
                       vote = scanner.nextLine();
                       if (vote.contains("end_vote")) {
                           System.out.println(day_result());
                           if (day_result().contains("Joker won!")) {
                               break out;
                           } else
                               break in;
                       } else {
                           day(vote, si);
                       }
                   }
                   night++;
                   System.out.println("Night" + night);
                   int tedad = 0;
                   for (int x = 0; x < n; x++) {
                       if (players[x].dead == 0) {
                           if (players[x].naghsh == 1 || players[x].naghsh == -2 || players[x].naghsh == -3 || players[x].naghsh == 2) {
                               System.out.print(players[x].name);
                               System.out.println(":" + players[x].naghsh1);
                               tedad++; }
                           if (players[x].naghsh == 3) {
                               System.out.print(players[x].name);
                               System.out.println(":" + players[x].naghsh1);
                               tedad++; }
                       }
                       else
                           continue;
                   }
                  inner: while (true) {
                       String shab = scanner.nextLine();
                       int f1 = 0, f2 = 0;
                       String fael = shab.substring(0, shab.indexOf(" "));
                       String mafuol = shab.substring(shab.indexOf(" ") + 1);
                       if (shab.contains("end night")) {
                           continue mid; }
                       else {
                           night_part1(shab);
                           if (players[f1].naghsh == 1 || players[f1].naghsh == 2) {
                               int[] ray = new int[100];
                               ray[f1] = f2;
                              in2: while (true) {
                                   String vote_n = scanner.nextLine();
                                   if (vote_n.contains("end vote")) {
                                      night_part2(ray);
                                      continue mid; }
                                   else {
                                       String voter_n = vote_n.substring(0, vote_n.indexOf(" "));
                                       String vote_to_n = vote_n.substring(vote_n.indexOf(" ") + 1);
                                       int v1 = 0, v2 = 0;
                                       for (int y = 0; y < n; y++) {
                                           if (voter_n.equals(players[y].name)) {
                                               v1 = y; }
                                           if (vote_to_n.equals(players[y].name)) {
                                               v2 = y; }
                                       }
                                       ray[v1] = v2;
                                       continue in2;
                                   }
                               }
                           }
                           continue inner;
                       }
                   }
               }
           }


       }}
}
