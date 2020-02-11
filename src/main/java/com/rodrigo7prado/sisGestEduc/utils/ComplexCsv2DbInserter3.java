package com.rodrigo7prado.sisGestEduc.utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.rodrigo7prado.sisGestEduc.entities.external.AlunosExternal;

public class ComplexCsv2DbInserter3 {

	private String jdbcURL = "jdbc:mysql://localhost:3306/sisgesteduc?useTimezone=true&serverTimezone=UTC";
	private String username = "root";
	private String password = "";

	private String csvFilePath = "consolidado_manual_aluno.csv";
	private Connection connection = null;

	ICsvBeanReader beanReader = null;
	CellProcessor[] processors = new CellProcessor[] { new Optional(), // NOME_COMPL
			new NotNull() // ALUNO
//			new Optional(), // Status_Matricula_Conex
//			new Optional(), // Data_conclusao_EM
//			new Optional(), // Data_nasc
//			new Optional(), // Pai
//			new Optional(), // Mae
//			new Optional(), // sexo
//			new Optional(), // nacionalidade
//			new Optional(), // naturalidadeUF
//			new Optional(), // naturalidade
//			new Optional(), // rg
//			new Optional(), // rg_emissor
//			new Optional(), // rg_emissor_UF
//			new Optional(), // rg_emissao
//			new Optional(), // CN_Cartorio
//			new Optional(), // CN_Municipio
//			new Optional(), // CN_UF
//			new Optional(), // CN_TERMO
//			new Optional(), // CN_LIVRO
//			new Optional(), // CN_FOLHA
//			new Optional(), // CN_EMISSAO
//			new Optional(), // OBS_HIST
//			new Optional(), // OBS_HIST_1
//			new Optional(), // OBS_HIST_2
//			new ParseBool(), // Falta_HE_Fundamental
//			new ParseBool(), // Falta_HE_Medio
//			new ParseBool(), // Falta_Rg
//			new ParseBool(), // Falta_CN
//			new ParseBool(), // DADOS_CONFERIDOS
//			new Optional(), // Mais_de_um_curso
//			new Optional(), // EF_Escola_conc
//			new Optional(), // EF_Escola_conc_Local
//			new Optional(), // EF_Ano_ConcEF_Conc_Emissao
//			new Optional(), // EF_num_pag

			// new NotNull(), // student name
			// new ParseTimestamp(), // timestamp
			// new ParseDouble(), // rating
			// new Optional()// comment
	};

