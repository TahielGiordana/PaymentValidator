import interfaces.Validator;
import services.PaymentFinder;

public class PaymentValidator implements Validator {
    public boolean validate(String username, String codeMachine){
        return PaymentFinder.findPayment(username);
    }

    @Override
    public String getName() {
        return "PAYMENT";
    }

}
