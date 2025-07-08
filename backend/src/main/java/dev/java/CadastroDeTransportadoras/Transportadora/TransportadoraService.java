package dev.java.CadastroDeTransportadoras.Transportadora;

import dev.java.CadastroDeTransportadoras.RegistroDocumento.RegistroDocumentoModel;
import dev.java.CadastroDeTransportadoras.RegistroDocumento.RegistroDocumentoRepository;
import dev.java.CadastroDeTransportadoras.TipoDocumento.TipoDocumentoModel;
import dev.java.CadastroDeTransportadoras.TipoDocumento.TipoDocumentoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportadoraService {

	private final TransportadoraRepository transportadoraRepository;
	private final RegistroDocumentoRepository registroDocumentoRepository;
	private final TipoDocumentoRepository tipoDocumentoRepository;

	public void atualizarDisponibilidade(TransportadoraModel transportadora) {
		// 1. Buscar todos os tipos obrigatórios
		List<TipoDocumentoModel> obrigatorios = tipoDocumentoRepository.findAll()
				.stream()
				.filter(TipoDocumentoModel::isObrigatorio)
				.toList();

		// 2. Buscar todos os registros de documentos dessa transportadora
		List<RegistroDocumentoModel> registros = registroDocumentoRepository.findByTransportadora(transportadora);

		// 3. Verificar se há algum obrigatório faltando ou vencido
		boolean todosValidos = obrigatorios.stream().allMatch(tipo -> registros.stream().anyMatch(reg -> {
			return reg.getDocumento().getTipoDocumento().getId().equals(tipo.getId())
					&& reg.getDataVencimento().isAfter(LocalDate.now());
		}));

		transportadora.setDisponivelParaFrete(todosValidos);
		transportadoraRepository.save(transportadora);
	}
}
