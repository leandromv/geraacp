package br.mp.mpam.geraacp.model.entidades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ProgramaPrincipal {
	public static void main(String[] args) {
	// Criar EntityManagerFactory
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("geraacp");

	// Criar EntityManager
	EntityManager em = emf.createEntityManager();
	        
	// Fazer consulta ao banco       
	List<Competencia> lista = em.createQuery("FROM Competencia", Competencia.class).getResultList();

	Integer j = 0;
	for (Competencia objeto : lista){
		System.out.println("Objeto no banco:" + objeto.getId());
		j = j +1;
	}
	
	Competencia obj = new Competencia();
	obj.setMes(2);
	obj.setAno(2017);
	em.getTransaction().begin();
	em.persist(obj);
	em.getTransaction().commit();
	
	em.close();
	emf.close();
	}
}
