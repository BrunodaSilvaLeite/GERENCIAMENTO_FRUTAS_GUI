import java.util.Hashtable;
/* Criando a classe ControleDeFrutas implementa a interface
GerenciamentoFrutas,
que define os metodos para add, list, remove e update frutas.*/
public class ControleDeFrutas implements GerenciamentoFrutas {
    private Hashtable<Integer, String> frutas;
    // Criando metodo construtor
    public ControleDeFrutas() {
        frutas = new Hashtable<>();
    }
    // Sobrescrevendo metodo adicionarFruta para adicionar um index na minha listae adicionar a fruta escrita pelo usuario
    @Override
    public void adicionarFruta(String fruta) {
        int id = frutas.size() + 1;
        frutas.put(id, fruta);
    }
    /* Sobrescrevendo metodo modificarFruta, onde recebo 2 parametros:
    o index e o valor da fruta que o usuário deseja alterar. Existe uma
    validação para saber se
    a fruta existe antes de atualizar.
    */
    @Override
    public void modificarFruta(int id, String fruta) {
        if (frutas.containsKey(id)) {
            frutas.put(id, fruta);
        } else {
            System.out.println("ID não encontrado.");
        }
    }
    /* Sobrescrevendo o método removerFruta, recebendo o valor do index que sera
    removido e fazendo uma
    validação para verificar se a fruta existe antes de deletar. */
    @Override
    public void removerFruta(int id) {
        if (frutas.containsKey(id)) {
            frutas.remove(id);
        } else {
            System.out.println("ID não encontrado.");
        }
    }
    /* Sobrescrevendo metodo listarFrutas, que exibe a lista de frutas utilizando
    StringBuilder. */
    @Override
    public String listarFrutas() {
        StringBuilder lista = new StringBuilder();
        for (Integer id : frutas.keySet()) {
            lista.append(id).append(": ").append(frutas.get(id)).append("\n");
        }
        return lista.toString();
    }
}
