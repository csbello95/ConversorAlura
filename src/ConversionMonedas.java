import java.awt.HeadlessException;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.JOptionPane;

public class ConversionMonedas {
	final static String CopToUsd = "Pesos-Colombianos a Dolares";
	final static String CopToEur = "Pesos-Colombianos a Euros";
	final static String CopToGBP = "Pesos-Colombianos a Libras-Esterlinas";
	final static String CopToJPY = "Pesos-Colombianos a Yen-Japones";
	final static String CopToKRW = "Pesos-Colombianos a Won-Sur-Coreano";
	final static String UsdToCop = "Dolares a Pesos-Colombianos";
	
	final static String MToKm = "Metros a Kilometros";
	final static String MToMil = "Metros a Millas";
	
	final static String ConversorDivisas = "Conversor de Divisas";
	final static String ConversorDistancias = "Conversor de Distancias";


	static Object[] option = {CopToUsd,CopToEur,CopToGBP,CopToJPY,CopToKRW,UsdToCop};
	static Object[] conversiontype = {ConversorDivisas, ConversorDistancias};
	static Object[] optionMedidas = {MToKm,MToMil};

	public static void main(String[] args) {

		try {
			Convertidor(option);
		}catch(Exception e) {
			System.out.println(e);
		}

	}

	private static void Convertidor(Object[] option) throws HeadlessException, NumberFormatException {
		boolean continuar = true ;
		while (continuar) {
				String eleccion = (String) JOptionPane.showInputDialog(null,"Selecciona una opción","Conversor",JOptionPane.DEFAULT_OPTION,null,conversiontype,null);
				switch (eleccion) {
					case ConversorDivisas:
					continuar = ConvertidorDivisas();
					case ConversorDistancias: 
					continuar = ConvertidorDistancias();
				}
		}
		JOptionPane.showMessageDialog(null, "Programa Finalizado", "Gracias", JOptionPane.DEFAULT_OPTION,null);
	}

	private static boolean ConvertidorDivisas()
			throws HeadlessException, NumberFormatException {
		
		String eleccion = (String) JOptionPane.showInputDialog(null,"Selecciona una opción","Conversor de Divisas",JOptionPane.DEFAULT_OPTION,null,option,null);
		System.out.println(eleccion);
		String valorOrigen = (String) JOptionPane.showInputDialog(null,"Digita el valor inicial a convertir ","Conversor de Divisas - "+eleccion,JOptionPane.DEFAULT_OPTION,null,null,null);
		System.out.println(valorOrigen);
		Long valorLong = Long.parseLong(valorOrigen);
		
		double resultado= 0.0;

		switch (eleccion) {
			case CopToUsd:// "Pesos Colombianos", "Dolares"
				resultado =ConvertirPesosADivisa(4764.71,valorLong);
				break;
			case CopToEur://"Pesos Colombianos", "Euros"
				resultado= ConvertirPesosADivisa(5091.17,valorLong);
				break;
			case CopToGBP://, "Pesos Colombianos", "Libras Esterlinas"
				resultado=ConvertirPesosADivisa(5806.04,valorLong);
				break;
			case CopToJPY://, "Pesos Colombianos", "Yen Japones"
				resultado=ConvertirPesosADivisa(36.63,valorLong);
				break;
			case CopToKRW://, "Pesos Colombianos", "Won Sur Coreano"
				resultado=ConvertirPesosADivisa(3.70315,valorLong);
				break;
			case UsdToCop:// "Dolares", "Pesos Colombianos"
				resultado=convertirDivisaAPesos(4764.71,valorLong);
				break;
			case "7"://, "Euros", "Pesos Colombianos"
				resultado=convertirDivisaAPesos(5091.17,valorLong);
				break;
			case "8"://, "Libras Esterlinas", "Pesos Colombianos"
				resultado=convertirDivisaAPesos(5806.04,valorLong);
				break;
			/*case '9':
				System.out.println("Cerrando Programa");
				break EXTERNA;*/
			default:
				System.out.println("Opción incorrecta");
				break;
		}
		JOptionPane.showMessageDialog(null, resultado +" "+eleccion.split(" ")[2].replace("-", " "), "Resultado", 0);
		Integer s=JOptionPane.showConfirmDialog(null, "desea continuar?", valorOrigen, JOptionPane.YES_NO_CANCEL_OPTION);
		return s==0?true:false;
	}	
	private static boolean ConvertidorDistancias() {
		double resultado= 0.0;
		return false;
	}


	static double convertirDivisaAPesos(double ValorMoneda,Long valorIngresado) {
		return (double) Math.round((valorIngresado * ValorMoneda)*100d)/100 ;
	}
	
	static double ConvertirPesosADivisa(double ValorMoneda,Long valorIngresado) {
		return (double) Math.round((valorIngresado / ValorMoneda)*100d)/100 ;
	}

}
