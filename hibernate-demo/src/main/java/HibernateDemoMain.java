
import org.hibernate.Session;

public class HibernateDemoMain {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSession();
        try{
            UserClassHibernate user=new UserClassHibernate(1,"Alice");
        }
    }
}
