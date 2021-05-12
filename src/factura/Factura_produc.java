package factura;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Factura_produc {

	public static void main(String[] args) {
		/*
		 * Date fecha = new Date(); SimpleDateFormat sdf = new
		 * SimpleDateFormat(" dd-MM-yyyy"); sdf.format(fecha); String printFecha =
		 * sdf.format(fecha);
		 * 
		 * Scanner scan = new Scanner(System.in);
		 * 
		 * String nombre, descripción1, descripción2, Domicilio;
		 * 
		 * int cantidadProd1, cantidadProd2;
		 * 
		 * double valor1, valor2, subtotal, totaliva, valoriva = 0.21;
		 * 
		 * System.out.println("Ingrese Nombre y razón social"); nombre =
		 * scan.nextLine(); System.out.println("Ingrese domicilio"); Domicilio =
		 * scan.nextLine();
		 * 
		 * System.out.println("Ingrese producto"); descripción1 = scan.nextLine();
		 * System.out.println("Ingrese Cantidad"); cantidadProd1 = scan.nextInt();
		 * System.out.println("Ingrese Valor unitario (sin IVA)"); valor1 =
		 * scan.nextDouble();
		 * 
		 * System.out.println("Siguiente producto"); descripción2 = scan.next();
		 * scan.nextLine(); System.out.println("Ingrese Cantidad"); cantidadProd2 =
		 * scan.nextInt(); scan.nextLine();
		 * System.out.println("Ingrese Valor unitario (sin IVA)"); valor2 =
		 * scan.nextDouble();
		 * 
		 * subtotal = (valor1 + valor2); double iva = subtotal * valoriva; double total
		 * = subtotal + iva;
		 * 
		 * System.out.println(""); System.out.println("Fecha" + printFecha);
		 * System.out.println(
		 * "**************************************************************************************"
		 * ); System.out.println(" Nombre / razón social " + nombre);
		 * System.out.println(" Domicilio " + Domicilio); System.out.println(
		 * "**************************************************************************************"
		 * ); System.out.println(" Cant. | Descripción | P. unit | P.total ");
		 * System.out.println(
		 * "--------------------------------------------------------------------------------------"
		 * ); System.out.println(cantidadProd1 + " | " + descripción1 + " | " + valor1 +
		 * " | " + valor1 * cantidadProd1); System.out.println(
		 * "--------------------------------------------------------------------------------------"
		 * ); System.out.println(cantidadProd2 + " | " + descripción2 + " | " + valor2 +
		 * " | " + valor2 * cantidadProd1); System.out.println(" IVA: " + iva);
		 * System.out.println(" Subtotal (sin IVA): " + subtotal);
		 * System.out.println(" Total $: " + total); System.out.println(
		 * "**************************************************************************************"
		 * );
		 */

		int cantidadUnitariaProducto;
		int cantidadTotalProductos;
		Double valorProducto;
		Double valorProductoTotal = 0.0;
		Double valorTotalConIVA = 0.0;
		Double valorTotal = 0.0;
		Double ivaTotal = 0.0;
		Double iva = 0.21;
		String producto;
		String razonSocial;
		String domicilio;
		String ticket = "";
		String si_no;
		Scanner scan = new Scanner(System.in);
		String date = date();
		razonSocial = razonSocial(scan);
		domicilio = domicilio(scan);
//				cantidadTotalProductos = cantidadDeProductos(scan);
		System.out.println("Desea cargar más productos? (Si/No)");
		si_no = scan.nextLine();
		while (si_no.equals("Si")) {
			producto = producto(scan);
			cantidadUnitariaProducto = cantidadProducto(scan);
			valorProducto = precioUnitario(scan);
			valorProductoTotal = (valorProducto * cantidadUnitariaProducto);
			valorTotal += valorProductoTotal;
			ticket = extracted(cantidadUnitariaProducto, valorProducto, valorProductoTotal, producto, ticket);
//					cantidadTotalProductos = cantidadTotalProductos - 1;
			System.out.println("Desea cargar más productos? (Si/No)");
			scan.nextLine();
			si_no = scan.nextLine();
		}
		ivaTotal += (valorProductoTotal * iva);
		valorTotalConIVA = ivaTotal + valorTotal;
		impresion(valorTotalConIVA, valorTotal, ivaTotal, razonSocial, domicilio, ticket, date);
	}

	private static void impresion(Double valorTotalConIVA, Double valorTotal, Double ivaTotal, String razonSocial,
			String domicilio, String ticket, String date) {
		System.out.println("");
		System.out.println("*************************************************************************************");
		System.out.println("Fecha: " + date);
		System.out.println("*************************************************************************************");
		System.out.println("Nombre: " + razonSocial);
		System.out.println("Domicilio: " + domicilio);
		System.out.println(ticket);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("IVA: " + ivaTotal);
		System.out.println("Subtotal (sin IVA): " + (valorTotal));
		System.out.println("Total: " + valorTotalConIVA);
	}

	private static Double precioUnitario(Scanner scan) {
		Double valorProducto;
		System.out.println("Ingrese el valor unitario (sin IVA) del producto");
		valorProducto = scan.nextDouble();
		return valorProducto;
	}

	private static int cantidadProducto(Scanner scan) {
		int cantidadUnitariaProducto;
		System.out.println("Ingrese la cantidad de unidades del producto");
		cantidadUnitariaProducto = scan.nextInt();
		return cantidadUnitariaProducto;
	}

	private static String producto(Scanner scan) {
		String producto;
		System.out.println("Ingrese el producto de la compra");
		producto = scan.nextLine();
		return producto;
	}

	private static int cantidadDeProductos(Scanner scan) {
		int cantidadTotalProducctos;
		System.out.println("Ingrese la cantidad de productos");
		cantidadTotalProducctos = scan.nextInt();
		return cantidadTotalProducctos;
	}

	private static String domicilio(Scanner scan) {
		String domicilio;
		System.out.println("Ingrese el domicilio");
		domicilio = scan.nextLine();
		return domicilio;
	}

	private static String razonSocial(Scanner scan) {
		String razonSocial;
		System.out.println("Ingrese la razón social del comprador");
		razonSocial = scan.nextLine();
		return razonSocial;
	}

	private static String date() {
		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
		sdf.format(fecha);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		return date;
	}

	private static String extracted(int cantidadUnitariaProducto, Double valorProducto, Double valorProductoTotal,
			String producto, String ticket) {
		ticket += ("\n*************************************************************************************\nCant. "
				+ "\t| Descripcion\t\t\t| P. unit\t\t | P. total"
				+ "\n-------------------------------------------------------------------------------------\n"
				+ cantidadUnitariaProducto + "\t| " + producto + " \t\t\t|" + valorProducto + " \t\t|"
				+ valorProductoTotal);
		return ticket;

	}

}
