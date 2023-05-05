import interfaces.Validator;
import services.PaymentFinder;

public class PaymentValidator implements Validator {
    public boolean validate(String username, String codeMachine){
        return PaymentFinder.findPayment(username);
    };

    public static void main(String[] args){
        PaymentValidator validator = new PaymentValidator();
        System.out.println(validator.validate("Tahiel", "A1"));
    }
}
