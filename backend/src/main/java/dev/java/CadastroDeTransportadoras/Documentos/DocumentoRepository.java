package dev.java.CadastroDeTransportadoras.Documentos;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.java.CadastroDeTransportadoras.Transportadora.TransportadoraModel;

public interface DocumentoRepository extends JpaRepository<TransportadoraModel, Long> {
	// Você pode adicionar métodos customizados aqui depois, se quiser
}
