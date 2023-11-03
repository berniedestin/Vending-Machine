package com.techelevator;

public class Change {

    private int fives;
    private int ones;
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;
    private boolean isChange;

    public Change(int remainder) {

        if (remainder == 0) {
            isChange = false;
        }
        else {
            isChange = true;
        }

        if (remainder % 500 == 0 && remainder > 0) {
            this.fives = remainder / 500;
            remainder -= (remainder / 500) * 500;
        } else if (remainder % 500 > 0 && remainder > 0) {
            this.fives = remainder / 500;
            remainder -= (remainder / 500) * 500;
        }
        if (remainder % 100 == 0 & remainder > 0) {
            this.ones = remainder / 100;
            remainder -= (remainder / 100) * 100;
        } else if (remainder % 100 > 0 && remainder > 0) {
            this.ones = remainder / 100;
            remainder -= (remainder / 100) * 100;
        }
        if (remainder % 25 == 0 && remainder > 0) {
            this.quarters = remainder / 25;
            remainder -= (remainder / 25) * 25;
        } else if (remainder % 25 > 0 && remainder > 0) {
            this.quarters += remainder / 25;
            remainder -= (remainder / 25) * 25;
        }
        if (remainder % 10 == 0 && remainder > 0) {
            this.dimes = remainder / 10;
            remainder -= (remainder / 10) * 10;
        } else if (remainder % 10 > 0 && remainder > 0) {
            this.dimes = remainder / 10;
            remainder -= (remainder / 10) * 10;
        }
        if (remainder % 5 == 0 && remainder > 0) {
            this.nickels = remainder / 5;
            remainder -= (remainder / 5) * 5;
        } else if (remainder % 5 > 0 && remainder > 0) {
            this.nickels = remainder / 5;
            remainder -= (remainder / 5) * 5;
        }
        if (remainder > 0) {
            this.pennies = remainder;
        }

    }

    public String getChange() {

        if (!isChange) {
            return "There is no change";
        }

        String change = "Your change is";

        if (fives > 0) {
            if (fives == 1) {
                change += " 1 $5 bill";
            }
            if (fives > 1) {
                change += " " + fives + " $5 bills";
            }
        }
        if (ones > 0) {
            if (change.length() > 14) {
                change += ",";
            }
            if (ones == 1) {
                change += " 1 $1 bill";
            }
            if (ones > 1) {
                change += " " + ones + " $1 bills";
            }
        }
        if (quarters > 0) {
            if (change.length() > 14) {
                change += ",";
            }
            if (quarters == 1) {
                change += " 1 quarter";
            }
            if (quarters > 1) {
                change += " " + quarters + " quarters";
            }
        }
        if (dimes > 0) {
            if (change.length() > 14) {
                change += ",";
            }
            if (dimes == 1) {
                change += " 1 dime";
            }
            if (dimes > 1) {
                change += " " + dimes + " dimes";
            }
        }
        if (nickels > 0) {
            if (change.length() > 14) {
                change += ",";
            }
            if (nickels == 1) {
                change += " 1 nickel";
            }
            if (nickels > 1) {
                change += " " + nickels + " nickels";
            }
        }
        if (pennies > 0) {
            if (change.length() > 14) {
                change += ",";
            }
            if (pennies == 1) {
                change += " 1 penny";
            }
            if (pennies > 1) {
                change += " " + pennies + " pennies";
            }
        }

        return change;

    }

}
