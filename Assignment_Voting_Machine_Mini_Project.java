import java.util.*;
import java.io.*;
//making class of party
class Partys { 
	static Scanner s = new Scanner(System.in);
	static ArrayList<String> Partys = new ArrayList<String>();
	public void Default() {
		Partys.add("BJP");
		Partys.add("Congress");
		Partys.add("Others");
	}
	//method to add more options for operator
	public void AddOptions(String New_Option) {
			Partys.add(New_Option);
		}
	//method to remove an Option for operator
	public void RemoveOptions(String Option) {
			Partys.remove(Option);
	}
	//method to display the current options to voters
	public void PresentingOptions() {
		System.out.println("Choose the party that you want to win: ");
		System.out.print(Partys);
	}
}
class Voters extends Partys {
	int VoterID;
	String VoterName;
	int VoterPassword;
	int count_1 = 0;
	int count_2 = 0;
	int count_3 = 0; // count for other party
	int count_4 = 0; // 
	static Scanner V = new Scanner(System.in);
	static Scanner C = new Scanner(System.in);
	static Scanner q = new Scanner(System.in);
	static ArrayList<Integer> Voter = new ArrayList<Integer>();
	static ArrayList<Integer> VoterPassWord = new ArrayList<Integer>();
	//method for operator to add voters 
	public void AddVoterId() {
		System.out.print("Enter the Voterid: ");
		VoterID = V.nextInt();
		System.out.print("Enter the name: ");
		VoterName = V.next();
		System.out.print("Enter the Password: ");
		VoterPassword = V.nextInt();
		Voter.add(VoterID);
		VoterPassWord.add(VoterPassword);
	}
	public void RemoveVoterID(int VoterID) {
		Voter.remove(VoterID);
	}
	//method for operator to calculate the votes
	public void CalculateVotes() {
		PresentingOptions();  //displaying options
		System.out.println("\nEnter the party's number: ");
		int y = C.nextInt();
		if (y == 1) {
			count_1++;
		}
		else if (y == 2) {
			count_2++;
		}
		else {
			count_3++;
		}
	}
	public void showWiner() {
		System.out.println("Total votes for BJP is: " +count_1);
		System.out.println("Total votes for Congress is: " +count_2);
		System.out.println("Total votes for Other is: " +count_3);
		if (count_1 > count_2 && count_1 > count_3) {
			System.out.println("BJP wins");
		}
		else if (count_1 < count_2 && count_2 > count_3) {
			System.out.println("Congress wins");
		}
		else if (count_3 > count_2 && count_3 > count_1){
			System.out.println("Other party win");
		}
		else if (count_1 == count_2 && count_1 > count_3) {
			System.out.println("There is a Tie in between BJP and Congress");
			System.out.println("\tTie Breaker\n");
			System.out.println("Please enter Password for Operators vote: ");
			int pas = q.nextInt();
			if (pas == 12345) {
				CalculateVotes();
				showWiner();
			}
		}
		else if (count_1 == count_3 && count_1 > count_2) {
			System.out.println("There is a Tie in between BJP and other");
			System.out.println("\tTie Breaker\n");
			System.out.println("Please enter Password for Operators vote: ");
			int pas = q.nextInt();
			if (pas == 12345) {
				CalculateVotes();
				showWiner();
			}
		}
		else if (count_2 == count_3 && count_2 > count_1) {
			System.out.println("There is a Tie in between Congress and other");
			System.out.println("\tTie Breaker\n");
			System.out.println("Please enter Password for Operators vote: ");
			int pas = q.nextInt();
			if (pas == 12345) {
				CalculateVotes();
				showWiner();
			}
		}
		else {
			System.out.println("No one wins");
		}
	}
}
public class Assignment_Voting_Machine_Mini_Project {
	public static void main(String[] args) throws IOException {
		Scanner user = new Scanner(System.in);
		Scanner str = new Scanner(System.in);
		Scanner bholu = new Scanner(System.in);
		Scanner molu = new Scanner(System.in);
		Partys p = new Partys();
		Voters v = new Voters();	
		int NoOfVoter = 5;
		p.Default();
		System.out.println("Plese tell who is accessing the machine(Voter/Operator): ");
		String u = user.nextLine();
		switch (u) {
		case "Operator" :
			System.out.println("Plese enter Password: ");
			int PassWord = user.nextInt();
			if (PassWord == 12345) {
				System.out.println("Wellcom Operator");
				System.out.println("Do you want to (Add-1/Remove-2/do-nothing-3) the partys: ");
				int answ = str.nextInt();
				if (answ == 1) {
					System.out.println("Name the party that you want to add: ");
					String added = bholu.nextLine();
					p.AddOptions(added);
				}
				else if (answ == 2){
					System.out.println("Name the party that you want to remove: ");
					String rmv = bholu.nextLine();
					p.RemoveOptions(rmv);
				}
				else {
					System.out.println("No part is added");
				}
				System.out.println("Do you want to (Add-1/Remove-2/do-nothing-3) the Voteres: ");
				int answe = molu.nextInt();
				if (answe == 1) {	
					v.AddVoterId();
					NoOfVoter++;
				}
				else if (answe == 2){
					System.out.println("Enter the Id of voter whome You want to remove: ");
					int c = molu.nextInt();
					v.RemoveVoterID(c);
					NoOfVoter--;
				}
				else {
					System.out.println("No voter has been added");
				}
			}
			else {
				System.out.println("Wrong password Access Denied");
			}
			System.out.println("Normal voting Continues :-");
			for (int r=0;r<NoOfVoter;r++) {
				v.CalculateVotes();
			}
			v.showWiner();
			break;
		default : 
			for (int r=0;r<5;r++) {
				v.CalculateVotes();
			}
			v.showWiner();
			break;
		}
	}
}
