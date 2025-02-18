import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

public class Exercicio2 {
    public void atividade1() {

        JOptionPane.showMessageDialog(null, "Vamos descobrir o dia da semana através de uma data!!");
        int a = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um ano: "));
        while (a % 400 == 0) {
            JOptionPane.showMessageDialog(null, "Erro: Ano Bissexto!!!");
            a = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um ano: "));
        }
        int m = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um numero corresponde ao mês: "));
        int d = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um dia: "));
        if (m == 1 || m == 2) {
            a = a - 1;
            m = m + 10;
        } else if (m >= 3 && m <= 12) {
            m = m - 2;
        }
        JOptionPane.showMessageDialog(null, "mês alterado: " + m);
        int a1 = a / 100;
        JOptionPane.showMessageDialog(null, "primeiros do ano: " + a1);
        int a2 = a % 100;
        JOptionPane.showMessageDialog(null, "primeiros do ano: " + a2);
        int numeroSemana = (int) ((2.6 * m - 0.1) + d + a2 + (int) (a2 / 4) + (int) (a1 / 4) - (int) (a1 * 2)) % 7;

        JOptionPane.showMessageDialog(null, "resultado da conta: " + numeroSemana);
        String diaSemana = "";
        if (numeroSemana == 0) diaSemana = "Domingo";
        else if (numeroSemana == 1) diaSemana = "Segunda";
        else if (numeroSemana == 2) diaSemana = "Terça";
        else if (numeroSemana == 3) diaSemana = "Quarta";
        else if (numeroSemana == 4) diaSemana = "Quinta";
        else if (numeroSemana == 5) diaSemana = "Sexta";
        else if (numeroSemana == 6) diaSemana = "Sábado";
        JOptionPane.showMessageDialog(null, "Dia semana é: " + diaSemana);


    }

    public void atividade2() {
        JOptionPane.showMessageDialog(null, "Digite uma data e veja se ela é verdadeira! ");
        int d = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o dia: "));
        while (d < 1 || d > 31) {
            JOptionPane.showMessageDialog(null, "Dia inválido: ");
            d = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o dia: "));
        }
        int m = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o mês: "));
        while (m < 1 || m > 12) {
            JOptionPane.showMessageDialog(null, "Mês inválido: ");
            m = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o mês: "));
        }
        int a = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano"));

        if (a % 4 != 0 && m == 2 && d > 28) {
            JOptionPane.showMessageDialog(null, "O ano não é bissexto para ter 29 dias: ");
            d = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o dia: "));
        }
        while (m == 4 && d > 30 || m == 6 && d > 30 || m == 9 && d > 30 || m == 10 && d > 30) {
            JOptionPane.showMessageDialog(null, "Digite um dia válido para o mês digitado, esse mês não tem 31 dias: ");
            d = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o dia: "));
        }
        JOptionPane.showMessageDialog(null, d + "/" + m + "/" + a);
    }

    public void atividade3() {
        //Jokenpô é um jogo de sorte simples onde o jogador deve escolher entre pedra, tesoura
        //e papel. As regras são: Pedra ganha da tesoura (amassando-a ou quebrando-a). Tesoura
        //ganha do papel (cortando-o). Papel ganha da pedra (embrulhando-a). Crie um algoritmo
        //que simule esse jogo entre usuário e computador. OBS: Utilizar a classe
        //java.util.Random para geração de números aleatórios em Java.
        int player1, player2;
        String jogada = "";
        Random gera = new Random();
        player2 = gera.nextInt(1, 3);
        player1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Faça sua jogada:\n (1) Tesoura \n (2) Pedra \n (3) Papel  "));
        if (player1 == player2) JOptionPane.showMessageDialog(null, "Empate");
        else if (player1 == 1 && player2 == 2 || player1 == 3 || player2 == 1 || player1 == 2 && player2 == 3)
            JOptionPane.showMessageDialog(null, "Viória da Maquina");
        else JOptionPane.showMessageDialog(null, "Viória do Humano");
        JOptionPane.showMessageDialog(null, "(1) Tesoura \n (2) Pedra \n (3) Papel \n Você jogou: " + player1 + "------- Ele jogou: " + player2);


    }

    public void atividade4() {
        Random gera = new Random();
        int numeroAleatorio = gera.nextInt(1, 99);
        int meuNumero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um número entre 1 e 99"));
        while (meuNumero < 1 || meuNumero > 99)
            meuNumero = Integer.parseInt(JOptionPane.showInputDialog(null, "Erro: Digite um número entre 1 e 99"));
        int tentativas = 0;
        while (meuNumero != numeroAleatorio) {
            tentativas++;
            meuNumero = Integer.parseInt(JOptionPane.showInputDialog(null, "Erro: Você ainda não adivinhou o número!!"));
            while (meuNumero < 1 || meuNumero > 99)
                meuNumero = Integer.parseInt(JOptionPane.showInputDialog(null, "Erro: Digite um número entre 1 e 99"));
        }
        JOptionPane.showMessageDialog(null, "Parabéns!!! Adivinhou o número: " + numeroAleatorio + "\n Em " + tentativas + " tentativas");
    }

    public void atividade5() {
        String senha = JOptionPane.showInputDialog(null, "Digite uma senha: ");
        while (senha.length() < 8) {
            JOptionPane.showMessageDialog(null, "ERRO: A senha deve ter o mínimo 8 caracteres!!");
            senha = JOptionPane.showInputDialog(null, "Digite uma senha com 8 caracteres: ");
        }
        boolean temMaiuscula = false;
        boolean temMinuscula = false;
        boolean temNumero = false;
        boolean temEspecial = false;
        for (int i = 0; i < senha.length(); i++) {
            char caracter = senha.charAt(i);
            if (Character.isUpperCase(caracter)) {
                temMaiuscula = true;
            }
            if (Character.isLowerCase(caracter)) {
                temMinuscula = true;
            }
            if (Character.isDigit(caracter)) {
                temNumero = true;
            }
            if (!Character.isLetterOrDigit(caracter)) {
                temEspecial = true;
            }
            if (temMaiuscula && temMinuscula && temNumero && temEspecial) {
                System.out.println("Senha válida!");
            } else {
                System.out.println("Senha inválida!");
            }

        }

    }

    public void atividade6() {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        ArrayList<Integer> array3 = new ArrayList<>();

        String n1 = JOptionPane.showInputDialog(null, "Digite o número: ");
        String n2 = JOptionPane.showInputDialog(null, "Digite o número: ");
        for (int i = 0; i<n1.length(); i++) {
            int numero = n1.charAt(i) - '0';
            array1.add((int) numero);
        }
        for (int i = 0; i<n2.length(); i++) {
            int numero = n2.charAt(i) - '0';
            array2.add((int) numero);
        }
        


    }
}