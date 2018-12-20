package com.esme.spring.faircorp.model;
import javax.persistence.*;
import java.util.List;

public class LightDaoImpl implements LightDaoCustom{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Light> findOnLights() {
        String jpql = "select lt from LIGHT lt where lt.status = :value";
        return em.createQuery(jpql, Light.class)
                .setParameter("value", Status.ON)
                .getResultList();
    }
}
