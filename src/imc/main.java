package imc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main { // Corrigido o nome da classe para começar com maiúscula
    public static void main(String[] args) {
        // Criar a janela principal
        JFrame frame = new JFrame("Calculadora de IMC");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 1)); // Layout com 6 linhas

        // Criar os componentes
        JLabel labelPeso = new JLabel("Digite seu peso (kg):");
        JTextField campoPeso = new JTextField();

        JLabel labelAltura = new JLabel("Digite sua altura (m):");
        JTextField campoAltura = new JTextField();

        JButton botaoCalcular = new JButton("Calcular IMC");
        JLabel labelResultado = new JLabel("Seu IMC aparecerá aqui");

        // Adicionar ação ao botão
        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double peso = Double.parseDouble(campoPeso.getText());
                    double altura = Double.parseDouble(campoAltura.getText());
                    double imc = peso / (altura * altura);

                    // Determinar a categoria do IMC
                    String categoria;
                    if (imc < 18.5) {
                        categoria = "Abaixo do peso";
                    } else if (imc < 24.9) {
                        categoria = "Peso normal";
                    } else if (imc < 29.9) {
                        categoria = "Sobrepeso";
                    } else if (imc < 34.9) {
                        categoria = "Obesidade Grau 1";
                    } else if (imc < 39.9) {
                        categoria = "Obesidade Grau 2";
                    } else {
                        categoria = "Obesidade Grau 3 (Mórbida)";
                    }

                    // Atualizar o label com o resultado
                    labelResultado.setText(String.format("IMC: %.2f - %s", imc, categoria));
                } catch (NumberFormatException ex) {
                    labelResultado.setText("Erro: Insira valores válidos!");
                }
            }
        });

        // Adicionar componentes à janela
        frame.add(labelPeso);
        frame.add(campoPeso);
        frame.add(labelAltura);
        frame.add(campoAltura);
        frame.add(botaoCalcular);
        frame.add(labelResultado);

        // Tornar a janela visível
        frame.setVisible(true);
    }
}