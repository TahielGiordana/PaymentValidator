import interfaces.Observable;
import interfaces.Observer;
import interfaces.Validator;
import services.PaymentFinder;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class PaymentValidator implements Validator, Observable {

    private Set<Observer> observers;
    private boolean result;
    private TimerTask timerTask;

    public PaymentValidator(){
        this.observers = new HashSet<>();
        this.timerTask = new TimerTask() {
            @Override
            public void run() {

            }
        };
    }

    public boolean validate(String username, String codeMachine){
        timerTask.cancel();
        Timer timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {

                boolean updatedResult = PaymentFinder.findPayment(username);
                if(result != updatedResult){
                    result = updatedResult;
                    notifyObservers();
                }
                System.out.println(result);
            }
        };
        timer.schedule(timerTask, 0, 3000);
        return true;
    }

    @Override
    public String getName() {
        return "PAYMENT";
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }
    public boolean getResult(){
        return this.result;
    }
}
