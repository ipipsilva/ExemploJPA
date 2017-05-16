package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteRemoveConta {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
        conta.setTitular("Joao Ferreira");
        conta.setBanco("HSBC");
        conta.setNumero("123345");
        conta.setAgencia("321");
        
        manager.persist(conta);
        
        manager.remove(conta);
		
		manager.getTransaction().commit();
		manager.close();
	}

}
