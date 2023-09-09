package lk.ijse.hostel.dao;

import lk.ijse.hostel.dao.custom.impl.*;

public class DAOFactory {
    public static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getDaoFactory(){
        if (daoFactory==null){
            daoFactory=new DAOFactory ();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        STUDENT,ROOM,USER,RESERVATION,PENDING_PAYMENT
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case STUDENT:
                return new StudentDAOImpl ();
            case ROOM:
                return new RoomDAOImpl ();
            case RESERVATION:
                return new RevervationDAOImpl ();
            case USER:
                return new UserDAOImpl ();
            case PENDING_PAYMENT:
                return new PendingPaymentsDAOImpl();
            default:
                return null;
        }
    }

}
