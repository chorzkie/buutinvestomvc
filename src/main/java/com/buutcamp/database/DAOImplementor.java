package com.buutcamp.database;

import com.buutcamp.emitents.Emitent;
import com.buutcamp.emitents.GoodEmitents;
import com.buutcamp.emitents.TopRecommendedEmit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
//public class DAOImplementor implements IfaceDAO {
public class DAOImplementor {
    //private static final Logger logger = LoggerFactory.getLogger(DAOImplementor.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void sqlAddEmitent(Emitent emitent) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(emitent);
        //logger.info("New emitent added successfully. Emitent details: " + emitent);
    }

    @Transactional
    public void sqlAddTopEmitent(TopRecommendedEmit topRecommendedEmit) {
        Session session = sessionFactory.getCurrentSession();
        session.save(topRecommendedEmit);
    }

    @Transactional
    public void sqlAddGoodEmitent(GoodEmitents goodEmitents) {
        Session session = sessionFactory.getCurrentSession();
        session.save(goodEmitents);
    }

    @Transactional
    public boolean checkExistingEmitentByTicker(String emitentName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Emitent where EMITNAME=:emitentName");
        query.setParameter("emitentName", emitentName);
        if ((Emitent)query.uniqueResult() == null){
            return true;
        }
        else {return false;
        }
    }

    @Transactional
    public void sqlUpdateEmitent(Emitent emitent) {
        Session session = sessionFactory.getCurrentSession();
        session.update(emitent);
    }

    @Transactional
    public Emitent getEmitent(int id) {
        Session session = sessionFactory.getCurrentSession();

        Emitent emitentGet = session.get(Emitent.class, id);
        //Emitent emitentGet = session.get(Emitent.class, id).getFundamental();

        if (emitentGet == null) {
            return null;
        }
        return emitentGet;
    }

    @Transactional
    public Emitent getEmitentByTicker(String emitentName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Emitent where EMITNAME=:emitentName");
        query.setParameter("emitentName", emitentName);
        return (Emitent)query.uniqueResult();
    }

    @Transactional
    public List<Emitent> searchEmitent(String emitentName) {

        Session session = this.sessionFactory.getCurrentSession();

        if (emitentName == null || emitentName.trim().length() <= 2) {
            return null;
        }
        else {

            Query<Emitent> query = session.createQuery("from Emitent where " +
                    "lower(emitentName) like :emitentName " +
                    "or" +
                    " lower(emitentFullName) like :emitentName", Emitent.class);
            query.setParameter("emitentName", "%" + emitentName.toLowerCase() + "%");

            return query.getResultList();
        }
    }

    @Transactional
    public List <Emitent> listEmitent() {
        Session session = sessionFactory.getCurrentSession();

        Query<Emitent> query = session.createQuery("from Emitent emitent ORDER BY EMITNAME ASC", Emitent.class);

        return query.getResultList();
    }

    @Transactional
    public List <TopRecommendedEmit> listTopRecomEmitent() {
        Session session = sessionFactory.getCurrentSession();

        Query<TopRecommendedEmit> query = session.createQuery("from TopRecommendedEmit", TopRecommendedEmit.class);

        return query.getResultList();
    }

    @Transactional
    public List <GoodEmitents> listGoodRecomEmitent() {
        Session session = sessionFactory.getCurrentSession();

        Query<GoodEmitents> query = session.createQuery("from GoodEmitents", GoodEmitents.class);

        return query.getResultList();
    }

    @Transactional
    public void delEmitent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Emitent where id=:emitentId");
        query.setParameter("emitentId", id);
        query.executeUpdate();
    }

    @Transactional
    public void delTopRecom() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from TopRecommendedEmit");
        query.executeUpdate();
    }

    @Transactional
    public void delGoodRecom() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from GoodEmitents");
        query.executeUpdate();
    }
}