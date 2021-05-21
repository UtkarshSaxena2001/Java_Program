import java.util.Scanner;
public class Final_Voting {
    
    //Declaration of Variables
    static Scanner input = new Scanner(System.in);   
    //variable for design
    public static String[] Design = {"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~",
        "*************************************************************************",
        "-------------------------------------------------------------------------"};
    //A variable for getting the number of votes
    static int count[] = new int[6];
    //A variable for getting the user input and it has been used for the switch case
    static int vote[] = new int[3];
    //A variable used for calling the position
    static String[] positions = {"President", "Vice President" , "Secretary"};
    //A variable that been used for switch case as a validator 
    static String[] position = new String[3];
    //A 2d array that shows the name of candidates 
    static String[][] candidates = {{"Mark Joseph Manalo","Ramil Cobilla"},
          {"Mark John Valenteros","Mary Jane Madarang"},{"Japhet Henette Quinn","Claudio Bereber"}};
    //A variable for Tie Login
    private static String Tpass,Tuser;       
    
    //Main Method
    public static void main(String[] args) {
       // A variable that validates the number of times that the user should vote
       int attempt = 0;
       System.out.printf(Design[0]+"\n\t\tWelcome to our Voting System\n"+Design[0] +"\n");
       do{
        Tlogin();
        boolean log = login(Tuser,Tpass);
            if(log == true){
                System.out.println("Successfully login\n" + Design[1]);
                ++attempt;
                Process();
            }else
                System.out.println("Invalid Username or Password\n" + Design[1]);
            // The attempt 2 is the loop how many times the program will vote
      }while(attempt < 2);
       TieValidator();
       result();
    }
    //Method for Login
    private static boolean login(String user,String pass){
        return user.equals("admin") && pass.equals("12345");
    }
    //Login method if there is a tie 
    private static boolean tielogin(String user,String pass){
        return user.equals("admin") && pass.equals("admin");
    }
    //A method used making the code shorter and calling the three methods: prescounter(), vicecounter(), seccounter
    public static void Process(){
        System.out.print("To vote choose a number from the choices\n");
            prescounter();
            vicecounter();
            seccounter();
        System.out.print(Design[2]+"\nYou successfully voted\n"+Design[2]+"\n");  
    } 
    //A method used for getting the input of user who did they vote for President and count it 
    //Used method for much shorter code
    public static void prescounter(){
         do{
            System.out.printf( Design[1] + "\n\t\tCandidate for %s\n1.%s\n2.%s\nThe number you choose is ",positions[0], candidates[0][0],candidates[0][1]);
            vote[0] = input.nextInt();
                switch(vote[0]){
                    case 1: position[0] = candidates[0][0];
                    count[0]++;
                    break;
                    case 2: position[0] =   candidates[0][1]  ;
                    count[1]++;
                    break;
                    default: position[0]= "Invalid Number";
                    System.out.println("Invalid Number Please Try Again");
                    break;
                }
         }while(position[0].equals("Invalid Number"));      
            System.out.printf("You vote %s for the position of the %s\n",position[0],positions[0]);
    }
    //A method used for getting the input of user who did they vote for Vice President and count it 
    
