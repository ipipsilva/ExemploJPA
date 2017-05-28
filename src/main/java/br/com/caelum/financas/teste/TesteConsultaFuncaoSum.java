package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoSum {
	
public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 2);
		
		// Define o tipo de retorno na declaração da Query
		TypedQuery<BigDecimal> query = manager.createQuery("select sum(m.valor) from Movimentacao m where m.conta = :pConta", BigDecimal.class);
		
		query.setParameter("pConta", conta);
		
		BigDecimal somatorio = (BigDecimal) query.getSingleResult();		
		
		System.out.println("O somatorio das movimentações é: " + somatorio);
		
		manager.getTransaction().commit();
		manager.close();
		
	}
}
