package br.com.gx2.testes;

import java.util.List;

import br.com.gx2.entity.CupomFiscal;
import br.com.gx2.service.CupomFiscalService;
import br.com.gx2.service.ServiceFactory;

public class TesteService {

	public static void main(String[] args) {
		
		CupomFiscalService service =  ServiceFactory.createCupomFiscalService();
		
		List<CupomFiscal> cupons = service.exibirTodosCuponsFiscais();
		for (CupomFiscal c1 : cupons) {
			System.out.print(c1.getCodigoCupom() + " - ");
			System.out.print(c1.getEmissao() + " - ");
			System.out.print(c1.getLoja().getNomeLoja() + " - ");
			System.out.print(c1.getVendedor().getNomeVendedor() + " - ");
			System.out.print(c1.getCliente().getNomeCliente() + " - ");
			System.out.println(c1.getCliente().getCpf());
		}
		
		
	}

}
