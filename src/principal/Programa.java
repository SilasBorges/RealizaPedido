package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Cliente;
import entidades.ItensPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enums.StatusPedido;

public class Programa {

	public static void main(String args[]) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do cliente:");
		System.out.print("Nome: ");
		String nomeCliente = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de nascimento (DD/MM/YYYY):");
		Date data = sdf.parse(sc.next());
		
		Cliente cliente = new Cliente(nomeCliente, email, data);
		
		System.out.println("\n Entre com os dados do pedido:");
		
		System.out.print("Status");
		StatusPedido status = StatusPedido.valueOf(sc.next());
		
		Pedido pedido = new Pedido(new Date(), status, cliente);
		
		System.out.print("Quantos itens para esse pedido: ");
		int num = sc.nextInt();		
		
		for(int i = 1; i <= num; i++) {
			
			System.out.println();
			System.out.println("Entre com os dados do produto #" + i + ":");
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			
			System.out.print("Preco do produto: ");
			double precoProduto = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			ItensPedido itensPedido = new ItensPedido(quantidade, precoProduto, produto);
			pedido.addItem(itensPedido);
		}
		
		System.out.println();
		System.out.println(pedido);
		
		sc.close();
		
	}
}
