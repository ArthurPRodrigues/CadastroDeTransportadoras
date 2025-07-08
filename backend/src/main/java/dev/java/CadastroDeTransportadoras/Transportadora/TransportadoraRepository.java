package dev.java.CadastroDeTransportadoras.Transportadora;

import dev.java.CadastroDeTransportadoras.Transportadora.TransportadoraModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransportadoraRepository extends JpaRepository<TransportadoraModel, Long> {
	List<TransportadoraModel> findByDisponivelParaFreteTrue();
	List<TransportadoraModel> findByDisponivelParaFreteFalse();
	List<TransportadoraModel> findByEstadoAndDisponivelParaFreteTrue(String estado);
}
