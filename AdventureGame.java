import java.util.*;
public class AdventureGame{
    static Scanner ui= new Scanner (System.in);
    static Random r=new Random();
    static String name;
    static int hp, mhp, atk, med, hunger, whp;
    public static int dam = r.nextInt(10)+1;
    public static void startScene() throws InterruptedException{
       System.out.println();
       System.out.println();
       Thread.sleep(2000);
       System.out.print("TYPE YOUR USERNAME : ");
       name=ui.nextLine();
       System.out.println("LET'S BEGIN THE GAME "+name+" !!!");
       Thread.sleep(2000);
       System.out.println();
       System.out.println("You are stranded all alone on a strange island, ");
       Thread.sleep(1500);
       System.out.println("all you can see is silent & endless ocean on one side _⎽-🦈⎻⎺⎺⎻-⎽🦈🦈__⎽--⎻⎺🦈⎺⎻--⎽⎻⎺⎺⎻-⎽🦈__⎽-");
       Thread.sleep(1500);
       System.out.println("and dense & deadly forest on the other🌳🏝🐻🦁🐯");
       Thread.sleep(1500);
       System.out.println(name+" now you must survive in these rigid conditions");
       Thread.sleep(1500);
       System.out.println("and get rescued ......");
       System.out.println();
       System.out.println();
       Thread.sleep(2000);
       s1();
    }
    public static void s1() throws InterruptedException{
        String choice1;
        System.out.println("it is getting darker... you must save yourself... ");
        System.out.println();
        System.out.println("type 'HELP'--- wait for help");
        System.out.println("type 'FOREST'---enter the forest "); 
        choice1=ui.nextLine();
        if(choice1.equals("HELP")||choice1.equals("help")){
            Thread.sleep(1000);
            System.out.println("10 hours of waiting proved to be unfruitful,");
            Thread.sleep(1000);
            System.out.println("now I should eat something....");
            Thread.sleep(1000);
            System.out.println("all I can do is enter the forest");
            System.out.println();
            hunger=40;
            hp=hp-25;
            stat();
            s2();
        }
        else if(choice1.equals("FOREST")||choice1.equals("forest")){ 
            Thread.sleep(1000);
            System.out.println("I enter the forest now, I have to find a safe location to spend the night");
            Thread.sleep(1000);
            System.out.println();
            System.out.println("type 'CAVE'--- to enter the cave");
            System.out.println("type 'OPEN'--- to stay in open space"); 
            String c1=ui.nextLine();
            if(c1.equals("cave")||c1.equals("CAVE")){
                System.out.println("I should head over to the cave and rest");
                System.out.println();
                hp=hp+20;
                stat();
                s2();
            }
            else if(c1.equals("OPEN")||c1.equals("open")){
                Thread.sleep(1000);
                System.out.println("its not safe to stay outside during the night,");
                Thread.sleep(1000);
                System.out.println("I should probably head over to the cave and rest");
                System.out.println();
                hunger=hunger+20;
                hp=hp-20;
                stat();
                s2();
            }
            else{
                System.out.println("Enter a valid option");
                System.out.println();
                s1();
            }
        }
        else{
            System.out.println("Enter a valid option");
            System.out.println();
            s1();
        }
    }
    public static void s2() throws InterruptedException{
        String choice2;
        System.out.println();
        Thread.sleep(1000);
        System.out.println("----------------------------------IN THE CAVE--------------------------------------");
        System.out.println();
        Thread.sleep(1000);
        System.out.println("I woke up I see a flare smoke in the sky coming from the center of the forest");
        Thread.sleep(1000);
        System.out.println("you start walking towards the flare"); 
        Thread.sleep(1000);
        System.out.println("but I feel hungry");
        hunger=hunger+20;
        Thread.sleep(1000);
        System.out.println("ohhh!!! there I see some mushrooms ");
        System.out.println();
        System.out.println("type 'EAT'--- to eat");
        System.out.println("type 'MOVE'---to move ahead "); 
        choice2=ui.nextLine();
        if(choice2.equals("EAT")||choice2.equals("eat")){
            System.out.println();
            Thread.sleep(1000);
            System.out.println("HOORAY!!! These mushrooms are edible ");
            Thread.sleep(1000);            
            System.out.println("I eat some mushrooms and YUM they are delicious ....");
            Thread.sleep(1000);
            System.out.println("now i feel better I should move ahead");
            hunger=0;
            hp=hp+10;
            stat();
            s3();
        }
        else if(choice2.equals("MOVE")||choice2.equals("move")){
            hunger = hunger+20;
            hp= hp-10;
            atk=atk-2;
            stat();
            s3();
        }
        else{
            System.out.println("Enter a valid option");
            s2();
        }
    }
    public static void s3() throws InterruptedException{
        System.out.println();
        Thread.sleep(1000);
        System.out.println("------------------------------DEEPER IN THE FOREST-----------------------------------");
        Thread.sleep(1000);
        System.out.println();
        System.out.println("As I move ahead in the dense forest, I hear rustling of dry leaves ");
        Thread.sleep(1000);
        System.out.println("I am shocked and alert... seems like the breath of a wild animal is around");
        Thread.sleep(1000);
        System.out.println("it's a WOLFFFFFF...🐺...🐺...🐺...🐺");
        Thread.sleep(1000);
        System.out.println("now i must defend myself by choosing a weapon");
        Thread.sleep(1000);
        System.out.println();
        fight();
    }
    public static void fight() throws InterruptedException{
        String choice3;
        System.out.println("type 'KNIFE'--- to equip knife");
        System.out.println("type 'STICK'--- to equip a stick lying on the ground");
        choice3=ui.nextLine();
            if(choice3.equals("KNIFE")||choice3.equals("knife")){
            atk=atk+5;
        }
        else if(choice3.equals("STICK")||choice3.equals("stick")){
            atk=atk+2;
        }
        else{
            System.out.println("Enter valid option");
            s3();
        }
        if (whp <= 0) {
            System.out.println("I defeated the Wolf");
            System.out.println("");
            s4();
        }
        else if(hp<=0){
            gameover();
        }
        else{
           while (whp > 0) {
             String c2;
             System.out.println();
             System.out.println("type 'KILL'--- to attack the wolf");
             System.out.println("type 'HEAL'--- to use MedKit");
             c2=ui.nextLine();
              if (c2.equals("attack")||c2.equals("ATTACK")) {
                whp = whp - atk;
                hp = hp - dam;
                System.out.println("You Have Been Hit, Your Health Point is "+ hp);
                System.out.println("Wolf Health Point is "+ whp);
                System.out.println();
                fight();
             }
             else if (c2.equals("heal")|| c2.equals("HEAL")){
                if (med<= 0) {
                    System.out.println("You Do Not Have Enough Meds");
                    fight();
                } 
                else {
                    hp = hp + 30;
                    med=med-1;
                    System.out.println("You Have Been Healed");
                    System.out.println();
                    hp = hp - dam;
                    Thread.sleep(1200);
                    System.out.println("You Have Been Hit, Your HP is "+ hp);
                    System.out.println();
                    fight();
                }
             }
          }
       }
       s4();
    }
    public static void s4() throws InterruptedException{
        String choice4;
        Thread.sleep(2000);
        System.out.println("After a few hours......");
        Thread.sleep(2000);
        System.out.println("All this walking and fighting has exhausted me now I just want to get out of here as soon as possible ");
        Thread.sleep(2000);
        System.out.println("oh no!!! Right when I was about to reach the source of the smoke I come across a RIVER");
        Thread.sleep(2000);
        System.out.println("type 'SWIM'--- to swim across the river");
        System.out.println("type 'RAFT' --- to build a raft");
        choice4 = ui.nextLine();
        if(choice4.equals("SWIM")||choice4.equals("swim")){
           System.out.println("YOU WERE EATEN BY A CROCODILE!!!!!!!!!!!!!");
           hp=0;
           stat();
           gameover();
        }
        else if(choice4.equals("raft")||choice4.equals("RAFT")){
            Thread.sleep(2000);
            System.out.println("I collect 3 logs lying around the river and made a raft");
            Thread.sleep(1000);
            System.out.println("I have successfully crossed the river ");
            Thread.sleep(2000);
            System.out.println("After walking for a few minitues,");
            Thread.sleep(2000);
            System.out.println("I found a rescue team who came to help me and I escaped successfully");
            Thread.sleep(1000);
            hp=mhp;
            System.out.println("HOOORAAYYYYY---------------YOU WINNNNNNN !!!!!!!!!!-------------------------------");
            stat();
        }
    }
    public static void gameover() throws InterruptedException{
        System.out.println("******* :( ******** :( *************** GAME OVER *************** ): ********* ): ******");
        Thread.sleep(2000);
        System.out.println();
        System.out.println("-------------------------------- BETTER LUCK NEXT TIME --------------------------------");
        System.out.println();
        System.out.println();   
             
    }
    public static void stat() throws InterruptedException{
       Thread.sleep(3000);
       System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< STATS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
       System.out.println();
       Thread.sleep(2000); 
       System.out.println("Health Points = "+hp);
       System.out.println("Hunger = "+hunger);
       System.out.println("MedKit = "+med);
       System.out.println("Attack = "+atk);
       System.out.println();       
       System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
      public static void main(String args[]) throws InterruptedException{
       AdventureGame ad= new AdventureGame();
       System.out.println("***************************************************************************************");
       System.out.println("---------------------------------------------------------------------------------------");
       System.out.println("!!!!!!!▬▬ι════════ﺤ!!!!!!! YOU HAVE ENTERED XYZ GAME !!!!!!!!!▬▬ι════════ﺤ!!!!!!!!");
       System.out.println("---------------------------------------------------------------------------------------");
       System.out.println("***************************************************************************************");
       System.out.println();
       mhp=100;
       hp=mhp;
       hunger=0;
       med=3;
       atk=10;
       whp=30;
       ad.stat();
       ad.startScene();
    }
}