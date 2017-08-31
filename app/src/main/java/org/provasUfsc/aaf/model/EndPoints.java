package org.provasUfsc.aaf.model;

public class EndPoints {


	/*private static StringBuilder urlBase = new StringBuilder("http://192.168.1.4/");
	private static StringBuilder urlBase = new StringBuilder("http://192.168.25.36/");
	private static String context = "ProvaUFSCWebService";
*/
	private static StringBuilder urlBase = new StringBuilder("http://ec2-52-67-36-232.sa-east-1.compute.amazonaws.com");
	private static String context = "/ProvasUFSC";

	public static final String QUESTIONS_BY_DISCIPLINE = new StringBuilder(urlBase).append(context).append("/rest/questions/discipline/*1").toString();

	public static final String QUESTIONS_BY_YEAR = new StringBuilder(urlBase).append(context).append("/rest/questions/discipline/*1").toString();

	public static final String QUESTIONS_BY_YEAR_AND_DISCIPLINE = new StringBuilder(urlBase).append(context).append("/rest/questions/disciplineYear?discipline=*1&year=*2").toString();

	public static final String SAVE_USER = new StringBuilder(urlBase).append(context).append("/rest/users/").toString();

	public static final String GET_USER_BY_ID = new StringBuilder(urlBase).append(context).append("/rest/users/id/*1").toString();

	public static final String SAVE_GROUP = new StringBuilder(urlBase).append(context).append("/rest/groups/").toString();

	public static final String GET_GROUP_BY_ID = new StringBuilder(urlBase).append(context).append("/rest/groups/id/*1").toString();


	public static final String USER_MAIOR_PONTUADOR = new StringBuilder(urlBase).append(context).append("/rest/users/maiorPontuadorGeral/").toString();
	public static final String USER_MAIOR_PONTUADOR_MES = new StringBuilder(urlBase).append(context).append("/rest/users/maiorPontuadorMes/").toString();
	public static final String USER_MAIOR_PONTUADOR_SEMANA = new StringBuilder(urlBase).append(context).append("/rest/users/maiorPontuadorSemana/").toString();

	public static final String GROUP_MAIOR_PONTUADOR = new StringBuilder(urlBase).append(context).append("/rest/groups/maiorPontuadorGeral/*1").toString();
	public static final String GROUP_MAIOR_PONTUADOR_MES = new StringBuilder(urlBase).append(context).append("/rest/groups/maiorPontuadorMes/*1").toString();
	public static final String GROUP_MAIOR_PONTUADOR_SEMANA = new StringBuilder(urlBase).append(context).append("/rest/groups/maiorPontuadorSemana/*1").toString();
}

