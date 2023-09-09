package lk.ijse.hostel.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.hostel.bo.BOFactory;
import lk.ijse.hostel.bo.custom.PendingPaymentsBO;
import lk.ijse.hostel.dto.PendingPaymentsDTO;
import lk.ijse.hostel.dto.tm.PendingPaymentsTM;

public class PendingKeyPaymentFormController {

    PendingPaymentsBO pendingPaymentsBO= (PendingPaymentsBO) BOFactory.getBO (BOFactory.BOTypes.PENDING_PAYMENTS);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> contactCol;

    @FXML
    private TableView<PendingPaymentsTM> pendingPaymentsTbl;

    @FXML
    private TableColumn<?, ?> reservationIdCol;

    @FXML
    private TableColumn<?, ?> studentIdCol;

    @FXML
    private TableColumn<?, ?> studentNameCol;

    @FXML
    void tblOnAction(MouseEvent event) {

    }

    void getAll(){
        List<PendingPaymentsDTO> list=pendingPaymentsBO.getAllPendingPayments();
        ObservableList<PendingPaymentsTM> observableList= FXCollections.observableArrayList();

        for (PendingPaymentsDTO pendingPaymentsDTO : list) {
            observableList.add(new PendingPaymentsTM(
                    pendingPaymentsDTO.getResId(),
                    pendingPaymentsDTO.getStudentId(),
                    pendingPaymentsDTO.getName(),
                    pendingPaymentsDTO.getContact()
            ));

        }

        pendingPaymentsTbl.setItems(observableList);
    }

    void setCellValueFactory(){
        reservationIdCol.setCellValueFactory(new PropertyValueFactory<>("resId"));
        studentIdCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));

    }

    @FXML
    void initialize() {
        getAll();
        setCellValueFactory();
        assert contactCol != null : "fx:id=\"contactCol\" was not injected: check your FXML file 'PendingKeyPaymentForm.fxml'.";
        assert pendingPaymentsTbl != null : "fx:id=\"pendingPaymentsTbl\" was not injected: check your FXML file 'PendingKeyPaymentForm.fxml'.";
        assert reservationIdCol != null : "fx:id=\"reservationIdCol\" was not injected: check your FXML file 'PendingKeyPaymentForm.fxml'.";
        assert studentIdCol != null : "fx:id=\"studentIdCol\" was not injected: check your FXML file 'PendingKeyPaymentForm.fxml'.";
        assert studentNameCol != null : "fx:id=\"studentNameCol\" was not injected: check your FXML file 'PendingKeyPaymentForm.fxml'.";

    }

}
