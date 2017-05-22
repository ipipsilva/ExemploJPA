package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConsultaCategoria {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		Query createQuery = manager.createQuery("SELECT m FROM Movimentacao m JOIN m.categorias c WHERE c = :categoria");
		
		createQuery.setParameter("categoria", categoria);		
		
		List<Movimentacao> movimentos = createQuery.getResultList();
		
		for (Movimentacao movimentacao : movimentos) {			
		   System.out.println("\nDescricao ..: " + movimentacao.getDescricao());
           System.out.println("Valor ......: R$ " + movimentacao.getValor());        
		}
		
		manager.getTransaction().commit();
		manager.close();
	}
	
}
