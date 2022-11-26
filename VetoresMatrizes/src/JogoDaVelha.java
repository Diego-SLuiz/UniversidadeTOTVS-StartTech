import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Boolean continuarJogando = true;
        String[] simbolosTabuleiro = {" ", "X", "O"};
        Integer[][] condicoesVitoria = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

        // Continuação do jogo
        while (continuarJogando) {
            Integer[] posicoesTabuleiro = {0, 0, 0, 0, 0, 0, 0, 0, 0};
            Boolean partidaEmAndamento = true;

            // Continuação da partida
            while (partidaEmAndamento) {

                // Turno dos jogadores
                for (int jogador = 0; jogador < 2; jogador++) {
                    Boolean posicaoInvalida = true;
                    Boolean encerrarTurnos = false;

                    // Turno de um jogador
                    while (posicaoInvalida) {
                        System.out.printf("Jogador %d, escolha uma posição de 1 à 9: ", jogador + 1);
                        Integer posicaoEscolhida = Integer.parseInt(entrada.nextLine());

                        if (posicaoEscolhida < 1 || posicaoEscolhida > 9) {
                            System.out.printf("Uma posição entre 1 e 9 é necessário, mas foi informado %d\n", posicaoEscolhida);
                        } else if (posicoesTabuleiro[posicaoEscolhida - 1] != 0) {
                            System.out.printf("A posição %d já está ocupada com uma peça\n", posicaoEscolhida);
                        } else {
                            posicoesTabuleiro[posicaoEscolhida - 1] = jogador + 1;
                            posicaoInvalida = false;
                        }
                    }

                    // Mostrar as peças do tabuleiro
                    System.out.println("\n");
                    for (int i = 0; i < posicoesTabuleiro.length; i++) {
                        System.out.print(simbolosTabuleiro[posicoesTabuleiro[i]]);
                        System.out.print((i + 1) % 3 == 0 ? "\n" : " | ");
                    }
                    System.out.println("\n");

                    // Validar condições de vitória
                    for (Integer[] condicao : condicoesVitoria) {
                        if (posicoesTabuleiro[condicao[0]] == jogador + 1 && posicoesTabuleiro[condicao[1]] == jogador + 1 && posicoesTabuleiro[condicao[2]] == jogador + 1) {
                            System.out.printf("Jogador %d venceu!\n", jogador + 1);
                            partidaEmAndamento = false;
                            encerrarTurnos = true;
                        }
                    }

                    // Encerrar turno caso algum jogador ganhe
                    if (encerrarTurnos) {
                        break;
                    }
                }
            }

            // Verificar se o usuário deseja sair do jogo
            System.out.println("Deseja continuar jogando? (s/n)");
            if (!entrada.nextLine().equalsIgnoreCase("s")) {
                continuarJogando = false;
                System.out.println("Saindo do jogo...");
            }
        }
    }

}
