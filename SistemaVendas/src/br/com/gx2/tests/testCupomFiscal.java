package br.com.gx2.tests;

import static org.hamcrest.CoreMatchers.is;

import java.util.Date;

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
	
	
	public void CadastroCupomFiscalTest() {
		
	Loja loja = lService.pesquisarLojaId(3);
	Cliente cliente = cService.pesquisarClienteId(243);
	Vendedor vendedor = vService.pesquisarVendedorId(1);
	
	CupomFiscal cupom = new CupomFiscal();	
	
    cupom = new CupomFiscal(null,1500,new Date(),loja,cliente,vendedor);	
	
    
	}

}
