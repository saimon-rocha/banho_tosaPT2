package br.edu.ifsul.bcc.lpoo.projetolpooe1_saimonrocha.model;

public enum ServicoEnum {
    TOSA("Tosa", 30.00),
    UNHAS("Unhas", 20.00),
    BANHO("Banho", 80.00);

    private final String nome;
    private final double valor;

    ServicoEnum(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}
