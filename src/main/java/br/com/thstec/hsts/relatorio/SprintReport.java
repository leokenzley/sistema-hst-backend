package br.com.thstec.hsts.relatorio;

public interface SprintReport {
    byte[] gerarPdf(Long id) throws Exception;
}
