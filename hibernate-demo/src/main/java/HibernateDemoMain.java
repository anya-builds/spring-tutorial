
import org.hibernate.Session;

public class HibernateDemoMain {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSession();
        try{
            UserClassHibernate user=new UserClassHibernate("Alice",1L);
            session.beginTransaction();
            session.persist(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
