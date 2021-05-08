package com.sda.weather;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Set;

public class LocationRepositoryImpl implements LocationRepository {

    private  SessionFactory sessionFactory;

    public LocationRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Location addLocation(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(location);

        transaction.commit();
        session.close();

        return location;
    }

    @Override
    public Location showLocations(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String allLocations = location.getCity();

        transaction.commit();
        session.close();

        return location;
    }
}
