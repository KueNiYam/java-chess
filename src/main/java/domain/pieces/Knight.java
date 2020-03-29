package domain.pieces;

import domain.pieces.exceptions.CanNotMoveException;
import domain.point.Direction;
import domain.point.Point;
import domain.team.Team;

public class Knight extends Piece {
    private static final double SCORE = 2.5;
    private static final String INITIAL = "N";

    public Knight(Team team, Point point) {
        super(INITIAL, team, point, SCORE);
    }

    @Override
    public Piece move(Point afterPoint) {
        return new Knight(getTeam(), afterPoint);
    }

    @Override
    public void validateMoveDirection(Direction direction) {
        if (!direction.isKnight()) {
            throw new CanNotMoveException();
        }
    }
}
