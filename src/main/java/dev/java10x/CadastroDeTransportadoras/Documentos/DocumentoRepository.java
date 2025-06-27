package dev.java10x.CadastroDeTransportadoras.Documentos;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.java10x.CadastroDeTransportadoras.Transportadoras.TransportadoraModel;

public interface DocumentoRepository extends JpaRepository<TransportadoraModel, Long> {
	// Você pode adicionar métodos customizados aqui depois, se quiser
}
