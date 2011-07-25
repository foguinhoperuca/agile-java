package br.com.abacomm.agilejava.chess.pieces;

import java.util.EnumMap;
import java.util.Map;

/**
 * A piece represantation to play chess.
 * 
 */
public class Piece implements Comparable<Piece> {
    // public static final String ROOK_REPRESENTATION = "r";
    // public static final String KNIGHT_REPRESENTATION = "n";
    // public static final String BISHOP_REPRESENTATION = "b";
    // public static final String QUEEN_REPRESENTATION = "q";
    // public static final String KING_REPRESENTATION = "k";
    // public static final String PAWN_REPRESENTATION = "p";
    // public static final String NO_PIECE_REPRESENTATION = ".";
    //
    // public static final float QUEEN_STRENGTH = 9f;
    // public static final float ROOK_STRENGTH = 5f;
    // public static final float BISHOP_STRENGTH = 3f;
    // public static final float KNIGHT_STRENGTH = 2.5f;
    // public static final float KING_STRENGTH = 0.0f;
    // public static final float PAWN_ADVANCED_STRENGTH = 1f;
    // public static final float PAWN_SAME_LINE_STRENGTH = 0.5f;

    private Color color;
    protected String name;
    private Type type;
    private static EnumMap<Type, Float> mapStrength = null;

    public enum Color {
	BLACK, WHITE, NO_COLOR
    };

    public enum Type {
	ROOK(5f, "r"), KNIGHT(2.5f, "n"), BISHOP(3f, "b"), QUEEN(9f, "q"), KING(
		0f, "k"), PAWN(0.5f, "p"), NO_PIECE(0f, ".");

	public static final float PAWN_ADVANCED_STRENGTH = 1f;
	private float strength;
	private String representation;

	Type(float _strength, String _representation) {
	    this.strength = _strength;
	    this.setRepresentation(_representation);
	}

	public void setStrength(float strength) {
	    this.strength = strength;
	}

	public float getStrength() {
	    return strength;
	}

	public void setRepresentation(String representation) {
	    this.representation = representation;
	}

	public String getRepresentation() {
	    return representation;
	}

    };

    // FIXME Need create a defense to _name incorrect.
    protected Piece(Color _color, String _name) {
	this.color = _color;
	this.name = _color == Color.WHITE ? _name.toLowerCase() : _name
		.toUpperCase();

	if (_name.toLowerCase().equals(Type.ROOK.getRepresentation())) {
	    this.type = Type.ROOK;
	} else if (_name.toLowerCase().equals(Type.KNIGHT.getRepresentation())) {
	    this.type = Type.KNIGHT;
	} else if (_name.toLowerCase().equals(Type.BISHOP.getRepresentation())) {
	    this.type = Type.BISHOP;
	} else if (_name.toLowerCase().equals(Type.QUEEN.getRepresentation())) {
	    this.type = Type.QUEEN;
	} else if (_name.toLowerCase().equals(Type.KING.getRepresentation())) {
	    this.type = Type.KING;
	} else if (_name.toLowerCase().equals(Type.PAWN.getRepresentation())) {
	    this.type = Type.PAWN;
	    // FIXME find some way to calculate the strength of pawn in
	    // creation.
	} else if (_name.toLowerCase()
		.equals(Type.NO_PIECE.getRepresentation())) {
	    // FIXME there's some sense in creation of a piece that's 'no
	    // piece'?
	    this.type = Type.NO_PIECE;
	}
    }

    public static Piece create(Color _color, String _name) {
	return new Piece(_color, _name);
    }

    public static Piece createWithe(Type _type) {
	switch (_type) {
	case ROOK:
	    return new Piece(Color.WHITE, Type.ROOK.getRepresentation());
	case KNIGHT:
	    return new Piece(Color.WHITE, Type.KNIGHT.getRepresentation());
	case BISHOP:
	    return new Piece(Color.WHITE, Type.BISHOP.getRepresentation());
	case QUEEN:
	    return new Piece(Color.WHITE, Type.QUEEN.getRepresentation());
	case KING:
	    return new Piece(Color.WHITE, Type.KING.getRepresentation());
	case PAWN:
	default: // by default or even if is a pawn.
	    return new Piece(Color.WHITE, Type.PAWN.getRepresentation());
	}
    }

    public static Piece createBlack(Type _type) {
	switch (_type) {
	case ROOK:
	    return new Piece(Color.BLACK, Type.ROOK.getRepresentation());
	case KNIGHT:
	    return new Piece(Color.BLACK, Type.KNIGHT.getRepresentation());
	case BISHOP:
	    return new Piece(Color.BLACK, Type.BISHOP.getRepresentation());
	case QUEEN:
	    return new Piece(Color.BLACK, Type.QUEEN.getRepresentation());
	case KING:
	    return new Piece(Color.BLACK, Type.KING.getRepresentation());
	default: // by default or even if is a pawn.
	    return new Piece(Color.BLACK, Type.PAWN.getRepresentation());
	}
    }

    public static Piece createWhiteRook() {
	return new Piece(Color.WHITE, Type.ROOK.getRepresentation());
    }

