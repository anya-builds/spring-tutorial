import loose.EmailNotificationService;
import loose.SMSNotificationService;
import tight.NotificationService;
import tight.UserService;

public class AppMain {
   public static void main(String[] args) {
       // tight
        UserService userService=new UserService();
        userService.notifyUser("Order placed!");
        //loose
       EmailNotificationService emailService = new EmailNotificationService();
       NotificationService smsService = new NotificationService();
       loose.UserService userServiceLoose=new loose.UserService((loose.NotificationService) smsService);
       userServiceLoose.notifyUser("order processed");
    }
}
