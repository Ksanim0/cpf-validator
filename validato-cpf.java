package algoritmo;
import java.util.Arrays;



public class index {
	public static void main (String[] args) {
		
		/* PROCESSO PARA CAPTAR O CPF*/
		            
		
		/*A variável CPF deve conter os 9 primeiros digítos do CPF*/
		String cpf = "016779393";
		String cpfformado = cpf.replaceAll("[^0-9]+", "");
		
		
		int MultiplicarValordoCPF = 0; /* 10*/
		int EnderecoDoArray = 0;  /*limite de 8*/
		int CPFVetorizado [] = new int [9];
		int soma = 0;
		int PrimeiroDigitoValidador = 0;
			
			
		/* VERIFICANDO O PRIMEIRO DIGITO F*/

		
		
			for(MultiplicarValordoCPF = 10; MultiplicarValordoCPF >= 2; MultiplicarValordoCPF--) {
				int temp = MultiplicarValordoCPF * (cpfformado.charAt(EnderecoDoArray) - '0');
				
				
				
				CPFVetorizado[EnderecoDoArray] = temp;
				
				 soma = Arrays.stream(CPFVetorizado).reduce(0,(a,b)-> a + b);
				 
				 PrimeiroDigitoValidador = (soma*10) % 11;
				
				 
				 
				EnderecoDoArray++;	
			}
			
			
			if(PrimeiroDigitoValidador > 9) {
				PrimeiroDigitoValidador = 0;
			}
			
			
			System.out.println(PrimeiroDigitoValidador);
			
			
			
			
			/* VALIDAÇAO SEGUNDO DIGITO */
			
			/* Criando o cpf com primeiro digito validador*/
			String cpfMais1 = cpf + PrimeiroDigitoValidador;
			
			System.out.println(cpfMais1);
			
			/*Início para  indentificção do segundo dígito*/
			int segundoMult = 0; /*LIMITE DE 11*/
			int indiceDoArray = 0;
			int cpfMais1Vetorizado[] = new int [10]; /*novos 10 digitos do cpf*/
			int someiri = 0;
			int SegundoDigitoValidador = 0;
			
			
			/*Algorito para validar*/
			for(segundoMult = 11; segundoMult >= 2; segundoMult--){
				int temporaria = segundoMult * (cpfMais1.charAt(indiceDoArray) - '0');
				
				cpfMais1Vetorizado[indiceDoArray] = temporaria;
				
				someiri = Arrays.stream(cpfMais1Vetorizado).reduce(0,(a, b)-> a+b);
				
				SegundoDigitoValidador = (someiri*10) %11;
				
				indiceDoArray++;
				
			}
			
			System.out.println( SegundoDigitoValidador );
			
			String cpfCompleto = cpfMais1 + SegundoDigitoValidador ;
			
			System.out.println( cpfCompleto );
			
	        /*Formatando pra o formato padrão do CPF*/
	        String cpfFormatado = cpfCompleto;
	        cpfFormatado = cpfFormatado.substring(0, 3) + "." +
	                       cpfFormatado.substring(3, 6) + "." +
	                       cpfFormatado.substring(6, 9) + "-" +
	                       cpfFormatado.substring(9);
	        System.out.println(cpfFormatado);
	}
}			