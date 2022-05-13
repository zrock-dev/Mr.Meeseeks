import java.util.Scanner;

public class Task3 {

    public static void main (String [] args)

    {

        Scanner scaner = new Scanner(System.in);

        scaner.useDelimiter("\\n");

        int count=0; int hiddernumber; while (count<3)

    {

        hiddernumber = (int) ((Math.random() * 100) + 1); System.out.println("*******************************************************");

        System.out.println("********Guess the number random between 1 - 100********");

        System.out.println("*******************************************************");

        System.out.println("Number hidden is " + hiddernumber); int win=0;

        while (win < 1) {

            System.out.println("***************************************");

            System.out.println("Enter a Number");

            int number = scaner.nextInt(); if (number != hiddernumber) {

                if (number < hiddernumber) {

                    System.out.println("***************************************");

                    System.out.println("Enter a Major Number to " + number);

                } else {

                    System.out.println("***************************************");

                    System.out.println("Enter a Less Number to " + number);

                }

            }

            if (number == hiddernumber) {

                System.out.println("***************************************");

                System.out.println("Congratulations! the Number hidden was " + hiddernumber);

                win++;

            }

        }count++;

    }
    //prueba2
    }

}

//add feature "number of attempts"

//keep the play 3 times feature

