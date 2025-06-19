package dev.java10x.CadastroDeTransportadoras.Transportadoras;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.java10x.CadastroDeTransportadoras.Cotacoes.CotacoesModel;

public interface TransportadoraRepository extends JpaRepository<CotacoesModel, Long> {
	// Você pode adicionar métodos customizados aqui depois, se quiser
}
