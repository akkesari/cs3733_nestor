package akkesari;

import ks.common.games.Solitaire;
import ks.common.model.BuildablePile;
import ks.common.model.Column;
import ks.common.model.Deck;
import ks.common.model.Pile;
import ks.common.view.BuildablePileView;
import ks.common.view.ColumnView;
import ks.common.view.DeckView;
import ks.common.view.IntegerView;
import ks.common.view.PileView;

public class Nestor extends Solitaire {

	// Model
	Deck deck;
	Pile wastePile;
	Column columns[];
	BuildablePile reserve;
	// Views
	DeckView deckView;
	PileView wastePileView;
	BuildablePileView reserveView;
	ColumnView[] columnView;
	IntegerView scoreView;
	
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
		// TODO Auto-generated method stub
		
	}

	private void initializeModel(int seed) {
		// Create and shuffle deck with a random seed. Add it to the model.
		deck = new Deck("deck");
		deck.create(seed);
		model.addElement (deck);   // add to our model (as defined within our superclass).
		
		// Create a waste pile and add it to the model..
		wastePile = new Pile("waste");
		model.addElement(wastePile);
		
		// Create the 4 columns and add them to the model.
		for(int i = 1; i<=4; i++){
			columns[i] = new Column("column" + i);
			model.addElement(columns[i]);
		}
		
		// Create the reserve pile and add it to the model.
		reserve = new BuildablePile("reserve");
		model.addElement(reserve);
		
		
		
		
	}

}
