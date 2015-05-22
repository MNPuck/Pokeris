package com.nowhereinc.Pokeris.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.nowhereinc.Pokeris.game.Assets;
import com.nowhereinc.Pokeris.game.Level;
import com.nowhereinc.Pokeris.util.Constants;

public class Card extends AbstractGameObject {
	
	public static final String TAG = Level.class.getName();
	
	private TextureRegion Card;
	
    private final int rank;
    private final int suit;

    // Kinds of suits
    public final static int DIAMONDS = 1;
    public final static int CLUBS    = 2;
    public final static int HEARTS   = 3;
    public final static int SPADES   = 4;

    // Kinds of ranks
    public final static int ACE   = 1;
    public final static int DEUCE = 2;
    public final static int THREE = 3;
    public final static int FOUR  = 4;
    public final static int FIVE  = 5;
    public final static int SIX   = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE  = 9;
    public final static int TEN   = 10;
    public final static int JACK  = 11;
    public final static int QUEEN = 12;
    public final static int KING  = 13;

    public Card(int rank, int suit) {
        assert isValidRank(rank);
        assert isValidSuit(suit);
        this.rank = rank;
        this.suit = suit;
        
        init();
    }
    
    private void init() {
    	
    	dimension.set(Constants.CARDXSIZE, Constants.CARDYSIZE);
    	
    	if (rank == 1 && suit == 1) {
    		
    		Card = Assets.instance.card1.card1;
    		
    	}
    	
    	if (rank == 1 && suit == 2) {
    		
    		Card = Assets.instance.card2.card2;
    		
    	}
    	
    	if (rank == 1 && suit == 3) {
    		
    		Card = Assets.instance.card3.card3;
    		
    	}
    	
    	if (rank == 1 && suit == 4) {
    		
    		Card = Assets.instance.card4.card4;
    		
    	}
    	
    	if (rank == 13 && suit == 1) {
    		
    		Card = Assets.instance.card5.card5;
    		
    	}
    	
    	if (rank == 13 && suit == 2) {
    		
    		Card = Assets.instance.card6.card6;
    		
    	}
    	
    	if (rank == 13 && suit == 3) {
    		
    		Card = Assets.instance.card7.card7;
    		
    	}
    	
    	if (rank == 13 && suit == 4) {
    		
    		Card = Assets.instance.card8.card8;
    		
    	}
    	
    	if (rank == 12 && suit == 1) {
    		
    		Card = Assets.instance.card9.card9;
    		
    	}
    	
    	if (rank == 12 && suit == 2) {
    		
    		Card = Assets.instance.card10.card10;
    		
    	}
    	
    	if (rank == 12 && suit == 3) {
    		
    		Card = Assets.instance.card11.card11;
    		
    	}
    	
    	if (rank == 12 && suit == 4) {
    		
    		Card = Assets.instance.card12.card12;
    		
    	}
    	
    	if (rank == 11 && suit == 1) {
    		
    		Card = Assets.instance.card13.card13;
    		
    	}
    	
    	if (rank == 11 && suit == 2) {
    		
    		Card = Assets.instance.card14.card14;
    		
    	}
    	
    	if (rank == 11 && suit == 3) {
    		
    		Card = Assets.instance.card15.card15;
    		
    	}
    	
    	if (rank == 11 && suit == 4) {
    		
    		Card = Assets.instance.card16.card16;
    		
    	}
    	
    	if (rank == 10 && suit == 1) {
    		
    		Card = Assets.instance.card17.card17;
    		
    	}
    	
    	if (rank == 10 && suit == 2) {
    		
    		Card = Assets.instance.card18.card18;
    		
    	}
    	
    	if (rank == 10 && suit == 3) {
    		
    		Card = Assets.instance.card19.card19;
    		
    	}
    	
    	if (rank == 10 && suit == 4) {
    		
    		Card = Assets.instance.card20.card20;
    		
    	}
    	
    	if (rank == 9 && suit == 1) {
    		
    		Card = Assets.instance.card21.card21;
    		
    	}
    	
    	if (rank == 9 && suit == 2) {
    		
    		Card = Assets.instance.card22.card22;
    		
    	}
    	
    	if (rank == 9 && suit == 3) {
    		
    		Card = Assets.instance.card23.card23;
    		
    	}
    	
    	if (rank == 9 && suit == 4) {
    		
    		Card = Assets.instance.card24.card24;
    		
    	}
    	
    	if (rank == 8 && suit == 1) {
    		
    		Card = Assets.instance.card25.card25;
    		
    	}
    	
    	if (rank == 8 && suit == 2) {
    		
    		Card = Assets.instance.card26.card26;
    		
    	}
    	
    	if (rank == 8 && suit == 3) {
    		
    		Card = Assets.instance.card27.card27;
    		
    	}
    	
    	if (rank == 8 && suit == 4) {
    		
    		Card = Assets.instance.card28.card28;
    		
    	}
    	
    	if (rank == 7 && suit == 1) {
    		
    		Card = Assets.instance.card29.card29;
    		
    	}
    	
    	if (rank == 7 && suit == 2) {
    		
    		Card = Assets.instance.card30.card30;
    		
    	}
    	
    	if (rank == 7 && suit == 3) {
    		
    		Card = Assets.instance.card31.card31;
    		
    	}
    	
    	if (rank == 7 && suit == 4) {
    		
    		Card = Assets.instance.card32.card32;
    		
    	}
    	
    	if (rank == 6 && suit == 1) {
    		
    		Card = Assets.instance.card33.card33;
    		
    	}
    	
    	if (rank == 6 && suit == 2) {
    		
    		Card = Assets.instance.card34.card34;
    		
    	}
    	
    	if (rank == 6 && suit == 3) {
    		
    		Card = Assets.instance.card35.card35;
    		
    	}
    	
    	if (rank == 6 && suit == 4) {
    		
    		Card = Assets.instance.card36.card36;
    		
    	}
    	
    	if (rank == 5 && suit == 1) {
    		
    		Card = Assets.instance.card37.card37;
    		
    	}
    	
    	if (rank == 5 && suit == 2) {
    		
    		Card = Assets.instance.card38.card38;
    		
    	}
    	
    	if (rank == 5 && suit == 3) {
    		
    		Card = Assets.instance.card39.card39;
    		
    	}
    	
    	if (rank == 5 && suit == 4) {
    		
    		Card = Assets.instance.card40.card40;
    		
    	}
    	
    	if (rank == 3 && suit == 1) {
    		
    		Card = Assets.instance.card41.card41;
    		
    	}
    	
    	if (rank == 3 && suit == 2) {
    		
    		Card = Assets.instance.card42.card42;
    		
    	}
    	
    	if (rank == 3 && suit == 3) {
    		
    		Card = Assets.instance.card43.card43;
    		
    	}
    	
    	if (rank == 4 && suit == 4) {
    		
    		Card = Assets.instance.card44.card44;
    		
    	}
    	
    	if (rank == 3 && suit == 1) {
    		
    		Card = Assets.instance.card45.card45;
    		
    	}
    	
    	if (rank == 3 && suit == 2) {
    		
    		Card = Assets.instance.card46.card46;
    		
    	}
    	
    	if (rank == 3 && suit == 3) {
    		
    		Card = Assets.instance.card47.card47;
    		
    	}
    	
    	if (rank == 3 && suit == 4) {
    		
    		Card = Assets.instance.card48.card48;
    		
    	}
    	
    	if (rank == 2 && suit == 1) {
    		
    		Card = Assets.instance.card49.card49;
    		
    	}
    	
    	if (rank == 2 && suit == 2) {
    		
    		Card = Assets.instance.card50.card50;
    		
    	}
    	
    	if (rank == 2 && suit == 3) {
    		
    		Card = Assets.instance.card51.card51;
    		
    	}
    	
    	if (rank == 2 && suit == 4) {
    		
    		Card = Assets.instance.card52.card52;
    		
    	}
    	
		// init physics values
		
		terminalVelocity.x = 2;
		terminalVelocity.y = 2;
		friction.x = 0;
		friction.y = 0;
		accleration.x = 5;
		accleration.y = 5;
		velocity.x = 0;
		velocity.y = 0;
    	
    }
    
