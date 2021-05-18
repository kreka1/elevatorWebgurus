package elevatorcode;

public class ManageLifts {

    public ManageLifts() {
    }

    public void choosingElevator(Elevator A, Elevator B, int callingLevel) {
        int distA, distB, levelA, levelB;
        if ( callingLevel < A.getMinLevel() || callingLevel > A.getMaxLevel() || callingLevel < B.getMinLevel() || callingLevel > B.getMaxLevel() ) {
            System.out.println( "Wrong elevator call. Inexistent level." );
            return;
        }
        levelA = A.getCurrentLevel();
        levelB = B.getCurrentLevel();

        if ( levelA == callingLevel ) {
            A.move( callingLevel ); //move with A, A at same level
        } else if ( levelB == callingLevel ) {
            B.move( callingLevel ); //move with B, B at same level
        } else {
            distA = Math.abs( callingLevel - levelA );
            distB = Math.abs( callingLevel - levelB );
            if ( distA == distB ) {
                if ( levelA < levelB ) A.move( callingLevel ); //same distance, A in lower level, A moves
                else B.move( callingLevel ); //same distance, B in lower level, B moves
            } else if ( distA > distB ) {
                B.move( callingLevel ); // B closest, B moves
            } else A.move( callingLevel ); // A closest, A moves
        }
    }

}

