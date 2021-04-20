package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Custumer;
import br.com.fiap.util.EntityManagerFacade;

public class CustumerDAO {

	private EntityManager manager = EntityManagerFacade.get();

	public void save(Custumer custumer) {
		manager.getTransaction().begin();
		manager.persist(custumer);
		manager.getTransaction().commit();

		manager.close();

	}

	public List<Custumer> getAll() {
		String jpql = "SELECT c from Custumer c";
		TypedQuery<Custumer> createQuery = manager.createQuery(jpql, Custumer.class);
		return createQuery.getResultList();
	}
}
