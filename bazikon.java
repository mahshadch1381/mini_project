public class bazikon {
   String name;
   String naghsh1;
   int naghsh=0;
    int nightvote=0;
     int dayvote=0;
    int nejat_pezeshk=0;
    boolean silent;
    int dead=0;
    int bulletproof=0;

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
            bulletproof=1;
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
