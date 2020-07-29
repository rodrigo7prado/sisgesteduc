package com.rodrigo7prado.sisGestEduc.utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.rodrigo7prado.sisGestEduc.entities.external.CertidoesCsv;

public class CertidoesImportCsv {

	String jdbcURL = "jdbc:mysql://localhost:3307/sisgesteduc?useTimezone=true&serverTimezone=UTC";
	String username = "root";
	String password = "";

	String csvFilePath = "DOC_CONCL_CERTIDOES_EMR_tabledef.csv";
	Connection connection = null;

	ICsvBeanReader beanReader = null;
	CellProcessor[] processors = new CellProcessor[] { 
			new NotNull(new ParseInt()) //1 N_FL
			, new NotNull() //2 LIVRO
			, new Optional() //3 CENSO
			, new Optional() //4 Instituicao
			, new Optional() //5 Inst_Ato_de_criacao
			, new Optional() //6 Data_Inst_Ato_de_criacao
			, new Optional() //7 CURSO
			, new Optional() //8 CONSOLIDADO_Modalidade
			, new Optional() //9 DOC_CONCL_MODALIDADES_Modalidade
			, new Optional() //10 Lei_Modalidade
			, new Optional() //11 Decreto_Modalidade
			, new Optional() //12 Carga Horaria_Modalidade
			, new Optional() //13 Ano
			, new Optional() //14 TURMA
			, new Optional() //15 NOME_COMPL
			, new Optional() //16 ALUNO
			, new Optional() //17 Tipo_Doc
			, new Optional() //18 sexo
			, new Optional() //19 nacionalidade
			, new Optional() //20 naturalidadeUF
			, new Optional() //21 naturalidade
			, new Optional() //22 rg
			, new Optional() //23 rg_emissor
			, new Optional() //24 rg_emissor_UF
			, new Optional(new ParseDate("dd/MM/yyyy HH:mm:ss")) //25 rg_emissao
			, new Optional() //26 Pai
			, new Optional() //27 Mae
			, new Optional(new ParseDate("dd/MM/yyyy HH:mm:ss")) //28 Data_nasc
			, new Optional() //29 SITUACAO_FINAL
			, new Optional(new ParseDate("dd/MM/yyyy HH:mm:ss")) //30 Data_conclusao
			, new Optional(new ParseDate("dd/MM/yyyy HH:mm:ss")) //31 Data_emissao_certificado
			, new Optional() //32 CN_Cartorio
			, new Optional() //33 CN_Municipio
			, new Optional() //34 CN_UF
			, new Optional() //35 CN_TERMO
			, new Optional() //36 CN_LIVRO
			, new Optional() //37 CN_FOLHA
			, new Optional(new ParseDate("dd/MM/yyyy HH:mm:ss")) //38 CN_EMISSAO
			, new ParseBool() //39 A corrigir,
			, new Optional() //40 descr_erro,
			, new ParseBool() //41 Corrigido,
			, new ParseBool() //42 Impresso,
			, new ParseBool() //43 Reimpresso,
			, new ParseBool() //44 Imprimir_agora
	};
	
