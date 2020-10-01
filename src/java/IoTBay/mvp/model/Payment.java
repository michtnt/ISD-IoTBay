package IoTBay.mvp.model;

import java.io.Serializable;
/**
 *
 * @author desyliunardi
 */    
public class Payment implements Serializable{
    //private Integer paymentId;
    //private Integer orderId;
    private String paymentMethod;
    private Integer cardNumber;
    private Integer cvv;
    private String nameOnCard;
    private String expiryDate;
    
    private String datePaid;
    
    // insert a constructor that initialies the fields
    public Payment(String paymentMethod, Integer cardNumber, Integer cvv, String nameOnCard, String expiryDate,  String datePaid) {
       // this.paymentId = paymentId;
        //this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.nameOnCard = nameOnCard;
        this.expiryDate = expiryDate;
        this.datePaid = datePaid;
    }
    
    
    public Payment() {}
    // insert getters/setters
  /* public Integer getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }
*/

    
    

    
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    
    public Integer getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    
    public Integer getCvv() {
        return cvv;
    }
    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }
    
    
    public String getNameOnCard() {
        return nameOnCard;
    }
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    
     public String getDatePaid() {
        return datePaid;
    }
    public void setDatePaid(String datePaid) {
        this.datePaid = datePaid;
    }
}