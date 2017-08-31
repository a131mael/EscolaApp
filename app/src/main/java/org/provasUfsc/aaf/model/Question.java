/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.provasUfsc.aaf.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Question implements Serializable, Parcelable{
    /** Default value included to remove warning. Remove or modify at will. **/

    private static final long serialVersionUID = 1L;

    private Long id;

    private String question;

	private String questionUnder;

	private int fontSizeQuestion;

	private boolean bigQuestion;

    private String opcao1;

    private String opcao2;

    private String opcao3;

    private String opcao4;

    private String opcao5;

    private String opcao6;

    private String opcao7;

    private boolean opcao1Certa;
    private boolean opcao2Certa;
    private boolean opcao3Certa;
    private boolean opcao4Certa;
    private boolean opcao5Certa;
    private boolean opcao6Certa;
    private boolean opcao7Certa;

	private byte[] filePergunta;

	private byte[] filePerguntaUnder;

    private String respostaAberta;

    private String disciplina;

    private int ano;

    private boolean temOpcoes;
	public  Question(){

	}

	private Question(Parcel in) {
		id = in.readLong();
		question = in.readString();
		fontSizeQuestion = in.readInt();
		opcao1 = in.readString();
		opcao2 = in.readString();
		opcao3 = in.readString();
		opcao4 = in.readString();
		opcao5 = in.readString();
		opcao6 = in.readString();
		opcao7 = in.readString();
		opcao1Certa = in.readByte() != 0;
		opcao2Certa = in.readByte() != 0;
		opcao3Certa = in.readByte() != 0;
		opcao4Certa= in.readByte() != 0;
		opcao5Certa= in.readByte() != 0;
		opcao6Certa= in.readByte() != 0;
		opcao7Certa= in.readByte() != 0;

		in.readByteArray(filePergunta);

		respostaAberta =  in.readString();

		disciplina = in.readString();

		 ano = in.readInt();

		temOpcoes = in.readByte() != 0;

	}


	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel out, int flags) {
		out.writeLong(id);
		out.writeString(question);
		out.writeInt(fontSizeQuestion);
		out.writeString(opcao1);
		out.writeString(opcao2);
		out.writeString(opcao3);
		out.writeString(opcao4);
		out.writeString(opcao5);
		out.writeString(opcao6);
		out.writeString(opcao7);

		out.writeByte((byte) (opcao1Certa ? 1 : 0));
		out.writeByte((byte) (opcao2Certa ? 1 : 0));
		out.writeByte((byte) (opcao3Certa ? 1 : 0));
		out.writeByte((byte) (opcao4Certa ? 1 : 0));
		out.writeByte((byte) (opcao5Certa ? 1 : 0));
		out.writeByte((byte) (opcao6Certa ? 1 : 0));
		out.writeByte((byte) (opcao7Certa ? 1 : 0));

		out.writeByteArray(filePergunta);

		out.writeString(respostaAberta);
		out.writeString(disciplina);

		out.writeInt(ano);
		out.writeByte((byte) (temOpcoes ? 1 : 0));

	}

	public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
		public Question createFromParcel(Parcel in) {
			return new Question(in);
		}

		public Question[] newArray(int size) {
			return new Question[size];
		}
	};



	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOpcao1() {
		return opcao1;
	}

	public void setOpcao1(String opcao1) {
		this.opcao1 = opcao1;
	}

	public String getOpcao2() {
		return opcao2;
	}

	public void setOpcao2(String opcao2) {
		this.opcao2 = opcao2;
	}

	public String getOpcao3() {
		return opcao3;
	}

	public void setOpcao3(String opcao3) {
		this.opcao3 = opcao3;
	}

	public String getOpcao4() {
		return opcao4;
	}

	public void setOpcao4(String opcao4) {
		this.opcao4 = opcao4;
	}

	public String getOpcao5() {
		return opcao5;
	}

	public void setOpcao5(String opcao5) {
		this.opcao5 = opcao5;
	}

	public String getOpcao6() {
		return opcao6;
	}

	public void setOpcao6(String opcao6) {
		this.opcao6 = opcao6;
	}

	public String getOpcao7() {
		return opcao7;
	}

	public void setOpcao7(String opcao7) {
		this.opcao7 = opcao7;
	}

	public boolean isOpcao1Certa() {
		return opcao1Certa;
	}

	public void setOpcao1Certa(boolean opcao1Certa) {
		this.opcao1Certa = opcao1Certa;
	}

	public boolean isOpcao2Certa() {
		return opcao2Certa;
	}

	public void setOpcao2Certa(boolean opcao2Certa) {
		this.opcao2Certa = opcao2Certa;
	}

	public boolean isOpcao3Certa() {
		return opcao3Certa;
	}

	public void setOpcao3Certa(boolean opcao3Certa) {
		this.opcao3Certa = opcao3Certa;
	}

	public boolean isOpcao4Certa() {
		return opcao4Certa;
	}

	public void setOpcao4Certa(boolean opcao4Certa) {
		this.opcao4Certa = opcao4Certa;
	}

	public boolean isOpcao5Certa() {
		return opcao5Certa;
	}

	public void setOpcao5Certa(boolean opcao5Certa) {
		this.opcao5Certa = opcao5Certa;
	}

	public boolean isOpcao6Certa() {
		return opcao6Certa;
	}

	public void setOpcao6Certa(boolean opcao6Certa) {
		this.opcao6Certa = opcao6Certa;
	}

	public boolean isOpcao7Certa() {
		return opcao7Certa;
	}

	public void setOpcao7Certa(boolean opcao7Certa) {
		this.opcao7Certa = opcao7Certa;
	}

	public String getRespostaAberta() {
		return respostaAberta;
	}

	public void setRespostaAberta(String respostaAberta) {
		this.respostaAberta = respostaAberta;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public boolean isTemOpcoes() {
		return temOpcoes;
	}

	public void setTemOpcoes(boolean temOpcoes) {
		this.temOpcoes = temOpcoes;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public byte[] getFilePergunta() {

		return filePergunta;
	}

	public void setFilePergunta(byte[] id) {
		this.filePergunta = id;
	}

	public int getFontSizeQuestion() {
		return fontSizeQuestion;
	}

	public void setFontSizeQuestion(int fontSizeQuestion) {
		this.fontSizeQuestion = fontSizeQuestion;
	}

	public String getQuestionUnder() {
		return questionUnder;
	}

	public void setQuestionUnder(String questionUnder) {
		this.questionUnder = questionUnder;
	}

	public byte[] getFilePerguntaUnder() {
		return filePerguntaUnder;
	}

	public void setFilePerguntaUnder(byte[] filePerguntaUnder) {
		this.filePerguntaUnder = filePerguntaUnder;
	}

	public boolean isBigQuestion() {
		return bigQuestion;
	}

	public void setBigQuestion(boolean bigQuestion) {
		this.bigQuestion = bigQuestion;
	}
}
