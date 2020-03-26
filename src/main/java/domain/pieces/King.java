package domain.pieces;

import domain.pieces.exceptions.CanNotMoveException;
import domain.pieces.exceptions.CanNotReachException;
import domain.point.Direction;
import domain.point.Distance;
import domain.point.Point;
import domain.team.Team;

public class King extends Piece {
    private static final String INITIAL = "K";

    public King(Team team, Point point) {
        super(INITIAL, team, point);
    }

    @Override
    public Piece move(Point afterPoint) {
        return new King(getTeam(), afterPoint);
    }

    @Override
    public void canMove(Direction direction) {
        if (direction.isNotLinearDirection()) {
            throw new CanNotMoveException();
        }
    }

    @Override
    public void canReach(Distance distance) {
        if (distance != Distance.ONE) {
            throw new CanNotReachException();
        }
    }
}