	public ComplexCsv2DbInserter3() {
		int batchSize = 20;
		try {
			long start = System.currentTimeMillis();

			connection = DriverManager.getConnection(jdbcURL, username, password);
			connection.setAutoCommit(false);

//			String sql = "INSERT INTO consolidado_manual_alunos (nome_completo,ALUNO,Data_conclusao_EM,Data_nasc,Pai,Mae,sexo,nacionalidade,naturalidadeUF,naturalidade,rg,rg_emissor,rg_emissor_UF,rg_emissao,CN_Cartorio,CN_Municipio,CN_UF,CN_TERMO,CN_LIVRO,CN_FOLHA,CN_EMISSAO,OBS_HIST,Falta_HE_Fundamental,Falta_HE_Medio,Falta_Rg,Falta_CN,DADOS_CONFERIDOS,EF_Escola_conc,EF_Escola_conc_Local,EF_Ano_Conc,EF_Conc_Emissao,EF_num_pag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			String sql = "INSERT INTO consolidado_manual_alunos (nome_completo,aluno) VALUES (?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);

			beanReader = new CsvBeanReader(new FileReader(csvFilePath), CsvPreference.STANDARD_PREFERENCE);

			beanReader.getHeader(true); // skip header line

//			String[] header = { "courseName", "studentName", "timestamp", "rating", "comment" };
//			String[] header = { "NOME_COMPL", "ALUNO", "Data_conclusao_EM", "Data_nasc", "Pai", "Mae", "sexo",
//					"nacionalidade", "naturalidadeUF", "naturalidade", "rg", "rg_emissor", "rg_emissor_UF",
//					"rg_emissao", "CN_Cartorio", "CN_Municipio", "CN_UF", "CN_TERMO", "CN_LIVRO", "CN_FOLHA",
//					"CN_EMISSAO", "OBS_HIST", "Falta_HE_Fundamental", "Falta_HE_Medio", "Falta_Rg", "Falta_CN",
//					"DADOS_CONFERIDOS", "EF_Escola_conc", "EF_Escola_conc_Local", "EF_Ano_Conc", "EF_Conc_Emissao",
//					"EF_num_pag" };
			String[] header = { "nomeCompleto", "matricula" };
			
			AlunosExternal bean = null;

			int count = 0;

			while ((bean = beanReader.read(AlunosExternal.class, header, processors)) != null) {
				String nomeCompleto = bean.getNomeCompleto();
				String matricula = bean.getMatricula();
//				String Data_conclusao_EM = bean.getDataConclusaoEM();
//				String Data_nasc = bean.getDataNasc();
//				String Pai = bean.getNomePai();
//				String Mae = bean.getNomeMae();
//				String sexo = bean.getSexo();
//				String nacionalidade = bean.getNacionalidade();
//				String naturalidadeUF = bean.getNacionalidade();
//				String naturalidade = bean.getNaturalidade();
//				String rg = bean.getRg();
//				String rg_emissor = bean.getRgEmissor();
//				String rg_emissor_UF = bean.getRgEmissorUF();
//				String rg_emissao = bean.getRgDataEmissao();
//				String CN_Cartorio = bean.getCnCartorio();
//				String CN_Municipio = bean.getCnMunicipio();
//				String CN_UF = bean.getCnUF();
//				String CN_TERMO = bean.getCnNTermo();
//				String CN_LIVRO = bean.getCnLivro();
//				String CN_FOLHA = bean.getCnFolha();
//				String CN_EMISSAO = bean.getCnDataEmissao();
//				String OBS_HIST = bean.getObsHist();
//				Boolean Falta_HE_Fundamental = bean.getFaltaEntregaHEFundamental();
//				Boolean Falta_HE_Medio = bean.getFaltaEntregaHEMedio();
//				Boolean Falta_Rg = bean.getFaltaEntregaRG();
//				Boolean Falta_CN = bean.getFaltaEntregaCN();
//				Boolean DADOS_CONFERIDOS = bean.getDadosConferidos();
//				String EF_Escola_conc = bean.getEnsFundEscolaConclusao();
//				String EF_Escola_conc_Local = bean.getEnsFundMunicipioEscolaConclusao();
//				String EF_Ano_Conc = bean.getEnsFundAnoEscolaConclusao();
//				String EF_Conc_Emissao = bean.getEnsFundDataEmissaoConclusao();
//				String EF_num_pag = bean.getEnsFundNumPaginasConclusao();

				statement.setString(1, nomeCompleto);
				statement.setString(2, matricula);
//				statement.setString(3, Data_conclusao_EM);
//				statement.setString(4, Data_nasc);
//				statement.setString(5, Pai);
//				statement.setString(6, Mae);
//				statement.setString(7, sexo);
//				statement.setString(8, nacionalidade);
//				statement.setString(9, naturalidadeUF);
//				statement.setString(10, naturalidade);
//				statement.setString(11, rg);
//				statement.setString(12, rg_emissor);
//				statement.setString(13, rg_emissor_UF);
//				statement.setString(14, rg_emissao);
//				statement.setString(15, CN_Cartorio);
//				statement.setString(16, CN_Municipio);
//				statement.setString(17, CN_UF);
//				statement.setString(18, CN_TERMO);
//				statement.setString(19, CN_LIVRO);
//				statement.setString(20, CN_FOLHA);
//				statement.setString(21, CN_EMISSAO);
//				statement.setString(22, OBS_HIST);
//				statement.setBoolean(23, Falta_HE_Fundamental);
//				statement.setBoolean(24, Falta_HE_Medio);
//				statement.setBoolean(25, Falta_Rg);
//				statement.setBoolean(26, Falta_CN);
//				statement.setBoolean(27, DADOS_CONFERIDOS);
//				statement.setString(28, EF_Escola_conc);
//				statement.setString(29, EF_Escola_conc_Local);
//				statement.setString(30, EF_Ano_Conc);
//				statement.setString(31, EF_Conc_Emissao);
//				statement.setString(32, EF_num_pag);
				statement.addBatch();

				if (count % batchSize == 0) {
					statement.executeBatch();
				}
			}

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
