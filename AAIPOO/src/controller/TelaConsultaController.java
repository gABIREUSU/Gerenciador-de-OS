package controller;

import model.TelaConsultaDAO;
import java.util.*;

public class TelaConsultaController {
    private final TelaConsultaDAO dao;

    public TelaConsultaController() {
        this.dao = new TelaConsultaDAO();
    }

    public List<Object[]> buscarDados(String tabela, String campoFiltro, String valorFiltro) {
        return switch (tabela) {
            case "Empresas" -> dao.consultarEmpresasFiltro(campoFiltro, valorFiltro);
            case "Equipamento" -> dao.consultarEquipamentosFiltro(campoFiltro, valorFiltro);
            case "OS" -> dao.consultarOSFiltro(campoFiltro, valorFiltro);
            default -> new ArrayList<>();
        };
    }

    public List<Object[]> buscarItensPorOS(int codOS) {
        return dao.consultarItensPorOS(codOS);
    }

    public String[] getColunas(String tabela) {
        return switch (tabela) {
            case "Empresas" -> new String[]{"Cod_Emp", "Nome", "CNPJ", "Endereco", "Telefone"};
            case "Equipamento" -> new String[]{"Cod_Equip", "NomeEmpresa", "Nome_Equip"};
            case "OS" -> new String[]{"Cod_OS", "Nome_Equip", "NomeEmpresa", "Data", "Preco"};
            default -> new String[0];
        };
    }
}