package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.bo.SuperBO;

import java.util.List;

public interface PendingPaymentsBO<T> extends SuperBO {
    List<T> getAllPendingPayments();

}
