package lk.ijse.hostel.bo;

import lk.ijse.hostel.bo.custom.impl.*;

public class BOFactory {

    public static BOFactory boFactory;
    public BOFactory() {
    }

    public BOFactory  getBoFactory(){
        if (boFactory==null){
            boFactory=new BOFactory ();
        }
        return boFactory;
    }

    public enum BOTypes{
        STUDENT,ROOM,USER,RESERVATION,PENDING_PAYMENTS
    }

    public static SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case STUDENT:
                return new StudentBOImpl ();
            case ROOM:
                return new RoomBOImpl ();
            case RESERVATION:
                return new RevervationBOImpl ();
            case USER:
                return new UserBOImpl ();
            case PENDING_PAYMENTS:
                return new PendingPaymentsBOImpl();
            default:
                return null;
        }
    }

}