    public static Piece createWhiteKnight() {
	return new Piece(Color.WHITE, Type.KNIGHT.getRepresentation());
    }

    public static Piece createWhiteBishop() {
	return new Piece(Color.WHITE, Type.BISHOP.getRepresentation());
    }

    public static Piece createWhiteQueen() {
	return new Piece(Color.WHITE, Type.QUEEN.getRepresentation());
    }

    public static Piece createWhiteKing() {
	return new Piece(Color.WHITE, Type.KING.getRepresentation());
    }

    public static Piece createWhitePawn() {
	return new Piece(Color.WHITE, Type.PAWN.getRepresentation());
    }

    public static Piece createBlackRook() {
	return new Piece(Color.BLACK, Type.ROOK.getRepresentation());
    }

    public static Piece createBlackKnight() {
	return new Piece(Color.BLACK, Type.KNIGHT.getRepresentation());
    }

    public static Piece createBlackBishop() {
	return new Piece(Color.BLACK, Type.BISHOP.getRepresentation());
    }

    public static Piece createBlackQueen() {
	return new Piece(Color.BLACK, Type.QUEEN.getRepresentation());
    }

    public static Piece createBlackKing() {
	return new Piece(Color.BLACK, Type.KING.getRepresentation());
    }

    public static Piece createBlackPawn() {
	return new Piece(Color.BLACK, Type.PAWN.getRepresentation());
    }

    public static Piece noPiece() {
	return new Piece(Color.NO_COLOR, Type.NO_PIECE.getRepresentation());
    }

    public static Float getMapStrength(Piece.Type _type) {
	return getStrength().get(_type);
    }

    private static Map<Piece.Type, Float> getStrength() {
	if (mapStrength == null)
	    loadStrength();
	return mapStrength;
    }

    /**
     * FIXME BIG PROBLEM: I can't use same key twice in map structure. How to
     * implement strength evaluation with map using Piece.Type (PAWN is there,
     * twice)? <br/>
     * Why don't create a new type: <b>*pawn advanced*</b>? Because it don't
     * make sense, semantically.
     */
    private static void loadStrength() {
	mapStrength = new EnumMap<Piece.Type, Float>(Piece.Type.class);
	mapStrength.put(Type.QUEEN, Type.QUEEN.getStrength());
	mapStrength.put(Type.ROOK, Type.ROOK.getStrength());
	mapStrength.put(Type.BISHOP, Type.BISHOP.getStrength());
	mapStrength.put(Type.KNIGHT, Type.KNIGHT.getStrength());
	mapStrength.put(Type.KING, Type.KING.getStrength());

	/*
	 * there's no sense to use
	 * 
	 * mapStrength.put(Piece.Type.PAWN, PAWN_SAME_LINE_STRENGTH);
	 * mapStrength.put(Piece.Type.PAWN, PAWN_ADVANCED_STRENGTH);
	 * mapStrength.put(Piece.Type.KING, KING_STRENGTH);
	 */
    }

    // TODO implement canMakeAMove()
    // TODO implement test for canMakeAMove()
    /**
     * Define if a Piece can make a move or not.
     * 
     * @param _type
     *            the type of piece that's trying to move.
     * @param startX
     *            initial X position.
     * @param startY
     *            initial Y position.
     * @param endX
     *            final (desired) X position.
     * @param endY
     *            final (desired) Y position.
     * @return true if can make a move. Otherwise false.
     */
    public boolean canMakeAMove(Piece.Type _type, int startX, int startY,
	    int endX, int endY) {
	return true;
    }

    /**
     * The name already tells about method. It's sugar syntax for isBlack()
     * method.
     * 
     * @return Return true if a piece is white. Otherwise (for black), false.
     */
    public boolean isWhite() {
	return this.color == Color.WHITE ? true : false;
    }

    /**
     * The name already tells about method. It's sugar syntax for isWhite()
     * method.
     * 
     * @return Return true if a piece is black. Otherwise (for white), false.
     */
    public boolean isBlack() {
	return this.color == Color.BLACK ? true : false;
    }

    public Color getColor() {
	return this.color;
    }

    public String getName() {
	return name;
    }

    public Piece.Type getType() {
	return this.type;
    }

    public String getRepresentation() {
	return this.type.getRepresentation();
    }

    @Override
    public String toString() {
	if (this.color == Color.WHITE) {
	    return this.name.toLowerCase();
	} else {
	    return this.name.toUpperCase();
	}
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((color == null) ? 0 : color.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Piece other = (Piece) obj;
	if (color == null) {
	    if (other.color != null)
		return false;
	} else if (!color.equals(other.color))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public int compareTo(Piece other) {
	// FIXME implement a guard clause here!
	// if (!(other instanceof Piece))
	// throw new ClassCastException("A PIECE object expected!!");

	Piece anotherPiece = (Piece) other;
	if (this.type.getStrength() < anotherPiece.getType().getStrength())
	    return 1;
	else if (this.type.getStrength() > anotherPiece.getType().getStrength())
	    return -1;
	else
	    return 0;
    }
}
