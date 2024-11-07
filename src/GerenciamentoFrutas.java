public interface GerenciamentoFrutas {
    void adicionarFruta(String fruta);
    void modificarFruta(int id, String fruta);
    void removerFruta(int id);
    String listarFrutas();
}
