package segundoteste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Segundo {

	private int idUnico;
	private Map<Integer, String> idNome;
	private Map<Integer, String> idStatus;

	public Segundo() {
		idNome = new HashMap<>();
		idStatus = new HashMap<>();
	}

	public int iniciarProcesso(String nome) throws Exception {

		if (nome.isBlank()) {
			throw new Exception("Nome inválido");
		}

		for (Map.Entry<Integer, String> codigo : idNome.entrySet()) {
			if (codigo.getValue().equals(nome)) {
				throw new Exception("Candidato já participa do processo");
			}
		}

		idUnico++;
		idNome.put(idUnico, nome);
		idStatus.put(idUnico, "Recebido");

		return idUnico;
	}

	public void marcarEntrevista(int codCandidato) throws Exception {
		String status = idStatus.get(codCandidato);

		if (status == null) {
			throw new Exception("Candidato não encontrado");
		} else if (!status.equals("Recebido")) {
			throw new Exception("Candidato não encontrado");
		}

		idStatus.put(codCandidato, "Qualificado");
	}

	public void desqualificarCandidato(int codCandidato) throws Exception {

		String status = idStatus.get(codCandidato);
		if (status == null) {
			throw new Exception("Candidato não encontrado");
		}

		idStatus.remove(codCandidato);
		idNome.remove(codCandidato);
	}

	public String verificarStatusCandidato(int codCandidato) throws Exception {

		String status = idStatus.get(codCandidato);
		if (status == null) {
			throw new Exception("Candidato não encontrado");
		}

		return status;
	}

	public void aprovarCandidato(int codCandidato) throws Exception {

		String status = idStatus.get(codCandidato);
		
		if (status == null) {
			throw new Exception("Candidato não encontrado");
		} else if (!status.equals("Qualificado")) {
			throw new Exception("Candidato não encontrado");
		}

		idStatus.put(codCandidato, "Aprovado");
	}

	public List<String> obterAprovados() {
		List<String> aprovados = new ArrayList<String>();

		for (Map.Entry<Integer, String> codigo : idStatus.entrySet()) {
			if (codigo.getValue().equals("Aprovado")) {
				aprovados.add(idNome.get(codigo.getKey()));
			}
		}
		return aprovados;

	}
}
