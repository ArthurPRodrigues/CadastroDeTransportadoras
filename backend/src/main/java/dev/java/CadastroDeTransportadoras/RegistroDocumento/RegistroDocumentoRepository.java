package dev.java.CadastroDeTransportadoras.RegistroDocumento;

import dev.java.CadastroDeTransportadoras.Transportadora.TransportadoraModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroDocumentoRepository extends JpaRepository<RegistroDocumentoModel, Long> {
	List<RegistroDocumentoModel> findByTransportadora(TransportadoraModel transportadora);
}
