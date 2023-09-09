package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.PendingPaymentsDAO;
import lk.ijse.hostel.projection.CustomProjection;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PendingPaymentsDAOImpl implements PendingPaymentsDAO {
    private Session session;

    @Override
    public List<CustomProjection> loadAll() {
        return null;
    }

    @Override
    public String save(CustomProjection customProjection) {
        return (String) session.save(customProjection);
    }

    @Override
    public void update(CustomProjection customProjection) {
        session.update(customProjection);
    }

    @Override
    public void delete(CustomProjection customProjection) {
        session.delete(customProjection);
    }

    @Override
    public CustomProjection getObject(String id) throws Exception {
        return null;
    }

    @Override
    public List<CustomProjection> getAllPendingPayments() {
        Query<CustomProjection> query=session.createQuery("select new lk.ijse.hostel.projection.CustomProjection (" + " r.resId,s.stId,s.stName,s.contact) from Student s  join Reservation  r on s.stId = r.student where r.status='UNPAID'");
        List<CustomProjection> list=query.getResultList();
        System.out.println(list);
        return list;

    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

}
