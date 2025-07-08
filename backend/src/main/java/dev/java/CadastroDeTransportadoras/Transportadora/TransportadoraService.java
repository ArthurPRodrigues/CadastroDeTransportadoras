package dev.java.CadastroDeTransportadoras.Transportadora;

import dev.java.CadastroDeTransportadoras.RegistroDocumento.RegistroDocumentoRepository;
import dev.java.CadastroDeTransportadoras.TipoDocumento.TipoDocumentoRepository;
import dev.java.CadastroDeTransportadoras.RegistroDocumento.RegistroDocumentoModel;
import dev.java.CadastroDeTransportadoras.TipoDocumento.TipoDocumentoModel;

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

	public List<TransportadoraModel> listarTodas() {
		return transportadoraRepository.findAll();
	}

	public TransportadoraModel buscarPorId(Long id) {
		return transportadoraRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Transportadora não encontrada"));
	}

	public TransportadoraModel salvar(TransportadoraModel transportadora) {
		atualizarDisponibilidade(transportadora);
		return transportadoraRepository.save(transportadora);
	}

	public void deletar(Long id) {
		transportadoraRepository.deleteById(id);
	}

	public void atualizarDisponibilidade(TransportadoraModel transportadora) {
		List<TipoDocumentoModel> obrigatorios = tipoDocumentoRepository.findAll()
				.stream()
				.filter(TipoDocumentoModel::isObrigatorio)
				.toList();

		List<RegistroDocumentoModel> registros = registroDocumentoRepository.findByTransportadora(transportadora);

		boolean todosValidos = obrigatorios.stream().allMatch(tipo -> registros.stream().anyMatch(reg -> {
			return reg.getDocumento().getTipoDocumento().getId().equals(tipo.getId())
					&& reg.getDataVencimento().isAfter(LocalDate.now());
		}));

		transportadora.setDisponivelParaFrete(todosValidos);
	}
}
