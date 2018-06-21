package br.mp.mpam.geraacp.model.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.mp.mpam.geraacp.model.entidades.Competencia;

public class CompetenciaDAO{
	  /**
	   * Método utilizado para obter o entity manager.
	   * @return
	   */
	  private EntityManager getEntityManager() {
	    EntityManagerFactory factory = null;
	    EntityManager entityManager = null;

		// Obtém o factory a partir da unidade de persistência.
		factory = Persistence.createEntityManagerFactory("geraacp");
		// Cria um entity manager.
		entityManager = factory.createEntityManager();
		// Fecha o factory para liberar os recursos utilizado.

		return entityManager;
	  }

	  /**
	   * Método utilizado para salvar ou atualizar as informações de uma competencia.
	   * @param competencia
	   * @return
	   * @throws java.lang.Exception
	   */
	  public Competencia salvar(Competencia competencia) throws Exception {
	    EntityManager entityManager = getEntityManager();
	    try {
	      // Inicia uma transação com o banco de dados.
	      entityManager.getTransaction().begin();
	      System.out.println("Salvando a competencia.");
	      // Verifica se a competencia ainda não está salva no banco de dados.
	      if(competencia.getId() == null) {
	        //Salva os dados da competencia.
	        entityManager.persist(competencia);
	      } else {
	        //Atualiza os dados da competencia.
	        competencia = entityManager.merge(competencia);
	      }
	      // Finaliza a transação.
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	    return competencia;
	  }

	  /**
	   * Método que apaga a competencia do banco de dados.
	   * @param id
	   */
	  public void excluir(Long id) {
	    EntityManager entityManager = getEntityManager();
	    try {
	      // Inicia uma transação com o banco de dados.
	      entityManager.getTransaction().begin();
	      // Consulta a competencia na base de dados através do seu ID.
	      Competencia competencia = entityManager.find(Competencia.class, id);
	      System.out.println("Excluindo os dados de: " + competencia.getId());
	      // Remove a competencia da base de dados.
	      entityManager.remove(competencia);
	      // Finaliza a transação.
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	  }

	  /**
	   * Consulta o competencia pelo ID.
	   * @param id
	   * @return o objeto Competencia.
	   */
	  public Competencia consultarPorId(Long id) {
	    EntityManager entityManager = getEntityManager();
	    Competencia competencia = null;
	    try {
	      //Consulta uma competencia pelo seu ID.
	      competencia = entityManager.find(Competencia.class, id);
	    } finally {
	      entityManager.close();
	    }
	    return competencia;
	  }
	  
	  /**
	   * Consulta o competencia pelo ID.
	   * @param id
	   * @return o objeto Competencia.
	   */

	
	@SuppressWarnings("unchecked")
	public List<Competencia> findAll() {
	    EntityManager entityManager = getEntityManager();
	    List<Competencia> competencias = null;
	    try {
	        try {
	            Query query = entityManager.createQuery("Select c from Competencia c");
	            competencias = query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return competencias;
	    } finally {
	      entityManager.close();
	    }
	  }


	}