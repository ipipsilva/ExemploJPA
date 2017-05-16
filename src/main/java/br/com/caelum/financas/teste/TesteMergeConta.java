package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMergeConta {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
        
        manager.getTransaction().begin();
        
        Conta contaTeste = manager.find(Conta.class, 2);
        
        System.out.println("Titular da conta: " + contaTeste.getTitular());
                
        manager.getTransaction().commit();
        
        manager.close();
        
       EntityManager manager2 = new JPAUtil().getEntityManager();
        
       manager2.getTransaction().begin();
        
       contaTeste.setTitular("Irineu");
       
       manager2.merge(contaTeste);
       
       manager2.getTransaction().commit();
        
       manager2.close();
	}

}
