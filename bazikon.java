public class bazikon {
   String name;
   String naghsh1;
   int naghsh=0;
   int nightvote;
   int dayvote;
   int nejat_pezeshk;
    boolean silent;
    int dead;
    public  void teeen_naghsh(String n){
        if(n.equals("mafia")){
            naghsh1="mafia";
            naghsh=1;
        }
       else if(n.equals("doctor")){
            naghsh1="doctor";
            naghsh=-3;
        }
       else if(n.equals("detective")){
            naghsh1="detective";
            naghsh=-2;

        }
       else if(n.equals("villager")){
            naghsh1="villager";
            naghsh=-1;
        }
       else if(n.equals("Joker")){
            naghsh1="Joker";
            naghsh=4;
        }
       else if(n.equals("bulletproof")){
            naghsh1="bulletproof";
            naghsh=-4;

        }
      else if(n.equals("godfather")){
            naghsh1="godfather";
            naghsh=3;
        }
      else   if(n.equals("silencer")){
            naghsh1="silencer";
            naghsh=2;
        }
      else {
          System.out.println("role not found");
        }
    }

}
