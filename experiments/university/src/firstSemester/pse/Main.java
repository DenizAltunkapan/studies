package firstSemester.pse;

public class Main {


    public static void main(String[] args){
        /*
        Vehicle v1 = new EBike () ;
        RegisteredVehicle v2 = new Car ("Du -Du 1234 ") ;
        v1.printVehicleInfo();
        v2.printVehicleInfo();
        */

        /*
        final Vehicle v1 = new EBike () ;
        final RegisteredVehicle v2 = new Car ("Du -Du 1234 ");
        final Vehicle v3 = v2 ;
        printVehicle ( v1 );
        printVehicle ( v2 );
        printVehicle ( v3 );
         */

    }

    static void printVehicle ( final Vehicle vehicle ) {
        System . out . println ("A vehicle !");
        }
    static void printVehicle ( final RegisteredVehicle registeredVehicle ) {
        System . out . println ("A registered vehicle !");
    }



}