    public void setPosition(Vector2 pos) {
    	
    	position = pos;
    	
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public static boolean isValidRank(int rank) {
        return ACE <= rank && rank <= KING;
    }

    public static boolean isValidSuit(int suit) {
        return DIAMONDS <= suit && suit <= SPADES;
    }

    public static String rankToString(int rank) {
        switch (rank) {
        case ACE:
            return "Ace";
        case DEUCE:
            return "Deuce";
        case THREE:
            return "Three";
        case FOUR:
            return "Four";
        case FIVE:
            return "Five";
        case SIX:
            return "Six";
        case SEVEN:
            return "Seven";
        case EIGHT:
            return "Eight";
        case NINE:
            return "Nine";
        case TEN:
            return "Ten";
        case JACK:
            return "Jack";
        case QUEEN:
            return "Queen";
        case KING:
            return "King";
        default:
            return null;
        }    
    }
    
    public static String suitToString(int suit) {
        switch (suit) {
        case DIAMONDS:
            return "Diamonds";
        case CLUBS:
            return "Clubs";
        case HEARTS:
            return "Hearts";
        case SPADES:
            return "Spades";
        default:
            return null;
        }    
    }

    public void update (float deltaTime) {
    	
    	// if velocity y is zero start by moving card down
    	
    	if (velocity.y == 0) {
    		
    		velocity.y = -1.0f;
    		
    	}
    	
		// check to see if enemy is below bottom of game board, if so; place bottom of board and change velocity to 0
		
		if (position.y - Constants.CARDYSIZE * .5f < - Constants.GAMEBOARD_HEIGHT * .5f ) {
			
			velocity.y = 0.0f;
			
		}
		
		// get new velocity
		
		velocity.y += accleration.y * deltaTime * velocity.y;
		
		// limit speed to terminal velocity
		
		velocity.y = MathUtils.clamp(velocity.y, -terminalVelocity.y, terminalVelocity.y);
		
		//update position y
		
		position.y += velocity.y * deltaTime;
    	
    }
    
	public void render (SpriteBatch batch) {
		
		TextureRegion reg = null;
		
		float newPositionx = position.x - (dimension.x * .5f);
		float newPositiony = position.y - (dimension.y * .5f);

		reg = Card;
		
		batch.draw(reg.getTexture(), newPositionx, newPositiony, origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y,
			rotation, reg.getRegionX(), reg.getRegionY(), reg.getRegionWidth(), reg.getRegionHeight(), false, false);
		
	}
}
