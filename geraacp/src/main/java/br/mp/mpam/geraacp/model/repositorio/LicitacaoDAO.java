package br.mp.mpam.geraacp.model.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.mp.mpam.geraacp.model.entidades.Licitacao;

public class LicitacaoDAO{
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
	   * Método utilizado para salvar ou atualizar as informações de uma licitacao.
	   * @param licitacao
	   * @return
	   * @throws java.lang.Exception
	   */
	  public Licitacao salvar(Licitacao licitacao) throws Exception {
	    EntityManager entityManager = getEntityManager();
	    try {
	      // Inicia uma transação com o banco de dados.
	      entityManager.getTransaction().begin();
	      System.out.println("Salvando a licitacao.");
	      // Verifica se a licitacao ainda não está salva no banco de dados.
	      if(licitacao.getId() == null) {
	        //Salva os dados da licitacao.
	        entityManager.persist(licitacao);
	      } else {
	        //Atualiza os dados da licitacao.
	        licitacao = entityManager.merge(licitacao);
	      }
	      // Finaliza a transação.
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	    return licitacao;
	  }

	  /**
	   * Método que apaga a licitacao do banco de dados.
	   * @param id
	   */
	  public void excluir(Long id) {
	    EntityManager entityManager = getEntityManager();
	    try {
	      // Inicia uma transação com o banco de dados.
	      entityManager.getTransaction().begin();
	      // Consulta a licitacao na base de dados através do seu ID.
	      Licitacao licitacao = entityManager.find(Licitacao.class, id);
	      System.out.println("Excluindo os dados de: " + licitacao.getNumerolicit());
	      // Remove a licitacao da base de dados.
	      entityManager.remove(licitacao);
	      // Finaliza a transação.
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	  }

	  /**
	   * Consulta o licitacao pelo ID.
	   * @param id
	   * @return o objeto Licitacao.
	   */
	  public Licitacao consultarPorId(Long id) {
	    EntityManager entityManager = getEntityManager();
	    Licitacao licitacao = null;
	    try {
	      //Consulta uma licitacao pelo seu ID.
	      licitacao = entityManager.find(Licitacao.class, id);
	    } finally {
	      entityManager.close();
	    }
	    return licitacao;
	  }
	  
	  /**
	   * Consulta o licitacao pelo ID.
	   * @param id
	   * @return o objeto Licitacao.
	   */

	
	@SuppressWarnings("unchecked")
	public List<Licitacao> findAll() {
	    EntityManager entityManager = getEntityManager();
	    List<Licitacao> licitacoes = null;
	    try {
	        try {
	            Query query = entityManager.createQuery("Select l from Licitacao l");
	            licitacoes = query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return licitacoes;
	    } finally {
	      entityManager.close();
	    }
	  }


	}