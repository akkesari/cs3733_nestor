package akkesari;

import ks.common.games.Solitaire;
import ks.common.model.BuildablePile;
import ks.common.model.Column;
import ks.common.model.Deck;
import ks.common.model.Pile;

public class Nestor extends Solitaire {

	Deck deck;
	Pile wastePile;
	Column columns[];
	BuildablePile reserve;
	
	
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
		// TODO Auto-generated method stub
		
	}

}
