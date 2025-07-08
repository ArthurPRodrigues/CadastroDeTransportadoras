package dev.java.CadastroDeTransportadoras.Cotacoes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CotacoesRepository extends JpaRepository<CotacoesModel, Long> {
	// Você pode adicionar métodos customizados aqui depois, se quiser
}
