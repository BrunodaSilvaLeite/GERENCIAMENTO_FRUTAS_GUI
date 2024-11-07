import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciamentoFrutasUI extends JFrame {
    private JTextArea areaTexto;
    private JTextField campoFruta;
    private JTextField campoId;
    private ControleDeFrutas gerenciamento;

    public GerenciamentoFrutasUI() {
        // Configuração do JFrame
        setTitle("Gerenciamento de Frutas");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gerenciamento = new ControleDeFrutas();

        // Area de texto para listar as frutas
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll, BorderLayout.CENTER);

        // Painel para os botões e inputs
        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());

        campoFruta = new JTextField(15);
        campoId = new JTextField(5);
        painel.add(new JLabel("Fruta:"));
        painel.add(campoFruta);
        painel.add(new JLabel("ID:"));
        painel.add(campoId);

        // Botões para as ações
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnExcluir = new JButton("Excluir");  // Botão de Excluir
        JButton btnListar = new JButton("Listar");

        painel.add(btnAdicionar);
        painel.add(btnModificar);
        painel.add(btnExcluir);  // Botão de Excluir
        painel.add(btnListar);

        add(painel, BorderLayout.SOUTH);

        // Ação do botão Adicionar
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fruta = campoFruta.getText();
                if (!fruta.isEmpty()) {
                    gerenciamento.adicionarFruta(fruta);  // Chama o método da classe concreta
                    campoFruta.setText("");
                    areaTexto.setText(gerenciamento.listarFrutas());  // Atualiza a lista
                }
            }
        });

        // Ação do botão Adicionar
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Pega o nome da fruta que o usuário digitou no campo de texto
                String fruta = campoFruta.getText();

                // Verifica se o campo não está vazio antes de adicionar
                if (!fruta.isEmpty()) {
                    // Adiciona a fruta na lista chamando o método de gerenciamento
                    gerenciamento.adicionarFruta(fruta);

                    // Limpa o campo de texto para deixar pronto para uma nova entrada
                    campoFruta.setText("");

                    // Atualiza a área de texto para exibir a lista atualizada de frutas
                    areaTexto.setText(gerenciamento.listarFrutas());
                }
            }
        });

// Ação do botão Modificar
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Pega o ID que o usuário digitou e tenta converter para número
                    int id = Integer.parseInt(campoId.getText());

                    // Pega o novo nome da fruta que o usuário digitou
                    String fruta = campoFruta.getText();

                    // Só modifica se o campo de fruta não estiver vazio
                    if (!fruta.isEmpty()) {
                        // Modifica a fruta pelo ID na lista chamando o método de gerenciamento
                        gerenciamento.modificarFruta(id, fruta);

                        // Limpa os campos de texto para ID e fruta, deixando pronto para outra modificação
                        campoFruta.setText("");
                        campoId.setText("");

                        // Atualiza a área de texto com a lista de frutas atualizada
                        areaTexto.setText(gerenciamento.listarFrutas());
                    }
                } catch (NumberFormatException ex) {
                    // Caso o usuário digite algo que não é um número no campo de ID, exibe um aviso
                    JOptionPane.showMessageDialog(null, "ID inválido.");
                }
            }
        });

// Ação do botão Excluir (Remover)
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Tenta pegar o ID que o usuário digitou e converter para número
                    int id = Integer.parseInt(campoId.getText());

                    // Remove a fruta da lista usando o ID
                    gerenciamento.removerFruta(id);

                    // Limpa o campo de ID para evitar confusão na próxima exclusão
                    campoId.setText("");

                    // Atualiza a área de texto com a lista de frutas atualizada
                    areaTexto.setText(gerenciamento.listarFrutas());
                } catch (NumberFormatException ex) {
                    // Mostra um aviso caso o ID digitado não seja um número
                    JOptionPane.showMessageDialog(null, "ID inválido.");
                }
            }
        });

// Ação do botão Listar
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exibe a lista atual de frutas na área de texto
                areaTexto.setText(gerenciamento.listarFrutas());
            }
        });

    }
}
