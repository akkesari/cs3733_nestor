package akkesari;

import ks.common.games.Solitaire;
import ks.common.model.BuildablePile;
import ks.common.model.Column;
import ks.common.model.Deck;
import ks.common.model.Pile;
import ks.common.view.BuildablePileView;
import ks.common.view.CardImages;
import ks.common.view.ColumnView;
import ks.common.view.DeckView;
import ks.common.view.IntegerView;
import ks.common.view.PileView;
import ks.launcher.Main;

public class Nestor extends Solitaire {

	// Model
	Deck deck;
	Pile wastePile;
	Column columns[] = new Column[9];
	BuildablePile reserve;
	// Views
	DeckView deckView;
	PileView wastePileView;
	BuildablePileView reserveView;
	ColumnView columnView[] = new ColumnView[9];
	IntegerView scoreView;
	IntegerView numLeftView;
	
	@Override
	public String getName() {
		return "akkesari-Nestor";
	}

	@Override
	public boolean hasWon() {
		return false;
	}

	@Override
	public void initialize() {
		// initialize model
		initializeModel(getSeed());
		initializeView();
		initializeControllers();

		// prepare game by creating the deck etc
		updateScore(0);
		updateNumberCardsLeft (52);
		
	}

	private void initializeControllers() {
		// TODO Auto-generated method stub
		
	}

	private void initializeView() {
		// Initialize the view
		CardImages ci = getCardImages();

		// Create deck view
		deckView = new DeckView (deck);
		deckView.setBounds (20,20, ci.getWidth(), ci.getHeight());
		container.addWidget (deckView);
		
		// Create waste pile view
		wastePileView = new PileView(wastePile);
		wastePileView.setBounds(20 + 10 * ci.getWidth(), 20 + 2 * ci.getHeight(), ci.getWidth(), ci.getHeight());
		container.addWidget(wastePileView);
		
		// Create reserve pile view
		reserveView = new BuildablePileView(reserve);
		reserveView.setBounds(20 + 3 * ci.getWidth(), 20 + 2 * ci.getHeight(), ci.getWidth(), ci.getHeight());
		container.addWidget(reserveView);
		
		// Create the 8 column views
		for(int i = 1; i <= 8; i++){
			columnView[i] = new ColumnView(columns[i]);
			columnView[i].setBounds(20 + i * ci.getWidth(), 20, ci.getWidth(), ci.getHeight());
			container.addWidget(columnView[i]);
		}
		
		// Create the score view
		scoreView = new IntegerView (getScore());
		scoreView.setFontSize(14);
		scoreView.setBounds (20 + 3 * ci.getWidth(), 20 + 4 * ci.getHeight(), 160, 60);
		container.addWidget (scoreView);

		// Create the cards left view
		numLeftView = new IntegerView (getNumLeft());
		numLeftView.setFontSize(14);
		numLeftView.setBounds (20 + 6 * ci.getWidth(), 20 + 4 * ci.getHeight(), 160, 60);
		container.addWidget (numLeftView);
		
	}

	private void initializeModel(int seed) {
		// Create and shuffle deck with a random seed. Add it to the model.
		deck = new Deck("deck");
		deck.create(seed);
		model.addElement (deck);   // add to our model (as defined within our superclass).
		
		// Create a waste pile and add it to the model..
		wastePile = new Pile("waste");
		model.addElement(wastePile);
		
		// Create the 8 columns and add them to the model.
		for(int i = 1; i<=8; i++){
			columns[i] = new Column("column" + i);
			model.addElement(columns[i]);
		}
		
		// Create the reserve pile and add it to the model.
		reserve = new BuildablePile("reserve");
		model.addElement(reserve);
		
		// Initialize the score and the number of cards.
		updateScore(0);
		updateNumberCardsLeft (52);
		
	}
	
	/** Code to launch solitaire variation. */
	public static void main (String []args) {
		// Seed is to ensure we get the same initial cards every time.
		// Here the seed is to "order by suit."
		Main.generateWindow(new Nestor(), Deck.OrderBySuit);
	}

}
