package elevatorcode;

import java.util.Scanner;

public class Elevator {
    private int currentLevel, minLevel, maxLevel;
    private boolean available = true;
    private String name;

    // Constructor
    public Elevator(String name) {
        this.name = name;
    }

    public Elevator(String name, int currentLevel) {
        this.currentLevel = currentLevel;
        this.name = name;
    }

    public Elevator(String name, int minLevel, int maxLevel) {
        this( name, 0 );
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
    }

    public Elevator(String name, int currentLevel, int minLevel, int maxLevel) {
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.name = name;
        this.currentLevel = currentLevel;
        if ( currentLevel < minLevel )
            this.currentLevel = minLevel;
        else if ( currentLevel > maxLevel )
            this.currentLevel = maxLevel;
    }

    // getter & setter
    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Elevator " + getName() + " is at level "
                + currentLevel + ".";
    }

    // Moving methods
    public void upToCall(int callingLevel) {
        int i;
        for (i = this.currentLevel; i < callingLevel; i++) {
            System.out.println( "Level " + i + ": elevator " + this.getName() + " ↑ " );
        }

        if ( i == callingLevel ) { // The elevator is on calling level
            if ( this.currentLevel != callingLevel ) {
                System.out.println( this.getName() + " stopped at level " + i );
                this.setCurrentLevel( callingLevel );
            }
        }
    }

    public void downToCall(int callingLevel) {
        int i;
        for (i = this.currentLevel; i > callingLevel; i--) {
            System.out.println( "Level " + i + ": elevator " + this.getName() + " ↓ " );
        }

        if ( i == callingLevel ) { // The elevator is on calling level
            if ( this.currentLevel != callingLevel ) {
                System.out.println( this.getName() + " stopped at level " + i );
                this.setCurrentLevel( callingLevel );
            }

        }
    }

    public void move(int callingLevel) {
        Scanner in = new Scanner( System.in );
        int level;

        this.setAvailable( false ); // The elevator is in motion
        System.out.println( this.getName() + " in motion from level " + this.getCurrentLevel() );

        // Elevator going to calling level
        if ( this.currentLevel < callingLevel ) {
            upToCall( callingLevel );
        } else {
            downToCall( callingLevel );
        }

        boolean isnotInt = false;

        System.out.println( "Please choose the level by entering a number between " + this.getMinLevel() + " and " + this.getMaxLevel() );
        try {
            String levell = in.nextLine(); // Getting the destination level
            level = Integer.parseInt( levell );
        } catch (Exception e) {
            System.out.println( "Inadequate input." );
            level = callingLevel;
            isnotInt = true;
        }

        while (isnotInt || level > this.getMaxLevel() || level < this.getMinLevel()) { // Levels between min and max accepted
            try {
                System.out.println( "Please choose a level between " + this.getMinLevel() +
                        " and " + this.getMaxLevel() );
                level = in.nextInt();
                isnotInt = false;
            } catch (Exception e) {
                System.out.println( "Inadequate input." );
                level = callingLevel;
                isnotInt = true;
                in.next();
            }

        }
        System.out.println( this.getName() + " in motion" );

        if ( level < callingLevel ) {// Elevator going down
            downToCall( level );
        } else { // Elevator going up
            upToCall( level );
        }

        System.out.println( this.getName() + " reached level " + level );
        this.setAvailable( true );
        System.out.println( this.getName() + " available" );
        System.out.println();


    }


}
