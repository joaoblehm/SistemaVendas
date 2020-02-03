package br.com.gx2.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Cliente;
import br.com.gx2.entity.CupomFiscal;

import br.com.gx2.entity.Loja;

import br.com.gx2.entity.Vendedor;
import br.com.gx2.service.ClienteService;
import br.com.gx2.service.CupomFiscalService;
import br.com.gx2.service.LojaService;
import br.com.gx2.service.ServiceFactory;
import br.com.gx2.service.VendedorService;

public class TestCupomFiscal {
	
	private CupomFiscalService cfService = ServiceFactory.createCupomFiscalService();
	private LojaService lService = ServiceFactory.createLojaService();
	private ClienteService cService = ServiceFactory.createClienteService();
	private VendedorService vService = ServiceFactory.createVendedorService();
	
	@Test
	public void CadastroCupomFiscalTest() {
	
		 //Loja: 1,3,4
		 //Clientes: 243,258,259,260,262,263,264,265,266,267
		//vendedores: 1,2,3,4,5,6,7,8,9
	
		
	Loja loja = lService.pesquisarLojaId(3);
	Cliente cliente  = cService.pesquisarClienteId(243);
	Vendedor vendedor = vService.pesquisarVendedorId(3);
	
	int codigoCupom = 1;
	double valorTotal = 10.35;
	

	CupomFiscal cupom = new CupomFiscal(codigoCupom, valorTotal, new Date(),loja,cliente,vendedor);

	boolean retorno = cfService.cadastrarCupomFiscal(cupom);
	assertTrue(retorno);
	

	
    
	}
	
	@Test
	
	public void AlterarCupomFiscalTest() {
		
		Loja loja = lService.pesquisarLojaId(4);
		Cliente cliente  = cService.pesquisarClienteId(265);
		Vendedor vendedor = vService.pesquisarVendedorId(6); 
		
		int codigoCupom = 1;
		double valorTotal = 15.41;
		
		CupomFiscal cupom = new CupomFiscal(codigoCupom, valorTotal, new Date(),loja,cliente,vendedor);

		boolean retorno = cfService.alterarCupomFiscal(cupom);
		assertTrue(retorno);
		
	}
	
	
	@Test
	
	public void ApagarCupomFiscalTest() {
		
	 boolean retorno = cfService.apagarCupomFiscal(6);	
		
		assertNull(cfService.pesquisarCupomFiscalId(6));
		assertTrue(retorno);
		
		
	}
	
	@Test
	
	public void PesquisarCupomFiscalTest() {
		
		
		CupomFiscal cupom = cfService.pesquisarCupomFiscalId(9);
		
		
		assertThat(cfService.pesquisarCupomFiscalId(9), is(cupom));
		
		
		
	}
	
	@Test
	
	public void ExibirTodosCupomFiscalTest() {
		
		List<CupomFiscal> listaF = cfService.exibirTodosCuponsFiscais();
		assertThat(cfService.exibirTodosCuponsFiscais(), is(listaF));	
		
		
	}
	
	

}
