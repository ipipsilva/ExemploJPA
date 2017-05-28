package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacosConta {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Query query = manager.createQuery("SELECT distinct  c FROM Conta c left join fetch c.movimentacoes");
		
		List<Conta> contas = query.getResultList();
		
		for (Conta conta : contas) {
			System.out.println("Titular da Conta: " + conta.getTitular());
			System.out.println("Movimentações: " + conta.getMovimentacoes());
		}
		
		manager.getTransaction().commit();
		manager.close();
	}
}