	public CertidoesImportCsv() {
		
		int batchSize = 20;
		try {
			long start = System.currentTimeMillis();

			connection = DriverManager.getConnection(jdbcURL, username, password);
			connection.setAutoCommit(false);
			
			String sql = "INSERT INTO certidoes_external (nfl"
					+ ", LIVRO, CENSO, Instituicao, Inst_Ato_de_criacao, Data_Inst_Ato_de_criacao, CURSO, CONSOLIDADO_Modalidade, DOC_CONCL_MODALIDADES_Modalidade, Lei_Modalidade, Decreto_Modalidade, Carga_Horaria_Modalidade, Ano, TURMA, NOME_COMPL, ALUNO, Tipo_Doc, sexo, nacionalidade, naturalidade_UF, naturalidade	,rg, rg_emissor, rg_emissor_UF, rg_emissao, Pai, Mae, Data_nasc, SITUACAO_FINAL, Data_conclusao, Data_emissao_certificado, CN_Cartorio, CN_Municipio, CN_UF, CN_TERMO, CN_LIVRO, CN_FOLHA, CN_EMISSAO, A_corrigir,	descr_erro,	Corrigido, Impresso,Reimpresso, Imprimir_agora"
					+ ") "
					+ "VALUES (?"
					+ ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
					+ ")";
			
			PreparedStatement statement = connection.prepareStatement(sql);

			beanReader = new CsvBeanReader(new FileReader(csvFilePath), CsvPreference.STANDARD_PREFERENCE);

			beanReader.getHeader(true); // skip header line
			
			String[] header = { "nfl"
					, "livro", "censo", "instituicao", "instAtoDeCriacao", "dataInstAtoDeCriacao", "curso", "consolidadoModalidade", "docConclMmodalidadesModalidade", "leiModalidade", "decretoModalidade", "cargaHorariaModalidade", "ano", "turma", "nomeCompl", "aluno", "tipoDoc", "sexo", "nacionalidade", "naturalidadeUf", "naturalidade", "rg", "rgEmissor", "rgEmissorUf", "rgEmissao", "pai", "mae", "dataNasc", "situacaoFinal", "dataConclusao", "dataEmissaoCertificado", "cnCartorio", "cnMunicipio", "cnUf", "cnTermo", "cnLivro", "cnFolha", "cnEmissao", "aCorrigir",	"descrErro", "corrigido", "impresso", "reimpresso", "imprimirAgora"
					};
			
			CertidoesCsv bean = null;

			int count = 0;

			while ((bean = beanReader.read(CertidoesCsv.class, header, processors)) != null) {
				
				Integer nfl = bean.getNfl();
				String livro = bean.getLivro();
				String censo = bean.getCenso();
				String instituicao = bean.getInstituicao();
				String instAtoDeCriacao = bean.getInstAtoDeCriacao();
				String dataInstAtoDeCriacao = bean.getDataInstAtoDeCriacao();
				String curso = bean.getCurso();
				String consolidadoModalidade = bean.getConsolidadoModalidade();
				String docConclMmodalidadesModalidade = bean.getDocConclMmodalidadesModalidade();
				String leiModalidade = bean.getLeiModalidade();
				String decretoModalidade = bean.getDecretoModalidade();
				String cargaHorariaModalidade = bean.getCargaHorariaModalidade();
				String ano = bean.getAno();
				String turma = bean.getTurma();
				String nomeCompl = bean.getNomeCompl();
				String aluno = bean.getAluno();
				String tipoDoc = bean.getTipoDoc();
				String sexo = bean.getSexo();
				String nacionalidade = bean.getNacionalidade();
				String naturalidadeUf = bean.getNaturalidadeUf();
				String naturalidade = bean.getNaturalidade();
				String rg = bean.getRg();
				String rgEmissor = bean.getRgEmissor();
				String rgEmissorUf = bean.getRgEmissorUf();
				Date rgEmissao = bean.getRgEmissao(); 
				String pai = bean.getPai();
				String mae = bean.getMae();
				Date dataNasc = bean.getDataNasc(); 
				String situacaoFinal = bean.getSituacaoFinal(); 
				Date dataConclusao = bean.getDataConclusao();
				Date dataEmissaoCertificado = bean.getDataEmissaoCertificado(); 
				String cnCartorio = bean.getCnCartorio();
				String cnMunicipio = bean.getCnMunicipio();
				String cnUf = bean.getCnUf();
				String cnTermo = bean.getCnTermo(); 
				String cnLivro = bean.getCnLivro(); 
				String cnFolha = bean.getCnFolha();
				Date cnEmissao = bean.getCnEmissao();
				Boolean aCorrigir = bean.getaCorrigir();
				String descrErro = bean.getDescrErro();
				Boolean corrigido = bean.getCorrigido();
				Boolean impresso = bean.getImpresso();
				Boolean reimpresso = bean.getReimpresso();
				Boolean imprimirAgora = bean.getImprimirAgora();
				
				if (rgEmissao != null) {
					rgEmissao = new java.sql.Date(rgEmissao.getTime());
				}
				
				if (dataNasc != null) {
					dataNasc = new java.sql.Date(dataNasc.getTime());
				}
				
				if (dataConclusao != null) {
					dataConclusao = new java.sql.Date(dataConclusao.getTime());
				}
				
				if (dataEmissaoCertificado != null) {
					dataEmissaoCertificado = new java.sql.Date(dataEmissaoCertificado.getTime());
				}
				
				if (cnEmissao != null) {
					cnEmissao = new java.sql.Date(cnEmissao.getTime());
				}
				
				
				statement.setInt(1, nfl); 
				statement.setString(2, livro);
				statement.setString(3, censo);
				statement.setString(4, instituicao);
				statement.setString(5, instAtoDeCriacao);
				statement.setString(6, dataInstAtoDeCriacao);
				statement.setString(7, curso);
				statement.setString(8, consolidadoModalidade);
				statement.setString(9, docConclMmodalidadesModalidade);
				statement.setString(10, leiModalidade);
				statement.setString(11, decretoModalidade);
				statement.setString(12, cargaHorariaModalidade);
				statement.setString(13, ano);
				statement.setString(14, turma);
				statement.setString(15, nomeCompl);
				statement.setString(16, aluno);
				statement.setString(17, tipoDoc);
				statement.setString(18, sexo);
				statement.setString(19, nacionalidade);
				statement.setString(20, naturalidadeUf);
				statement.setString(21, naturalidade);
				statement.setString(22, rg);
				statement.setString(23, rgEmissor);
				statement.setString(24, rgEmissorUf); 
				statement.setDate(25, (java.sql.Date) rgEmissao); 
				statement.setString(26, pai);
				statement.setString(27, mae);
				statement.setDate(28, (java.sql.Date) dataNasc); 
				statement.setString(29, situacaoFinal); 
				statement.setDate(30, (java.sql.Date) dataConclusao);
				statement.setDate(31, (java.sql.Date) dataEmissaoCertificado); 
				statement.setString(32, cnCartorio);
				statement.setString(33, cnMunicipio);
				statement.setString(34, cnUf);
				statement.setString(35, cnTermo); 
				statement.setString(36, cnLivro); 
				statement.setString(37, cnFolha);
				statement.setDate(38, (java.sql.Date) cnEmissao);
				statement.setBoolean(39, aCorrigir);
				statement.setString(40, descrErro);
				statement.setBoolean(41, corrigido);
				statement.setBoolean(42, impresso);
				statement.setBoolean(43, reimpresso);
				statement.setBoolean(44, imprimirAgora);
				
				statement.addBatch();

				if (count % batchSize == 0) {
					statement.executeBatch();
				}
			}

			System.out.println("AAAA");
			
			beanReader.close();

			// execute the remaining queries
			statement.executeBatch();

			connection.commit();
			connection.close();

			long end = System.currentTimeMillis();
			System.out.println("Execution Time: " + (end - start));
		} catch (IOException ex) {
			System.err.println(ex);
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
