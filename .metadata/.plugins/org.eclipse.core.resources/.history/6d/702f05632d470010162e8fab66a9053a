package controller;

import java.util.List;
import java.util.Vector;

import model.ConsultaGeralDAO;

public class ConsultaGeralController {
    private final ConsultaGeralDAO dao = new ConsultaGeralDAO();

    public List<String> getTabelasValidas() {
        return dao.getTabelasPermitidas();
    }

    public Vector<String> getColunasTabela(String tabela) {
        return dao.getColunasTabela(tabela);
    }

    public Vector<Vector<Object>> getDadosTabela(String tabela) {
        return dao.getDadosTabela(tabela);
    }
}
