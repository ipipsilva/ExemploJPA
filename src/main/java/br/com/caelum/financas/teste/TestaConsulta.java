package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConsulta {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Query createQuery = manager.createQuery("SELECT m FROM Movimentacao m WHERE m.conta = :conta" +
		" AND m.tipo = :tipo" +
		" ORDER BY m.valor ASC");
		
		createQuery.setParameter("conta", conta);
		createQuery.setParameter("tipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> movimentos = createQuery.getResultList();
		
		for (Movimentacao movimentacao : movimentos) {			
		   System.out.println("\nDescricao ..: " + movimentacao.getDescricao());
           System.out.println("Valor ......: R$ " + movimentacao.getValor());        
		}
		
		manager.getTransaction().commit();
		manager.close();
	}

}
