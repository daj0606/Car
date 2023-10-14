// changed line 56 from original "l.getId() + " : " + l.toString()" because it was returning "51 : model.ListItem@669d2b1b"
import java.util.List;
import java.util.Scanner;

import controller.OwnerHelper;
import model.Owner;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static OwnerHelper oh = new OwnerHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter owner name: ");
			String game = in.nextLine();
			System.out.print("Enter owner contact number: ");
			String rank = in.nextLine();
			Owner toAdd = new Owner(game, rank);
			oh.InsertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the name to delete: ");
			String game = in.nextLine();
			System.out.print("Enter the contact number to delete: ");
			String rank = in.nextLine();
			Owner toDelete = new Owner(game, rank);
			oh.deleteItem(toDelete);
		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Game");
			System.out.println("2 : Search by Rank");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Owner> foundItems;
			
			if (searchBy == 1) {
				System.out.print("Enter the owner name: ");
				String ownerName = in.nextLine();
				foundItems = oh.searchForOwnerByName(ownerName);
			} else {
				System.out.print("Enter the owner contact number: ");
				String ownerContactNumber = in.nextLine();
				foundItems = oh.searchForOwnerByContactNumber(ownerContactNumber);
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (Owner l : foundItems) {
					// changed from original "l.getId() + " : " + l.toString()" because it was returning "51 : model.ListItem@669d2b1b"
					System.out.println(l.getId() + " - " + l.returnOwnerDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Owner toEdit = oh.searchForOwnerById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getContactNumber());
				System.out.println("1 : Update Name");
				System.out.println("2 : Update Contact Number");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 2) {
					System.out.print("New Contact Number: ");
					String newContactNumber = in.nextLine();
					toEdit.setContactNumber(newContactNumber);
				}

				oh.updateOwner(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to my rank viewer! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a game");
				System.out.println("*  2 -- Update a rank");
				System.out.println("*  3 -- Delete a game");
				System.out.println("*  4 -- View all games and ranks");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					oh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<Owner> allItems = oh.showAllOwners();
			
			for(Owner singleItem : allItems) {
				// added "singleItem.getId()" to show item ID for more details
				System.out.println(singleItem.getId() + " - " + singleItem.returnOwnerDetails());
			}
			

		}

}