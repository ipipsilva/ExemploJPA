package br.com.caelum.financas;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
        conta.setTitular("Joao Ferreira");
        conta.setBanco("HSBC");
        conta.setNumero("123345");
        conta.setAgencia("321");
        
        EntityManager manager = new JPAUtil().getEntityManager();
        
        manager.getTransaction().begin();
        manager.persist(conta);        
        manager.getTransaction().commit();
        
        manager.close();
	}
}
