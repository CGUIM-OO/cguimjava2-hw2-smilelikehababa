import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: B0527155 Lim Mei Shan  
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: 
 * Under Class Deck, we have 1 variable. As we need to create a deck of cards, hence we create a Array of cards. This is to create a Class Deck, with field: cards and a method: Deck() with parameter integer nDeck, which creates an instance from ArrayList<Card>();
 * We also have a constructor, with an argument nDeck (Data Type: integer). This constructor add all the individual cards into the Array to form the "Deck of cards".
 * Then, we have a void type method which will print out the cards in the Deck and terminates automatically. In which the method printCard() is used. 
 * Lastly, we have another constructor method for getAllCards() which returns the Array type object, cards.
 */
class Deck{
	private ArrayList<Card> cards;
	
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		for(int i=1 ; i <=4; i++)
		{
			for(int j=1; j<=13; j++) {
				Card c = new Card(i,j);
				cards.add(c);
			}
		}
		
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck() {
		for(Card c: cards) {
			c.printCard();
		}
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)

	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: 
 * Under Class Card, there are two variables: suit and rank. These are the characteristic of the card. We privated it because we only want to use it in this Class and not outside of this Class.
 * Under constructor Card(int s, int r), we assigned the variable to a name, so that we can use it later. 
 * Under the method printCard(), we initialise two new variable first to empty strings, then we assign the cases individually. 
 * Lastly, we define two methods to be used later to get our Suit and Rank of a card.  
 */
class Card{
	private int suit;//Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	
	private int rank;//1~13
	
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		String strSuit = ""; 
		String strRank = "";
		switch(this.suit) {
		case 1:
			strSuit = "Clubs";
			break;
		case 2:
			strSuit = "Diamonds";
			break;
		case 3:
			strSuit = "Hearts";
			break;
		case 4:
			strSuit = "Spades";
			break;
		
		}
		switch(this.rank) {
		case 1:
			strRank = "Ace";
			break;
		case 13: 
			strRank = "King";
			break;
		case 12:
			strRank = "Queen";
			break;
		case 11:
			strRank = "Jack";
			break;
		default: 
			strRank = "" + this.rank;
			break;
			
		}
		System.out.println(strSuit + "," + strRank);
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace

	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
