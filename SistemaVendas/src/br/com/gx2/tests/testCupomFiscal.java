package br.com.gx2.tests;

import static org.hamcrest.CoreMatchers.is;

import java.util.Date;

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

public class testCupomFiscal {
	
	private CupomFiscalService cfService = ServiceFactory.createCupomFiscalService();
	private LojaService lService = ServiceFactory.createLojaService();
	private ClienteService cService = ServiceFactory.createClienteService();
	private VendedorService vService = ServiceFactory.createVendedorService();
	
	@Test
	public void CadastroCupomFiscalTest() {
		
	Loja loja = lService.pesquisarLojaId(3);
	Cliente cliente = cService.pesquisarClienteId(243);
	Vendedor vendedor = vService.pesquisarVendedorId(1);
	
	Date data = new Date();
	
	CupomFiscal cupom = cfService.cadastrarCupomFiscal (null,1500,data,loja,cliente,vendedor);  	
	
  	
	
    
	}

}
