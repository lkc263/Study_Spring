package hellojpa;

import hellojpa.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            String jpql = "select m From Member m where m.username like '%kim%'";
            List<Member> result = em.createQuery(jpql, Member.class).getResultList();

            for (Member member : result) {
                System.out.println("member = " + member);
            }
            tx.commit();
        } catch (Exception e) {
            System.out.println("예외 발생");
            tx.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }

        emf.close();
    }
}
