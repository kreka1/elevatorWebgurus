package elevatorcode;

public class Main {

    public static void main(String[] args) {
        Elevator elevA = new Elevator( "A", 0, 0, 6 );
        Elevator elevB = new Elevator( "B", 6, 0, 6 );
        System.out.println( elevA.toString() );
        System.out.println( elevB.toString() );
        System.out.println();

        ManageLifts manage = new ManageLifts();

        manage.choosingElevator( elevA, elevB, 9 );
        manage.choosingElevator( elevA, elevB, 5 );


    }
}
