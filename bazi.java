import java.util.Scanner;
public class bazi {
    static bazikon []players =new bazikon[1000];
    static int n;
    {
        for (int i=0;i<n;i++){
            players[i]=new bazikon(); }
    }
    public static void taeen_naghsh(String name,String n,int i){
        if(n.equals("mafia")){
           players[i]=new mafia(name);
        }
        else if(n.equals("doctor")){
            players[i]=new doctor(name);
        }
        else if(n.equals("detective")){
            players[i]=new detective(name);

        }
        else if(n.equals("villager")){
            players[i]=new villager(name);
        }
        else if(n.equals("Joker")){
            players[i]=new Joker(name);
        }
        else if(n.equals("bulletproof")){
            players[i]=new bulletproof(name);
        }
        else if(n.equals("godfather")){
            players[i]=new godfather(name);
        }
        else   if(n.equals("silencer")){
            players[i]=new silencer(name);
        }
        else {
            System.out.println("role not found");
        }
    }

    public static int chek(){
         int tedad_ma=0,tedad_shahr=0;
      for (int i=0;i<n;i++){
          if(players[i].dead==0&&(players[i].naghsh==1||players[i].naghsh==2||players[i].naghsh==3)){
              tedad_ma++;
          }
          if(players[i].dead==0&&(players[i].naghsh==-1||players[i].naghsh==-2||players[i].naghsh==-3||players[i].naghsh==-4)){
              tedad_shahr++;
          }
      }
      if (tedad_ma>=tedad_shahr){
          return 1;
      }
      if (tedad_ma==0&&tedad_shahr>0){
          return -1;
      }
      else
          return 0;
     }
     public static boolean mojod(String name){
         for (int i=0;i<n;i++){
             if(players[i].name.equals(name)){
                 return true;
             }
         }
         return false;
     }
     public static void get_game_state(){
         int tedad_ma=0,tedad_shahr=0;
         for (int i=0;i<n;i++){
             if(players[i].dead==0&&(players[i].naghsh==1||players[i].naghsh==2||players[i].naghsh==3)){
                 tedad_ma++;
             }
             if(players[i].dead==0&&(players[i].naghsh==-1||players[i].naghsh==-2||players[i].naghsh==-3)){
                 tedad_shahr++;
             }
         }
         String mafi="Mafia ="+tedad_ma;
         String shahr="Villager ="+tedad_shahr;
         System.out.println(mafi);
         System.out.println(shahr);
     }
    public static String [] create(String [] a ,int n) {
        String [] names=new String[n];
        for (int i=0 ;i<n;i++){
            names[i]=a[i];
        }
        return names;
    }
    public static void assign(String a,String[] names){
        int s1=a.indexOf(" ");
        a=a.substring(s1+1);
        int s2=a.indexOf(" ");
        String b=a.substring(0,s2);
        String c=a.substring(s2+1);
        int x=0;
        for (int i=0;i<n;i++){
            if(names[i].equals(b)){
                taeen_naghsh(b,c,i);
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
            if(players[y].name.contains(voter)){
            }
            else
                tedad++;
        }
        for (int y=0;y<n;y++){
            if(players[y].name.equals(voter)&&players[y].dead==1){
                System.out.println("voter is dead");
                return; }
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
        }
        int tedad=0;
        for (int z = 0; z < n; z++) {
            if (max == players[z].dayvote) {
                tedad++;
            }
        }

        if (tedad>1){
            return "nobody died";}

        if (players[dead].naghsh == 4) {
                return "Joker won!"; }
        else {
            String result = day_dead + " " + " died";
            players[dead].dead=1;
            return result; }
    }
    public static void night_part1(String shab){
        int f1 = 0, f2 = 0;
        String fael = shab.substring(0,shab.indexOf(" "));
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
         else if (players[f1].naghsh == -2&&((detective)players[f1]).tedad_estelam==1) {
             if(mojod(mafuol)){
                 if(players[f2].dead==1){
                     System.out.println("suspect is dead");
                     return; }
                 if (players[f2].naghsh == 1 || players[f2].naghsh == 2) {
                     System.out.println("YES");
                 } else
                     System.out.println("NO");
                 ((detective)players[f1]).tedad_estelam=0;
                 return;}
             else{
                 System.out.println("user not found");
                 return; }
         }
        else if (players[f1].naghsh == 4 || players[f1].naghsh== -1 || players[f1].naghsh ==-4) {
            System.out.println("user can not wake up during night");
           return;
        }
       else if(players[f1].naghsh == -2&&((detective)players[f1]).tedad_estelam==0){
            System.out.println("detective has already asked");
            return;
        }
       else if (players[f1].naghsh == -3) {
            players[f2].nejat_pezeshk = 1;
            return;
        }
       else if (players[f1].naghsh == 2) {
            players[f2].silent = true;
            return;
        }
       else if (players[f1].naghsh == 1 || players[f1].naghsh == 3) {
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
        if (tedad_mosavi==1){
            if(players[max_1].nejat_pezeshk==1){
                System.out.println("mafia tried to kill "+players[max_1].name);
                System.out.println("nobody died");
                return;}
            if(players[max_1] instanceof bulletproof){
            if (((bulletproof)players[max_1]).bulletproof==1){
                System.out.println("nobody died");
                ((bulletproof)players[max_1]).bulletproof=0;
                return;}
            }
            if(players[max_1].nejat_pezeshk==0){
            players[max_1].dead=1;
            System.out.println("mafia tried to kill "+players[max_1].name);
            System.out.println(players[max_1].name+" was killed");
            return;}
        }
        if(tedad_mosavi==2){
            if(players[max_1].nejat_pezeshk==1&&players[max_2].nejat_pezeshk==0){
                players[max_2].dead=1;
                System.out.println("mafia tried to kill "+players[max_2].name);
                System.out.println(players[max_2].name+" was killed");
                 return;}
            if(players[max_1].nejat_pezeshk==0&&players[max_2].nejat_pezeshk==1){
                players[max_1].dead=1;
                System.out.println("mafia tried to kill "+players[max_1].name);
                System.out.println(players[max_1].name+" was killed");
                 return;}
            if(players[max_1].nejat_pezeshk==0&&players[max_2].nejat_pezeshk==0){
                System.out.println("nobody died");
                return;}
        }
        if (tedad_mosavi>2){
            System.out.println("nobody died");
            return;}
    }
    public static void renew(){
         for (int j=0;j<n;j++){
             if (players[j].silent){
                 players[j].silent=false; }
             if(players[j].nejat_pezeshk==1){
                 players[j].nejat_pezeshk=0; }
             if (players[j].nightvote>0){
                 players[j].nightvote=0; }
             if (players[j].naghsh==-2){
                 ((detective)players[j]).tedad_estelam=1; }
         }
    }
    public static String swap(String a){
        int index_1=0,index_2=0;
        int s1=a.indexOf(" ");
        String a1=a.substring(s1+1);
        int s2=a1.indexOf(" ");
        String a2=a1.substring(0,s2);
        String a3=a1.substring(s2+1);
        for (int y = 0; y < n; y++) {
            if (a2.equals(players[y].name)) {
                index_1 = y;
            }
            if (a3.equals(players[y].name)) {
                index_2 = y;
            }
        }
        if(players[index_1].dead==1||players[index_2].dead==1){
            return "false";
        }
        else {
            players[index_1].name=a3;
            players[index_2].name=a2;
           return a2+" "+"swapped characters with "+a3;
        }
    }
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int i=0;
        int dor=0;
        int payan=0;
        int day=0,night=0;
        String[] c2 = new String[1000];
       out: while (true) {
           String a = scanner.nextLine();
           if (i == 0 && a.contains("create")) {
               int space = a.indexOf(" ");
               String c1 = a.substring(space + 1);
               for (int j = 0; c1.contains(" ");j++) {
                   space = c1.indexOf(" ");
                   String p = c1.substring(0, space);
                   c1 = c1.substring(space + 1);
                   c2[j] = p;
                   n++;
               }
               c2[n]=c1;
               n++;
               create(c2,n);
               i++;
               continue;
           } else if (i == 0) {
               System.out.println("no game created");
               continue;
           } else {
               if (a.contains("assign")) {
                   assign(a,create(c2,n));
                   i++;
                   continue;
               }
               if(a.contains("get")){
                   get_game_state();
                   continue ;
               }
               if (a.contains("start")) {
                   if (dor > 0) {
                       System.out.println("game has already started");
                       continue; }
                   else {
                       start();
                       dor++;
                       i++; }
               }

               mid:
               while (true) {
                   if (chek() == 1) {
                       System.out.println("Mafia won!");
                       break out;
                   }
                   if (chek() == -1) {
                       System.out.println("Villagers won!");
                       break out;
                   }
                   if (chek() == 0) {
                       day++;
                       System.out.println("Day" + day);
                       String si = " ";
                       for (int z = 0; z < n; z++) {
                           if (players[z].silent) {
                               si = players[z].name;
                           }
                       }
                       String vote = " ";
                       in:
                       while (true) {
                           vote = scanner.nextLine();
                           if(vote.contains("swap")){
                               System.out.println("voting in progress");
                               continue in;
                           }
                           if(vote.contains("get")){
                               get_game_state();
                               continue in;
                           }
                           if(vote.contains("start")){
                               System.out.println("game has already started");
                               continue; }
                           if (vote.contains("end_vote")) {
                               System.out.println(day_result());
                               if (day_result().contains("Joker won!")) {
                                   break out;}
                                else {
                                   for (int j = 0; j < n; j++) {
                                       players[j].dayvote = 0;
                                   }
                                   renew();
                                   break in;
                               }
                           } else {
                               day(vote, si);
                           }
                       }
                       if (chek() == 1) {
                           System.out.println("Mafia won!");
                           break out;
                       }
                       if (chek() == -1) {
                           System.out.println("Villagers won!");
                           break out;
                       }
                       if (chek() == 0) {
                           night++;
                           System.out.println("Night" + night);
                           int tedad = 0;
                           for (int x = 0; x < n; x++) {
                               if (players[x].dead == 0) {
                                   if (players[x].naghsh == 1 || players[x].naghsh == -2 || players[x].naghsh == -3 || players[x].naghsh == 2) {
                                       System.out.print(players[x].name);
                                       System.out.println(":" + players[x].naghsh1);
                                       tedad++;
                                   }
                                   if (players[x].naghsh == 3) {
                                       System.out.print(players[x].name);
                                       System.out.println(":" + players[x].naghsh1);
                                       tedad++;
                                   }
                               } else
                                   continue;
                           }
                           inner:
                           while (true) {
                               String shab = scanner.nextLine();
                               if(shab.contains("swap")){
                                   System.out.println("can’t swap before end of night");
                                   continue inner;
                               }
                               if(shab.contains("get")){
                                   get_game_state();
                                   continue inner;
                               }
                               if(shab.contains("start")){
                                   System.out.println("game has already started");
                                   continue inner;}
                               if (shab.contains("end_night")) {
                                   continue mid; }
                               else {
                                   night_part1(shab);
                                   int f1 = 0, f2 = 0;
                                   String fael = shab.substring(0, shab.indexOf(" "));
                                   String mafuol = shab.substring(shab.indexOf(" ") + 1);
                                   for (int y = 0; y < n; y++) {
                                       if (fael.equals(players[y].name)) {
                                           f1 = y; }
                                       if (mafuol.equals(players[y].name)) {
                                           f2 = y; }
                                   }
                                   if (players[f1].naghsh == 1 || players[f1].naghsh == 2 || players[f1].naghsh == 3) {
                                       if (players[f2].dead==1){
                                           System.out.println("votee already dead");
                                           continue inner;
                                       }
                                       int[] ray = new int[100];
                                       if(mojod(mafuol)){
                                       }
                                       else {
                                           System.out.println("user not joined");
                                           continue inner;
                                       }
                                       ray[f1] = f2;
                                       in2:
                                       while (true) {
                                           String vote_n = scanner.nextLine();
                                           if(vote_n.contains("swap")){
                                               System.out.println("can’t swap before end of night");
                                               continue in2;
                                           }
                                           if(vote_n.contains("get")){
                                               get_game_state();
                                               continue in2;
                                           }
                                           if (vote_n.contains("end_night")) {
                                               String swap= scanner.nextLine();
                                               if(swap(swap).contains("false")){
                                                   System.out.println("user is dead");
                                               }
                                               else {
                                                   System.out.println(swap(swap));
                                               }
                                               night_part2(ray);
                                               for (int z=0;z<n;z++){
                                                   if(players[z].dead==0&&players[z].silent){
                                                       System.out.println("Silenced "+players[z].name);
                                                       break;
                                                   }
                                               }
                                               continue mid;
                                           } else {
                                               String voter_n = vote_n.substring(0,vote_n.indexOf(" "));
                                               String vote_to_n = vote_n.substring(vote_n.indexOf(" ") + 1);
                                               int v1 = 0, v2 = 0;
                                               for (int y = 0; y < n; y++) {
                                                   if (voter_n.equals(players[y].name)) {
                                                       v1 = y;
                                                   }
                                                   if (vote_to_n.equals(players[y].name)) {
                                                       v2 = y;
                                                   }
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
               }
           }
           }
     }
}
