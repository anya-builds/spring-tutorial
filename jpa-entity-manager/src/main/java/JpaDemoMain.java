
import jakarta.persistence.EntityManager;
import org.hibernate.Session;

public class JpaDemoMain {
    public static void main(String[] args) {
        EntityManager em=JPAUtil.getEntityManager();
        try{
            UserClassHibernate user=new UserClassHibernate("Alice",1L);
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            System.out.println("User saved: "+user.getId());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
            JPAUtil.close();
        }
    }
}
