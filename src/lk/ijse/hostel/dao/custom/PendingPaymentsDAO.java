package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.dao.CrudDAO;
import lk.ijse.hostel.projection.CustomProjection;
import org.hibernate.Session;

import java.util.List;

public interface PendingPaymentsDAO extends CrudDAO<CustomProjection> {
    List<CustomProjection> getAllPendingPayments();
    void setSession(Session session);
}
