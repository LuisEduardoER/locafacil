package com.locafacil.util;

import java.lang.*;

import com.locafacil.exceptions.InvalidStatement;

public class Validator {

/**
* Método p/ validacao de CPF.
* Baseada no algoritmo de geracao de digito de verificacao, Modulo 11.
* O CPF deve ser passado como string, somente com numeros, sem pontos ou
* traco. O sistema não aceitara string diferente de 11 caracter.
*/
public static String validaCpf(String cpf) throws InvalidStatement{
	int i, j, k;
	int soma;
	int digito;
	int numeroI;
	boolean confirmacao,tamanho;
	String numero;
	String mensagem = "";
	
	confirmacao = false;
	if (cpf.length() == 11){
		numero = cpf.substring(0, 9);
		for (j=1; j<3; j++){
			k = 2;
			soma = 0;
			for (i= (numero.length() - 1); i>=0; i--){
				numeroI = Integer.parseInt(String.valueOf(numero.charAt(i)));
				soma = soma + numeroI * k;
				k = k + 1;
			}
			digito = 11 - (soma % 11);
			if (digito >= 10)
			digito = 0;
			numero = numero + digito;
		}
		confirmacao = true;
		if (!cpf.equals(numero)){
		mensagem = "CPF Invalido!";
		confirmacao = false;
		}
	}else {
		mensagem = "O CPF deve ter 11 digitos!";
	}
	if (!confirmacao) {
		throw new InvalidStatement(cpf,mensagem);}
	return cpf;
	}

/**
* Metodo validador de e-mails
* Este metodo irá retornar uma string com E-mail digitado para validacao.
* Sera feito verificacao de presencao do arroba e do ponto no contexto.
* Sera lancado uma excecao com uma mensagem informando o motivo do erro.
*/

public static String validaEmail(String eMail) throws InvalidStatement{
	boolean resp = false;
	String mensagem = "";
	
	if (eMail.length() != 0){
		if (eMail.indexOf('.') == -1){
			mensagem = "Esta faltando o ponto (.)!";
		}
		if (eMail.indexOf('@') == -1){
			mensagem = "Esta faltando o arroba (@)!";
		}
		if ((eMail.indexOf('@') != -1) && (eMail.indexOf('.') != -1)){
			if (eMail.indexOf('.', eMail.indexOf('@')) != -1) {
				resp = true;
			}else{
				mensagem = "Esta faltando o ponto (.) depois do arroba (@)!";}
		}
		if (resp) {
			eMail = eMail.toLowerCase();
		}else{
			throw new InvalidStatement(eMail,mensagem);
		}
	}
	return eMail;
}

public static String validaData(String data) throws InvalidStatement {
	boolean resp = true;
	String mensagem = "";
	
	if (data.length() == 10){
		if (data.indexOf('/') == -1){
			if (data.indexOf('/',data.indexOf('/')) != -1){
				resp = true;
			}else{
				resp = false;
				mensagem = "O formato da data válido é dd/mm/aaaa!";
			}
		}
	}else{
		mensagem = "O formato da data válido é dd/mm/aaaa!";
		resp = false;
	}
	if (!resp){
		throw new InvalidStatement(data,mensagem);
	}
	
	return data;
}
}