    public static void vicecounter(){
         do{
            System.out.printf( Design[1] + "\n\t\tCandidate for %s\n1.%s\n2.%s\nThe number you choose is ", positions[1],candidates[1][0],candidates[1][1]);
            vote[1] = input.nextInt();
                switch(vote[1]){
                    case 1: position[1] = candidates[1][0];
                    count[2]++;
                    break;
                    case 2: position[1] = candidates[1][1] ;
                    count[3]++;
                    break;
                    default: position[1]= "Invalid Number";
                    System.out.println("Invalid Number Please Try Again");
                    break;
                }  
         }while(position[1].equals("Invalid Number")); 
            System.out.printf("You vote %s for the position of the %s\n",positions[1],positions[1]);
    }
    //A method used for getting the input of user who did they vote for Secretary and count it 
    public static void seccounter(){
          do{
            System.out.printf( Design[1] + "\n\t\tCandidate for %s \n1.%s\n2.%s\nThe number you choose is ", positions[2],candidates[2][0],candidates[2][1]);
            vote[2] = input.nextInt();
                switch(vote[2]){
                    case 1: position[2] = candidates[2][0];
                    count[4]++;
                    break;
                    case 2: position[2] = candidates[2][1];
                    count[5]++;
                    break;
                    default: position[2]= "Invalid Number";
                    System.out.println("Invalid Number Please Try Again");
                    break;
                }    
          }while(position[2].equals("Invalid Number"));
            System.out.printf("You vote %s for the position of the %s\n",position[2],positions[2]);
    }
    //A method that been used in Tie validator for making the code shorter
    public static void Tlogin(){
       System.out.print("Enter Username: ");
       Tuser = input.next();
       System.out.print("Enter Password: ");
       Tpass = input.next();
    }
    //A method for checking if there is a tie in the result if there is a tie it will required another user to enter the vore
    public static void TieValidator(){
        int validator = 0;
        if(count[0]==count[1] && count[2] == count[3] && count[4] == count[5]){
            do{
                System.out.printf(Design[1] + "\n There is a tie in the position for the %s, %s and %s!\n" 
                        + Design[1] +"\n", positions[0], positions[1], positions[2]);
                Tlogin();
                boolean plog = tielogin(Tuser,Tpass);
                    if(plog == true){
                        ++validator;
                        System.out.println("Successfully login");
                        prescounter();
                        vicecounter();
                        seccounter();
                    }else
                        System.out.println("Invalid Username or Password");
            }while(validator < 1);
        }else if(count[0] == count[1] && count[2] == count[3] && count[4] != count[5]){
           do{
                System.out.printf(Design[1] + "\n There is a tie in the position for the %s and %s!\n" 
                        + Design[1]+"\n",positions[0], positions[1]);
                Tlogin();
                boolean plog = tielogin(Tuser,Tpass);
                    if(plog == true){
                        ++validator;
                        System.out.println("Successfully login");
                        prescounter();
                        vicecounter();
                    }else
                        System.out.println("Invalid Username or Password");
            }while(validator < 1);
       }else if(count[0] != count[1] && count[2] == count[3] && count[4] == count[5]){
            do{
                System.out.printf(Design[1] + "\n There is a tie in the position for the %s and %s!\n" + Design[1]+"\n",positions[1],positions[2]);
                Tlogin();
                boolean plog = tielogin(Tuser,Tpass);
                    if(plog == true){
                        ++validator;
                        System.out.println("Successfully login");
                        vicecounter();
                        seccounter();
                    }else
                        System.out.println("Invalid Username or Password");
            }while(validator < 1);
       }else if(count[0] == count[1] && count[2] != count[3] && count[4] == count[5]){
           do{
                System.out.printf(Design[1] + "\n There is a tie in the position for the %s and %s!\n" + Design[1]+"\n",positions[0],position[2]);
                Tlogin();
                boolean plog = tielogin(Tuser,Tpass);
                    if(plog == true){
                        ++validator;
                        System.out.println("Successfully login");
                        prescounter();
                        seccounter();
                    }else
                        System.out.println("Invalid Username or Password");
            }while(validator < 1);
       }else if(count[0] == count[1] && count[2] != count[3] && count[4] != count[5]){
           do{
                System.out.printf(Design[1] + "\n There is a tie in the position for the %s!\n" + Design[1]+"\n",positions[0]);
                Tlogin();
                boolean plog = tielogin(Tuser,Tpass);
                    if(plog == true){
                        ++validator;
                        System.out.println("Successfully login");
                        prescounter();
                    }else
                        System.out.println("Invalid Username or Password");
            }while(validator < 1);
       }else if(count[0] != count[1] && count[2] == count[3] && count[4] != count[5]){
            do{
                System.out.printf(Design[1] + "\n There is a tie in the position for the %s!\n" + Design[1]+"\n",positions[1]);
                Tlogin();
                boolean plog = tielogin(Tuser,Tpass);
                    if(plog == true){
                        ++validator;
                        System.out.println("Successfully login");
                        vicecounter();                       
                    }else
                        System.out.println("Invalid Username or Password");
            }while(validator < 1);
       }else if(count[0] != count[1] && count[2] != count[3] && count[4] == count[5]){
           do{
                System.out.printf(Design[1] + "\n There is a tie in the position for the %s!\n" + Design[1]+"\n",positions[2]);
                Tlogin();
                boolean plog = tielogin(Tuser,Tpass);
                    if(plog == true){
                        ++validator;
                        System.out.println("Successfully login");
                        seccounter();                       
                    }else
                        System.out.println("Invalid Username or Password");
            }while(validator < 1);
       }
    }
    //A method that been used for getting the number of votes for every candidates and declare who is the winner
    public static void result(){
        System.out.printf(Design[2]+"Voting Result for the %s \n%s = " + count[0] +"\n%s = " 
                + count[1] + "\n"+Design[2] ,positions[0],candidates[0][0],candidates[0][1]);
            if(count[0] > count[1])
                System.out.printf("\n%s won the position for the %s\n",candidates[0][0],positions[0]);
            else
                System.out.printf("\n%s won the position for the %s\n",candidates[0][1],positions[0]);
            
        System.out.printf(Design[2]+"\nVoting Result for the %s\n%s = " + count[2] +"\n%s = " 
                + count[3] + "\n"+Design[2],positions[1],candidates[1][0],candidates[1][1]);
            if(count[2] > count[3])
                System.out.printf("\n%s won the position for the %s\n",candidates[1][0],positions[1]);
            else
                System.out.printf("\n%s won the position for the %s\n",candidates[1][1],positions[1]);
            
        System.out.printf(Design[2]+"\nVoting Result for the %s\n%s = " + count[4] + "\n%s = " 
                + count[5] + "\n"+Design[2],positions[2],candidates[2][0],candidates[2][1]);
            if(count[4] > count[5])
                System.out.printf("\n%s won the position for the %s\n",candidates[2][0],positions[2]);
            else
                System.out.printf("\n%s won the position for the %s",candidates[2][1],positions[2]);
    }
}