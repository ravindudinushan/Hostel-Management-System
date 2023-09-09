package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.PendingPaymentsBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.custom.PendingPaymentsDAO;
import lk.ijse.hostel.dto.PendingPaymentsDTO;
import lk.ijse.hostel.projection.CustomProjection;
import lk.ijse.hostel.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PendingPaymentsBOImpl implements PendingPaymentsBO<PendingPaymentsDTO> {
    PendingPaymentsDAO pendingPaymentsDAO= (PendingPaymentsDAO) DAOFactory.getDaoFactory ().getDAO (DAOFactory.DAOTypes.PENDING_PAYMENT);
    @Override
    public List<PendingPaymentsDTO> getAllPendingPayments() {
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            pendingPaymentsDAO.setSession(session);
            List<CustomProjection> list=pendingPaymentsDAO.getAllPendingPayments();
            List<PendingPaymentsDTO> paymentsDTOList=new ArrayList<>();

            for (CustomProjection customeProjection : list) {
                paymentsDTOList.add(new PendingPaymentsDTO(
                        customeProjection.getResId(),
                        customeProjection.getStudentId(),
                        customeProjection.getName(),
                        customeProjection.getContact()
                ));
            }
            transaction.commit();
            session.close();
            return paymentsDTOList;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return null;
        }
     }
}
