package factura;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura_produc {

	public static void main(String[] args) {
		
		Date fecha = new Date ();
		SimpleDateFormat sdf = new SimpleDateFormat (" dd-MM-yyyy");
		sdf.format(fecha);
		String printFecha = sdf.format(fecha);
		
		Scanner scan = new Scanner(System.in);
			
		String	nombre,
				descripción1,
				descripción2,
				Domicilio;
				
		int cantidadProd1;
		int cantidadProd2;
		
		double valor1;
		double valor2;
		double subtotal;
		double total;
		double iva;
		double valoriva = 0.21;
		
		System.out.println("Ingrese Nombre y razón social");
		nombre = scan.nextLine();
		System.out.println("Ingrese domicilio");
		Domicilio = scan.nextLine();
		
		System.out.println("Ingrese producto");
		descripción1 = scan.nextLine();
		System.out.println("Ingrese Cantidad");
		cantidadProd1 = scan.nextInt();
		System.out.println("Ingrese Valor unitario (sin IVA)");
		valor1 = scan.nextDouble();
		
		System.out.println("Siguiente producto");
		descripción2 = scan.next();
		scan.nextLine();
		System.out.println("Ingrese Cantidad");
		cantidadProd2 = scan.nextInt();
		scan.nextLine();
		System.out.println("Ingrese Valor unitario (sin IVA)");
		valor2 = scan.nextDouble();
				
		subtotal = (valor1 + valor2);
		iva = subtotal * valoriva;
		total = subtotal + iva;

		System.out.println("");
		System.out.println("Fecha" + printFecha);
		System.out.println("**************************************************************************************");
		System.out.println(" Nombre / razón social "  + nombre);
		System.out.println(" Domicilio " + Domicilio );
		System.out.println("**************************************************************************************");
		System.out.println(" Cant. | Descripción | P. unit | P.total ");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println(cantidadProd1 + " | " + descripción1 + " | " + valor1 + " | " + valor1 * cantidadProd1);
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println(cantidadProd2 + " | " + descripción2 + " | " + valor2 + " | " + valor2 * cantidadProd1);
		System.out.println(" IVA: " + iva );
		System.out.println(" Subtotal (sin IVA): " + subtotal);
		System.out.println(" Total $: " + total);
		System.out.println("**************************************************************************************");


	}

}


